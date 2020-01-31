package team6.xml_project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team6.xml_project.exception.SubmissionClosedForCoverLetters;
import team6.xml_project.models.SubmissionStatus;
import team6.xml_project.models.User;
import team6.xml_project.models.xml.cover_letter.CoverLetter;
import team6.xml_project.models.xml.submission.Submission;
import team6.xml_project.repository.DocumentRepository;
import team6.xml_project.service.CoverLetterService;
import team6.xml_project.service.SubmissionService;
import team6.xml_project.service.UserService;

@Service
public class CoverLetterServiceImpl implements CoverLetterService {

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    SubmissionService submissionService;

    @Autowired
    UserService userService;

    @Override
    public void save(String coverLetter, String submissionId, Long userId) throws Exception {
        Submission submission = submissionService.findById(submissionId);
        User reviewer = userService.findById(userId);

        if (!submission.getSubmissionStatus().equals(SubmissionStatus.SUBMITTED_FOR_REVIEW.toString())) {
            throw new SubmissionClosedForCoverLetters();
        }

    }
}
