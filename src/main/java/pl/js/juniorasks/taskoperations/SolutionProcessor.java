package pl.js.juniorasks.taskoperations;

import pl.js.juniorasks.dataproviders.MentorProvider;
import pl.js.juniorasks.dataproviders.SolutionProvider;
import pl.js.juniorasks.dataproviders.TaskProvider;
import pl.js.juniorasks.models.Mentor;
import pl.js.juniorasks.models.Solution;
import pl.js.juniorasks.models.Task;
import pl.js.juniorasks.taskoperations.notifiers.TaskNotifierManager;

import java.time.LocalDateTime;

public class SolutionProcessor {

    private final TaskProvider taskProvider;
    private final MentorProvider mentorProvider;
    private final SolutionProvider solutionProvider;
    private final TaskNotifierManager taskNotifierManager;

    public SolutionProcessor(TaskProvider taskProvider,
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
        Solution solution = new Solution(menteeNick, taskId, LocalDateTime.now(), solutionContent);
        solutionProvider.addSolution(solution);
        taskNotifierManager.notifyMentor(mentor, solution);
        return solution;
    }
}
