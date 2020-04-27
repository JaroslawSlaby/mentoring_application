package pl.js.juniorasks.solutionoperations;

import pl.js.juniorasks.dataproviders.SolutionProvider;
import pl.js.juniorasks.models.Solution;

public class SolutionProcessor {

    private final SolutionProvider solutionProvider;

    public SolutionProcessor(SolutionProvider solutionProvider) {
        this.solutionProvider = solutionProvider;
    }

    public Solution getSolution(String solutionId) {
        return solutionProvider.getSolution(solutionId);
    }
}
