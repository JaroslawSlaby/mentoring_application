package pl.js.juniorasks.solutionoperations;

import org.springframework.stereotype.Service;
import pl.js.juniorasks.models.Rate;
import pl.js.juniorasks.models.Solution;
import pl.js.juniorasks.solutionoperations.rating.SolutionRatingProcessor;
import pl.js.juniorasks.solutionoperations.sending.SolutionSendingProcessor;

import static pl.js.juniorasks.tools.InputValidator.validateStringValue;

@Service
public class SolutionService {

    private final SolutionProcessor solutionProcessor;
    private final SolutionSendingProcessor solutionSendingProcessor;
    private final SolutionRatingProcessor solutionRatingProcessor;

    public SolutionService(SolutionProcessor solutionProcessor, SolutionSendingProcessor solutionSendingProcessor, SolutionRatingProcessor solutionRatingProcessor) {
        this.solutionProcessor = solutionProcessor;
        this.solutionSendingProcessor = solutionSendingProcessor;
        this.solutionRatingProcessor = solutionRatingProcessor;
    }

    public Solution getSolution(String solutionId) {
        validateStringValue(solutionId);

        return solutionProcessor.getSolution(solutionId);
    }

    public Solution addSolution(String menteeNick, String taskId, String solution) {
        validateStringValue(menteeNick);
        validateStringValue(taskId);
        validateStringValue(solution);

        return solutionSendingProcessor.sendSolution(menteeNick, taskId, solution);
    }

    public Rate rateSolution(String solutionId, String rate) {
        validateStringValue(solutionId);
        validateStringValue(rate);

        return solutionRatingProcessor.rateSolution(solutionId, rate);
    }
}
