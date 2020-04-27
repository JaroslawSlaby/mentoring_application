package pl.js.juniorasks.solutionoperations.sending;

import pl.js.juniorasks.dataproviders.MentorProvider;
import pl.js.juniorasks.dataproviders.SolutionProvider;
import pl.js.juniorasks.models.SolutionPrototype;
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

    public Solution sendSolution(SolutionPrototype solution) {
        Mentor mentor = mentorProvider.getMentorBasedOnTaskId(solution.getTaskId());
        Solution outputSolution = new Solution(IDGenerator.getNextId(),
                solution.getMenteeNick(),
                solution.getTaskId(),
                LocalDateTime.now(),
                solution.getSolutionContent());
        solutionProvider.addSolution(outputSolution);
        notifierManager.notifyUser(mentor, outputSolution);
        return outputSolution;
    }
}
