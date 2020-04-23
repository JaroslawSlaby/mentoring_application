package pl.js.juniorasks.taskoperations;

import org.springframework.stereotype.Service;
import pl.js.juniorasks.models.Task;
import pl.js.juniorasks.tools.InputValidator;

@Service
public class TaskService {

    private final TaskProcessor taskProcessor;

    public TaskService(TaskProcessor taskProcessor) {
        this.taskProcessor = taskProcessor;
    }

    public Task addTask(String menteeNick, String task) {
        InputValidator.validateStringValue(menteeNick);
        InputValidator.validateStringValue(task);

        return taskProcessor.createTaskForMentee(menteeNick, task);
    }
}
