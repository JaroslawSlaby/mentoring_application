package pl.js.juniorasks.dataproviders.mentors;

import pl.js.juniorasks.models.Mentor;

public interface MentorProvider {

    Mentor getMentor(String mentorNick);

    void saveMentor(Mentor mentor);

    Mentor removeMentor(String mentorNick);

}
