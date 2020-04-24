package pl.js.juniorasks.taskoperations;

import org.springframework.stereotype.Service;
import pl.js.juniorasks.models.Task;
import pl.js.juniorasks.solutionoperations.SolutionProcessor;

import static pl.js.juniorasks.tools.InputValidator.validateStringValue;

@Service
public class TaskService {

    private final TaskProcessor taskProcessor;

    public TaskService(TaskProcessor taskProcessor) {
        this.taskProcessor = taskProcessor;
    }

    public Task addTask(String mentorNick, String menteeNick, String task) {
        validateStringValue(mentorNick);
        validateStringValue(menteeNick);
        validateStringValue(task);

        return taskProcessor.createTaskForMentee(mentorNick, menteeNick, task);
    }
}
