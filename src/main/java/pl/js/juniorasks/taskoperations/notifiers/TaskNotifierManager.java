package pl.js.juniorasks.taskoperations.notifiers;

import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Task;

public interface TaskNotifierManager {
    void notifyMentee(Mentee mentee, Task task);
}
