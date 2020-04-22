package pl.js.juniorasks.useroperations.mentors;

import pl.js.juniorasks.models.dtos.Mentor;

import static pl.js.juniorasks.tools.InputValidator.validateStringValue;

public class MentorService {

    private final MentorProcessor mentorProcessor;

    public MentorService(MentorProcessor mentorProcessor) {
        this.mentorProcessor = mentorProcessor;
    }

    public Mentor getMentor(String mentorNick) {
        validateStringValue(mentorNick);
        return mentorProcessor.getMentor(mentorNick);
    }

    public Mentor addMentor(String mentorNick) {
        validateStringValue(mentorNick);
        return mentorProcessor.addMentor(mentorNick);
    }

    public Mentor removeMentor(String mentorNick) {
        validateStringValue(mentorNick);
        return mentorProcessor.removeMentor(mentorNick);
    }
}
