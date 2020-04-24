package pl.js.juniorasks.useroperations.mentors;

import pl.js.juniorasks.models.Mentor;
import pl.js.juniorasks.dataproviders.MentorProvider;
import pl.js.juniorasks.models.NotifyChannel;

public class MentorProcessor {

    private final MentorProvider mentorProvider;

    public MentorProcessor(MentorProvider mentorProvider) {
        this.mentorProvider = mentorProvider;
    }

    public Mentor getMentor(String mentorNick) {
        return mentorProvider.getMentor(mentorNick);
    }

    public Mentor addMentor(String mentorNick, String email) {
        Mentor mentor = new Mentor(mentorNick, email);
        mentor.addNotifyChannel(NotifyChannel.MAIL);
        mentorProvider.addMentor(mentor);
        return mentor;
    }

    public Mentor removeMentor(String mentorNick) {
        Mentor mentor = mentorProvider.getMentor(mentorNick);
        mentorProvider.removeMentor(mentor);
        return mentor;
    }
}
