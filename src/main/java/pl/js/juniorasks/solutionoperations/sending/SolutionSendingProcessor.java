package pl.js.juniorasks.solutionoperations.sending;

import pl.js.juniorasks.dataproviders.TaskProvider;
import pl.js.juniorasks.dataproviders.mentors.MentorProvider;
import pl.js.juniorasks.dataproviders.SolutionProvider;
import pl.js.juniorasks.models.SolutionPrototype;
import pl.js.juniorasks.models.Mentor;
import pl.js.juniorasks.models.Solution;
import pl.js.juniorasks.tools.IDGenerator;
import pl.js.juniorasks.usernotifiers.NotifierManager;

import java.time.LocalDateTime;

public class SolutionSendingProcessor {

    private final MentorProvider mentorProvider;
    private final TaskProvider taskProvider;
    private final SolutionProvider solutionProvider;
    private final NotifierManager notifierManager;

    public SolutionSendingProcessor(MentorProvider mentorProvider,
                                    TaskProvider taskProvider, SolutionProvider solutionProvider,
                                    NotifierManager notifierManager) {
        this.mentorProvider = mentorProvider;
        this.taskProvider = taskProvider;
        this.solutionProvider = solutionProvider;
        this.notifierManager = notifierManager;
    }

    public Solution sendSolution(SolutionPrototype solution) {
        String mentorNick = taskProvider.getMentorNickBasedOnTaskId(solution.getTaskId());
        Mentor mentor = mentorProvider.getMentor(mentorNick);
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
