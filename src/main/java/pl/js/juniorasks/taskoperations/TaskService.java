package pl.js.juniorasks.taskoperations;

import org.springframework.stereotype.Service;
import pl.js.juniorasks.models.Solution;
import pl.js.juniorasks.models.Task;

import static pl.js.juniorasks.tools.InputValidator.validateStringValue;

@Service
public class TaskService {

    private final TaskProcessor taskProcessor;
    private final SolutionProcessor solutionProcessor;

    public TaskService(TaskProcessor taskProcessor, SolutionProcessor solutionProcessor) {
        this.taskProcessor = taskProcessor;
        this.solutionProcessor = solutionProcessor;
    }

    public Task addTask(String mentorNick, String menteeNick, String task) {
        validateStringValue(mentorNick);
        validateStringValue(menteeNick);
        validateStringValue(task);

        return taskProcessor.createTaskForMentee(mentorNick, menteeNick, task);
    }

    public Solution addSolution(String menteeNick, String taskId, String solution) {
        validateStringValue(menteeNick);
        validateStringValue(taskId);
        validateStringValue(solution);

        return solutionProcessor.sendSolution(menteeNick, taskId, solution);
    }
}
