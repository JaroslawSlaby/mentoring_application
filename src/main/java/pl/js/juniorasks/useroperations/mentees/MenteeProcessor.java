package pl.js.juniorasks.useroperations.mentees;

import pl.js.juniorasks.dataproviders.mentees.MenteeProvider;
import pl.js.juniorasks.models.Mentee;

public class MenteeProcessor {

    private final MenteeProvider menteeProvider;

    public MenteeProcessor(MenteeProvider menteeProvider) {
        this.menteeProvider = menteeProvider;
    }

    public Mentee getMentee(String menteeNick) {
        return menteeProvider.getMentee(menteeNick);
    }

    public Mentee addMentee(Mentee mentee) {
        menteeProvider.saveMentee(mentee);
        return mentee;
    }

    public Mentee removeMentee(String menteeNick) {
        return menteeProvider.removeMentee(menteeNick);
    }
}
