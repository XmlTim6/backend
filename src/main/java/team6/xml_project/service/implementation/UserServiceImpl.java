package team6.xml_project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team6.xml_project.exception.UserNotFoundException;
import team6.xml_project.helpers.XMLUnmarshaller;
import team6.xml_project.models.User;
import team6.xml_project.models.xml.paper.Paper;
import team6.xml_project.models.xml.submission.Submission;
import team6.xml_project.repository.UserRepository;
import team6.xml_project.service.PaperService;
import team6.xml_project.service.SubmissionService;
import team6.xml_project.service.UserService;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private PaperService paperService;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findByIds(List<Long> ids) {
        return userRepository.findAllById(ids);
    }

    @Override
    public List<User> findRecommendedReviewersForSubmission(String submissionId, Long userId) throws JAXBException {
        Submission submission = submissionService.findById(submissionId);
        String paper = paperService.findPaper(String.format("/db/xml_project_tim6/papers/%s/revision_%s",
                submission.getId(), submission.getCurrentRevision()), "paper.xml", userId, submission.getId());
        Paper paperObject = XMLUnmarshaller.createPaperFromXML(paper);

        List<String> keywords = paperObject.getAbstract().getKeywords().getKeyword().stream().map(Paper.Abstract.Keywords.Keyword::getValue).collect(Collectors.toList());
        List<User> users = userRepository.findUsersDistinctByExpertiseIn(keywords);
        return users.stream().filter(user -> !user.getId().equals(submission.getAuthorId()) &&
                !user.getId().equals(submission.getEditorId())).collect(Collectors.toList());
    }

    @Override
    public User findByEmail(String email) { return userRepository.findUserByEmail(email).orElseThrow(UserNotFoundException::new);}

    @Override
    public void register(User user) {
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        this.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User oldUser, User updatedUser) {
        oldUser.setName(updatedUser.getName());
        oldUser.setSurname(updatedUser.getSurname());
        oldUser.setEmail(updatedUser.getEmail());
        if(!updatedUser.getPasswordHash().trim().equals("")){
            oldUser.setPasswordHash(passwordEncoder.encode(updatedUser.getPasswordHash()));
        }
        return this.save(oldUser);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
}
