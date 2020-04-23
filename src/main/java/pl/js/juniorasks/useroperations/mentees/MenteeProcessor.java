package pl.js.juniorasks.useroperations.mentees;

import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.dataproviders.MenteeProvider;

public class MenteeProcessor {

    private final MenteeProvider menteeProvider;

    public MenteeProcessor(MenteeProvider menteeProvider) {
        this.menteeProvider = menteeProvider;
    }

    public Mentee getMentee(String menteeNick) {
        return menteeProvider.getMentee(menteeNick);
    }

    public Mentee addMentee(String menteeNick) {
        Mentee mentee = new Mentee(menteeNick);
        menteeProvider.addMentee(mentee);
        return mentee;
    }

    public Mentee removeMentee(String menteeNick) {
        Mentee mentee = menteeProvider.getMentee(menteeNick);
        menteeProvider.removeMentee(mentee);
        return mentee;
    }
}
