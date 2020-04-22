package pl.js.juniorasks.assignment;

import pl.js.juniorasks.models.Mentor;

public class AssignmentService {

    private final AssignmentProcessor assignmentProcessor;

    public AssignmentService(AssignmentProcessor assignmentProcessor) {
        this.assignmentProcessor = assignmentProcessor;
    }

    public Mentor assignMentee(String mentorNick, String menteeNick) {
        validateInputData(mentorNick);
        validateInputData(menteeNick);

        return assignmentProcessor.assignMenteeToMentor(mentorNick, menteeNick);
    }

    public Mentor removeMentee(String mentorNick, String menteeNick) {
        validateInputData(mentorNick);
        validateInputData(menteeNick);

        return assignmentProcessor.removeMenteeFromMentor(mentorNick, menteeNick);
    }

    private void validateInputData(String value) {
        if(value == null || value.isEmpty()) {
            throw new RuntimeException(); //todo: add custom exception
        }
    }
}
