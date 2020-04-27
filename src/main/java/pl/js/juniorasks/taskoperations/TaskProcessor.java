package pl.js.juniorasks.taskoperations;

import pl.js.juniorasks.dataproviders.MenteeProvider;
import pl.js.juniorasks.dataproviders.TaskProvider;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Task;
import pl.js.juniorasks.models.TaskPrototype;
import pl.js.juniorasks.usernotifiers.NotifierManager;
import pl.js.juniorasks.tools.IDGenerator;

public class TaskProcessor {

    private final MenteeProvider menteeProvider;
    private final TaskProvider taskProvider;
    private final NotifierManager notifierManager;

    public TaskProcessor(MenteeProvider menteeProvider,
                         TaskProvider taskProvider,
                         NotifierManager notifiermanager) {
        this.menteeProvider = menteeProvider;
        this.taskProvider = taskProvider;
        this.notifierManager = notifiermanager;
    }

    public Task getTask(String taskId) {
        return taskProvider.getTask(taskId);
    }

    public Task createTaskForMentee(TaskPrototype taskPrototype) {
        String menteeNick = taskPrototype.getMenteeNick();
        Mentee mentee = menteeProvider.getMentee(menteeNick);
        Task task = new Task(menteeNick,
                taskPrototype.getMentorNick(),
                IDGenerator.getNextId(),
                taskPrototype.getContent());
        taskProvider.addTask(task);
        notifierManager.notifyUser(mentee, task);
        return task;
    }
}
