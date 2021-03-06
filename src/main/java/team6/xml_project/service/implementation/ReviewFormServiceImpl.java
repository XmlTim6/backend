package team6.xml_project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team6.xml_project.exception.*;
import team6.xml_project.helpers.XMLValidator;
import team6.xml_project.models.DocumentType;
import team6.xml_project.models.Role;
import team6.xml_project.models.SubmissionStatus;
import team6.xml_project.models.User;
import team6.xml_project.models.xml.submission.Submission;
import team6.xml_project.repository.ReviewFormRepository;
import team6.xml_project.repository.SubmissionRepository;
import team6.xml_project.service.PaperService;
import team6.xml_project.service.ReviewFormService;
import team6.xml_project.service.SubmissionService;
import team6.xml_project.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewFormServiceImpl implements ReviewFormService {

    @Autowired
    SubmissionService submissionService;

    @Autowired
    SubmissionRepository submissionRepository;

    @Autowired
    ReviewFormRepository reviewFormRepository;

    @Autowired
    PaperService paperService;

    @Autowired
    UserService userService;

    @Override
    public void save(String reviewForm, String submissionId, Long userId) throws Exception {
        Submission submission = submissionService.findById(submissionId);

        if (!submission.getSubmissionStatus().equals(SubmissionStatus.IN_REVIEW.toString()))
            throw new SubmissionClosedForReviews();

        if (submission.getReviewerIds().stream().noneMatch(r -> r.getReviewerId() == userId))
            throw new NotSubmissionAuthorException();

        try{
            XMLValidator validator= new XMLValidator();
            validator.validate(reviewForm, DocumentType.REVIEW_FORM);
            reviewFormRepository.save(reviewForm, submission, userId);
            if (checkIfAllReviewsAdded(submission))
                submissionService.handleAllReviewsAdded(submission);
        }catch (Exception e){
            throw new FailedToGenerateDocumentException();
        }
    }

    @Override
    public boolean checkIfReviewFormExists(Submission submission, String documentName) throws Exception {
        return reviewFormRepository.checkIfReviewFormExists(submission, documentName);
    }

    @Override
    public String findReviewForm(String submissionId, Long revision, String document, Long userId) {
        Submission submission = submissionService.findById(submissionId);
        User reviewer = userService.findById(userId);

        if ((submission.getReviewerIds().stream().noneMatch(r -> r.getReviewerId() == userId))
                && !(submission.getEditorId() == userId) && !(submission.getAuthorId() == userId))
            throw new PermissionDeniedException();
        if (reviewer.getRole() == Role.ROLE_AUTHOR){
            if(reviewer.getId() == submission.getAuthorId() && !document.equals("review_form_merged.xml")){
                throw new PermissionDeniedException();
            }else if(reviewer.getId() != submission.getAuthorId() && !document.equals(String.format("review_form_%s.xml", userId))){
                throw new PermissionDeniedException();
            }
        }
        if(!submission.getSubmissionStatus().equals(SubmissionStatus.REJECTED.toString()) && !submission.getSubmissionStatus().equals(SubmissionStatus.NEEDS_REWORK.toString())){
            if(reviewer.getId() == submission.getAuthorId()){
                throw new PermissionDeniedException();
            }
        }
            try {
            return reviewFormRepository.find(submissionId, revision, document);
        } catch (Exception e) {
            throw new SubmissionNotFoundException();
        }
    }

    @Override
    public List<String> findReviewFormURIsOfSubmission(String submissionId, Long userId) {
        Submission submission = submissionService.findById(submissionId);
        User user = userService.findById(userId);

        if ((submission.getReviewerIds().stream().noneMatch(r -> r.getReviewerId() == userId))
                && !(submission.getEditorId() == userId) && !(submission.getAuthorId() == userId))
            throw new PermissionDeniedException();

        List<String> reviewFormURIsOld;
        List<String> reviewFormURIs = new ArrayList<>();

        try {
            reviewFormURIsOld = reviewFormRepository.getAllReviewFormURIsOfSubmission(submissionId);
            for (String uri: reviewFormURIsOld) {
                int index = uri.indexOf("revision_") + "revision_".length();
                reviewFormURIs.add("http://localhost:3000/details/" + submissionId +
                        "/" + uri.substring(index, index + 1) +
                        "/" + uri.substring(index + 2));
            }
        } catch (Exception e) {
            throw new SubmissionNotFoundException();
        }

        if (user.getRole().equals(Role.ROLE_AUTHOR))
            if(user.getId() != submission.getAuthorId())
                return reviewFormURIs.stream().filter(rf -> rf.endsWith(String.format("review_form_%s.xml", userId)))
                        .collect(Collectors.toList());
            else{
                if(submission.getSubmissionStatus().equals(SubmissionStatus.REJECTED.toString()) || submission.getSubmissionStatus().equals(SubmissionStatus.NEEDS_REWORK.toString()))
                    return reviewFormURIs.stream().filter(rf -> rf.endsWith(("review_form_merged.xml")))
                            .collect(Collectors.toList());
                else{
                    throw new PermissionDeniedException();
                }
            }
        return reviewFormURIs;
    }

    public List<String> findReviewFormDocumentsOfSubmission(String submissionId, Long revision) throws Exception{
        return reviewFormRepository.getAllReviewFormDocumentsOfSubmission(submissionId, revision);
    }

    private boolean checkIfAllReviewsAdded(Submission submission) throws Exception {
        List<Long> userIds = submission.getReviewerIds().stream().map(Submission.ReviewerIds::getReviewerId).
                collect(Collectors.toList());

        for (Long id : userIds) {
            boolean exists = paperService.checkIfPaperExists(submission, String.format("review_%s.xml", id));
            if (!exists)
                return false;
            exists = checkIfReviewFormExists(submission, String.format("review_form_%s.xml", id));
            if (!exists)
                return false;
        }
        return true;
    }
}
