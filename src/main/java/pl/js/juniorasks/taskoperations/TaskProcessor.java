package pl.js.juniorasks.taskoperations;

import pl.js.juniorasks.dataproviders.MenteeProvider;
import pl.js.juniorasks.dataproviders.TaskProvider;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Task;

public class TaskProcessor {

    private final MenteeProvider menteeProvider;
    private final TaskProvider taskProvider;
    private final TaskNotifier taskNotifier;

    public TaskProcessor(MenteeProvider menteeProvider,
                         TaskProvider taskProvider,
                         TaskNotifier taskNotifier) {
        this.menteeProvider = menteeProvider;
        this.taskProvider = taskProvider;
        this.taskNotifier = taskNotifier;
    }

    public Task createTaskForMentee(String menteeNick, String taskContent) {
        Mentee mentee = menteeProvider.getMentee(menteeNick);
        Task task = new Task(mentee, taskContent);
        taskProvider.addTask(task);
        taskNotifier.notifyMentee(mentee, task);
        return task;
    }

}
