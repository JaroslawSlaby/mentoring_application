package pl.js.juniorasks.assignment;

import pl.js.juniorasks.models.dtos.Mentor;

import static pl.js.juniorasks.tools.InputValidator.validateStringValue;

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
