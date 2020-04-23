package pl.js.juniorasks.dataproviders;

import pl.js.juniorasks.models.Mentor;


public interface MentorProvider {

    Mentor getMentor(String mentorNick);

    void addMentor(Mentor mentor);

    void removeMentor(Mentor mentor);

}
