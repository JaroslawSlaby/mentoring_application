package pl.js.juniorasks.solutionoperations;

import org.springframework.stereotype.Service;
import pl.js.juniorasks.models.Solution;

import static pl.js.juniorasks.tools.InputValidator.validateStringValue;

@Service
public class SolutionService {

    private final SolutionProcessor solutionProcessor;

    public SolutionService(SolutionProcessor solutionProcessor) {
        this.solutionProcessor = solutionProcessor;
    }

    public Solution addSolution(String menteeNick, String taskId, String solution) {
        validateStringValue(menteeNick);
        validateStringValue(taskId);
        validateStringValue(solution);

        return solutionProcessor.sendSolution(menteeNick, taskId, solution);
    }
}
