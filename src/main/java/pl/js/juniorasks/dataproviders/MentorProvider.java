package pl.js.juniorasks.dataproviders;

import pl.js.juniorasks.models.Mentor;


public interface MentorProvider {

    Mentor getMentor(String mentorNick);

    Mentor getMentorBasedOnTaskId(String taskId);

    void addMentor(Mentor mentor);

    void removeMentor(Mentor mentor);

}
