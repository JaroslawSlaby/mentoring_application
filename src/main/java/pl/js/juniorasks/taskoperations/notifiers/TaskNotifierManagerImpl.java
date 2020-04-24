package pl.js.juniorasks.taskoperations.notifiers;

import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Mentor;
import pl.js.juniorasks.models.NotifyChannel;
import pl.js.juniorasks.models.Solution;
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

    @Override
    public void notifyMentor(Mentor mentor, Solution solution) {
        mentor.getNotifyChannels().forEach(notifyChannel ->
                this.notifiers.get(notifyChannel).notify(mentor, solution));
    }

}
