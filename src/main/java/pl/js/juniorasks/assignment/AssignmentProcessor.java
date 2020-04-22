package pl.js.juniorasks.assignment;

import pl.js.juniorasks.users.MenteeProvider;
import pl.js.juniorasks.users.MentorProvider;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Mentor;

import java.util.Optional;

public class AssignmentProcessor {

    private final MentorProvider mentorProvider;
    private final MenteeProvider menteeProvider;

    public AssignmentProcessor(MentorProvider mentorProvider, MenteeProvider menteeProvider) {
        this.mentorProvider = mentorProvider;
        this.menteeProvider = menteeProvider;
    }

    public Mentor assignMenteeToMentor(String mentorNick, String menteeNick) {
        Mentor mentor = getMentor(mentorNick);
        Mentee mentee = getMentee(menteeNick);
        mentor.assignMentee(mentee);
        return mentor;
    }

    public Mentor removeMenteeFromMentor(String mentorNick, String menteeNick) {
        Mentor mentor = getMentor(mentorNick);
        Mentee mentee = getMentee(menteeNick);
        mentor.removeMentee(mentee);
        return mentor;
    }

    private Mentor getMentor(String mentorNick) {
        Optional<Mentor> mentorOptional = mentorProvider.getMentor(mentorNick);
        return mentorOptional.orElseThrow(() -> new NoSuchUserException("No such mentor"));
    }

    private Mentee getMentee(String menteeNick) {
        Optional<Mentee> menteeOptional = menteeProvider.getMentee(menteeNick);
        return menteeOptional.orElseThrow(() -> new NoSuchUserException("No such mentee")); //todo: maybe one exception with enum inside
    }

}
