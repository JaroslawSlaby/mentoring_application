package pl.js.juniorasks.taskoperations;

import org.springframework.stereotype.Service;
import pl.js.juniorasks.models.Task;
import pl.js.juniorasks.models.TaskPrototype;

import static pl.js.juniorasks.tools.InputValidator.validateObjectValue;
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

    public Task addTask(TaskPrototype taskPrototype) {
        validateObjectValue(taskPrototype);

        return taskProcessor.createTaskForMentee(taskPrototype);
    }
}
