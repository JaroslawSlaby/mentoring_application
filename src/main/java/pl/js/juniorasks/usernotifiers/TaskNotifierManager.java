package pl.js.juniorasks.usernotifiers;

import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Mentor;
import pl.js.juniorasks.models.Solution;
import pl.js.juniorasks.models.Task;

public interface TaskNotifierManager {

    void notifyMentee(Mentee mentee, Task task);

    void notifyMentor(Mentor mentor, Solution solution);
}
