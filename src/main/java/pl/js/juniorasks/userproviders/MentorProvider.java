package pl.js.juniorasks.userproviders;

import pl.js.juniorasks.models.dtos.Mentor;


public interface MentorProvider {

    Mentor getMentor(String mentorNick);

    void addMentor(Mentor mentor);

    void removeMentor(Mentor mentor);

}
