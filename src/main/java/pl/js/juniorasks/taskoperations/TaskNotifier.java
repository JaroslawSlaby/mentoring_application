package pl.js.juniorasks.taskoperations;

import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Task;

public interface TaskNotifier {
    void notifyMentee(Mentee mentee, Task task);
}
