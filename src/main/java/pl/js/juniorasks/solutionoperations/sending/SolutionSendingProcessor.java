package pl.js.juniorasks.solutionoperations.sending;

import pl.js.juniorasks.dataproviders.MentorProvider;
import pl.js.juniorasks.dataproviders.SolutionProvider;
import pl.js.juniorasks.dataproviders.TaskProvider;
import pl.js.juniorasks.models.Mentor;
import pl.js.juniorasks.models.Solution;
import pl.js.juniorasks.tools.IDGenerator;
import pl.js.juniorasks.usernotifiers.NotifierManager;

import java.time.LocalDateTime;

public class SolutionSendingProcessor {

    private final MentorProvider mentorProvider;
    private final SolutionProvider solutionProvider;
    private final NotifierManager notifierManager;

    public SolutionSendingProcessor(MentorProvider mentorProvider,
                                    SolutionProvider solutionProvider,
                                    NotifierManager notifierManager) {
        this.mentorProvider = mentorProvider;
        this.solutionProvider = solutionProvider;
        this.notifierManager = notifierManager;
    }

    public Solution sendSolution(String menteeNick, String taskId, String solutionContent) {
        Mentor mentor = mentorProvider.getMentorBasedOnTaskId(taskId);
        Solution solution = new Solution(IDGenerator.getNextId(),
                menteeNick,
                taskId,
                LocalDateTime.now(),
                solutionContent);
        solutionProvider.addSolution(solution);
        notifierManager.notifyUser(mentor, solution);
        return solution;
    }
}
