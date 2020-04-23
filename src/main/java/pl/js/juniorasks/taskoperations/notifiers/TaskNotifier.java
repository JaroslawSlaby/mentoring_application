package pl.js.juniorasks.taskoperations.notifiers;

import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Task;

public interface TaskNotifier {
    //todo: add more notifiers
    void notify(Mentee mentee, Task task);
}
