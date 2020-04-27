package pl.js.juniorasks.assignmentoperations;

import org.springframework.stereotype.Service;
import pl.js.juniorasks.models.Mentor;

import static pl.js.juniorasks.tools.InputValidator.validateStringValue;

@Service
public class AssignmentService {

    private final AssignmentProcessor assignmentProcessor;

    public AssignmentService(AssignmentProcessor assignmentProcessor) {
        this.assignmentProcessor = assignmentProcessor;
    }

    public Mentor assignMentee(String mentorNick, String menteeNick) {
        validateStringValue(mentorNick);
        validateStringValue(menteeNick);

        return assignmentProcessor.assignMenteeToMentor(mentorNick, menteeNick);
    }

    public Mentor removeMentee(String mentorNick, String menteeNick) {
        validateStringValue(mentorNick);
        validateStringValue(menteeNick);

        return assignmentProcessor.removeMenteeFromMentor(mentorNick, menteeNick);
    }
}
