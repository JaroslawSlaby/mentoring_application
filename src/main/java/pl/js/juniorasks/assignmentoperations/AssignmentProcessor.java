package pl.js.juniorasks.assignmentoperations;

import pl.js.juniorasks.dataproviders.mentees.MenteeProvider;
import pl.js.juniorasks.dataproviders.mentors.MentorProvider;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Mentor;

public class AssignmentProcessor {

    private final MentorProvider mentorProvider;
    private final MenteeProvider menteeProvider;

    public AssignmentProcessor(MentorProvider mentorProvider, MenteeProvider menteeProvider) {
        this.mentorProvider = mentorProvider;
        this.menteeProvider = menteeProvider;
    }

    public Mentor assignMenteeToMentor(String mentorNick, String menteeNick) {
        Mentor mentor = mentorProvider.getMentor(mentorNick);
        if (menteeProvider.exists(menteeNick)) {
            mentor.assignMentee(menteeNick);
            mentorProvider.saveMentor(mentor);
            return mentor;
        }
        throw new RuntimeException(); //todo no such mentee
    }

    public Mentor removeMenteeFromMentor(String mentorNick, String menteeNick) {
        Mentor mentor = mentorProvider.getMentor(mentorNick);
        if (menteeProvider.exists(menteeNick)) {
            mentor.removeMentee(menteeNick);
            mentorProvider.saveMentor(mentor);
            return mentor;
        }
        throw new RuntimeException(); //todo no such mentee
    }

}
