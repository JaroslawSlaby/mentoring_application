package pl.js.juniorasks.assignment;

import pl.js.juniorasks.userproviders.MenteeProvider;
import pl.js.juniorasks.userproviders.MentorProvider;
import pl.js.juniorasks.models.dtos.Mentee;
import pl.js.juniorasks.models.dtos.Mentor;

public class AssignmentProcessor {

    private final MentorProvider mentorProvider;
    private final MenteeProvider menteeProvider;

    public AssignmentProcessor(MentorProvider mentorProvider, MenteeProvider menteeProvider) {
        this.mentorProvider = mentorProvider;
        this.menteeProvider = menteeProvider;
    }

    public Mentor assignMenteeToMentor(String mentorNick, String menteeNick) {
        Mentor mentor = mentorProvider.getMentor(mentorNick);
        Mentee mentee = menteeProvider.getMentee(menteeNick);
        mentor.assignMentee(mentee);
        return mentor;
    }

    public Mentor removeMenteeFromMentor(String mentorNick, String menteeNick) {
        Mentor mentor = mentorProvider.getMentor(mentorNick);
        Mentee mentee = menteeProvider.getMentee(menteeNick);
        mentor.removeMentee(mentee);
        return mentor;
    }

}
