package pl.js.juniorasks.useroperations.mentors;

import pl.js.juniorasks.models.dtos.Mentor;
import pl.js.juniorasks.userproviders.MentorProvider;

public class MentorProcessor {

    private final MentorProvider mentorProvider;

    public MentorProcessor(MentorProvider mentorProvider) {
        this.mentorProvider = mentorProvider;
    }

    public Mentor getMentor(String mentorNick) {
        return mentorProvider.getMentor(mentorNick);
    }

    public Mentor addMentor(String mentorNick) {
        Mentor mentor = new Mentor(mentorNick);
        mentorProvider.addMentor(mentor);
        return mentor;
    }

    public Mentor removeMentor(String mentorNick) {
        Mentor mentor = mentorProvider.getMentor(mentorNick);
        mentorProvider.removeMentor(mentor);
        return mentor;
    }
}
