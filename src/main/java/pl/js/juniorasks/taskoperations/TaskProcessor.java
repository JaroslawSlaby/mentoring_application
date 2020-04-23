package pl.js.juniorasks.taskoperations;

import pl.js.juniorasks.dataproviders.MenteeProvider;
import pl.js.juniorasks.dataproviders.TaskProvider;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Task;
import pl.js.juniorasks.taskoperations.notifiers.TaskNotifierManager;

public class TaskProcessor {

    private final MenteeProvider menteeProvider;
    private final TaskProvider taskProvider;
    private final TaskNotifierManager taskNotifiermanager;

    public TaskProcessor(MenteeProvider menteeProvider,
                         TaskProvider taskProvider,
                         TaskNotifierManager taskNotifiermanager) {
        this.menteeProvider = menteeProvider;
        this.taskProvider = taskProvider;
        this.taskNotifiermanager = taskNotifiermanager;
    }

    public Task createTaskForMentee(String menteeNick, String taskContent) {
        Mentee mentee = menteeProvider.getMentee(menteeNick);
        Task task = new Task(menteeNick, taskContent);
        taskProvider.addTask(task);
        taskNotifiermanager.notifyMentee(mentee, task);
        return task;
    }

}
