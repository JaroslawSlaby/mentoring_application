package pl.js.juniorasks.taskoperations;

import pl.js.juniorasks.dataproviders.MenteeProvider;
import pl.js.juniorasks.dataproviders.TaskProvider;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Task;
import pl.js.juniorasks.taskoperations.notifiers.TaskNotifierManager;
import pl.js.juniorasks.tools.TaskIDGenerator;

public class TaskProcessor {

    private final MenteeProvider menteeProvider;
    private final TaskProvider taskProvider;
    private final TaskNotifierManager taskNotifierManager;

    public TaskProcessor(MenteeProvider menteeProvider,
                         TaskProvider taskProvider,
                         TaskNotifierManager taskNotifiermanager) {
        this.menteeProvider = menteeProvider;
        this.taskProvider = taskProvider;
        this.taskNotifierManager = taskNotifiermanager;
    }

    public Task createTaskForMentee(String mentorNick, String menteeNick, String taskContent) {
        Mentee mentee = menteeProvider.getMentee(menteeNick);
        Task task = new Task(menteeNick, mentorNick, TaskIDGenerator.getNextTaskId(), taskContent);
        taskProvider.addTask(task);
        taskNotifierManager.notifyMentee(mentee, task);
        return task;
    }

}
