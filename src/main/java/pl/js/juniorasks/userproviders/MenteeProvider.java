package pl.js.juniorasks.userproviders;

import pl.js.juniorasks.models.dtos.Mentee;

public interface MenteeProvider {

    Mentee getMentee(String menteeNick);

    void addMentee(Mentee mentee);

    void removeMentee(Mentee mentee);

}
