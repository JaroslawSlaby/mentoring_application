package pl.js.juniorasks.solutionoperations.sending;

import pl.js.juniorasks.dataproviders.MentorProvider;
import pl.js.juniorasks.dataproviders.SolutionProvider;
import pl.js.juniorasks.dataproviders.TaskProvider;
import pl.js.juniorasks.models.Mentor;
import pl.js.juniorasks.models.Solution;
import pl.js.juniorasks.models.Task;
import pl.js.juniorasks.tools.IDGenerator;
import pl.js.juniorasks.usernotifiers.TaskNotifierManager;

import java.time.LocalDateTime;

public class SolutionSendingProcessor {

    private final TaskProvider taskProvider;
    private final MentorProvider mentorProvider;
    private final SolutionProvider solutionProvider;
    private final TaskNotifierManager taskNotifierManager;

    public SolutionSendingProcessor(TaskProvider taskProvider,
                                    MentorProvider mentorProvider,
                                    SolutionProvider solutionProvider,
                                    TaskNotifierManager taskNotifierManager) {
        this.taskProvider = taskProvider;
        this.mentorProvider = mentorProvider;
        this.solutionProvider = solutionProvider;
        this.taskNotifierManager = taskNotifierManager;
    }

    public Solution sendSolution(String menteeNick, String taskId, String solutionContent) {
        Task task = taskProvider.getTask(taskId);
        Mentor mentor = mentorProvider.getMentor(task.getMentorNick());
        Solution solution = new Solution(IDGenerator.getNextId(),
                menteeNick,
                taskId,
                LocalDateTime.now(),
                solutionContent);
        solutionProvider.addSolution(solution);
        taskNotifierManager.notifyUser(mentor, solution);
        return solution;
    }
}
