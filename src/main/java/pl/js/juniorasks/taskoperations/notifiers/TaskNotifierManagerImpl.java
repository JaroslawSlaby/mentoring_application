package pl.js.juniorasks.taskoperations.notifiers;

import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.NotifyChannel;
import pl.js.juniorasks.models.Task;

import java.util.Map;

public class TaskNotifierManagerImpl implements TaskNotifierManager {

    private final Map<NotifyChannel, TaskNotifier> notifiers;

    public TaskNotifierManagerImpl(Map<NotifyChannel, TaskNotifier> notifiers) {
        this.notifiers = notifiers;
    }

    @Override
    public void notifyMentee(Mentee mentee, Task task) {
        mentee.getNotifyChannels().forEach(notifyChannel ->
                this.notifiers.get(notifyChannel).notify(mentee, task));
    }

}
