package pl.js.juniorasks.dataproviders.mentees;

import pl.js.juniorasks.models.Mentee;

public interface MenteeProvider {

    Mentee getMentee(String menteeNick);

    void saveMentee(Mentee mentee);

    Mentee removeMentee(String menteeNick);

    Boolean exists(String menteeNick);
}
