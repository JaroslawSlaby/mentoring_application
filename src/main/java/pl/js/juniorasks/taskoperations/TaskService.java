package pl.js.juniorasks.taskoperations;

import org.springframework.stereotype.Service;
import pl.js.juniorasks.models.Task;

import static pl.js.juniorasks.tools.InputValidator.validateStringValue;

@Service
public class TaskService {

    private final TaskProcessor taskProcessor;

    public TaskService(TaskProcessor taskProcessor) {
        this.taskProcessor = taskProcessor;
    }

    public Task getTask(String taskId) {
        validateStringValue(taskId);

        return taskProcessor.getTask(taskId);
    }

    public Task addTask(String mentorNick, String menteeNick, String task) {
        validateStringValue(mentorNick);
        validateStringValue(menteeNick);
        validateStringValue(task);

        return taskProcessor.createTaskForMentee(mentorNick, menteeNick, task);
    }
}
