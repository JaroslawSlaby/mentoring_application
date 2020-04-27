package pl.js.juniorasks.dataproviders;

import pl.js.juniorasks.models.Rate;
import pl.js.juniorasks.models.Solution;

public interface SolutionProvider {

    Solution getSolution(String solutionId);

    void addSolution(Solution solution);

    void rateSolution(Solution solution, Rate rate);
}
