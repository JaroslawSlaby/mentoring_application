package pl.js.juniorasks.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Solution {

    private final String solutionId;
    private final String menteeNick;
    private final String taskId;
    private final LocalDateTime solutionTimeStamp;
    private final String solutionContent;
    private Rate rate = Rate.F;

    public Solution(String solutionId,
                    String menteeNick,
                    String taskId,
                    LocalDateTime solutionTimeStamp,
                    String solutionContent) { //todo: consider builder pattern
        this.solutionId = solutionId;
        this.menteeNick = menteeNick;
        this.taskId = taskId;
        this.solutionTimeStamp = solutionTimeStamp;
        this.solutionContent = solutionContent;
    }

    public void rateSolution(Rate rate) {
        this.rate = rate;
    }

    public String getSolutionId() {
        return solutionId;
    }

    public String getMenteeNick() {
        return menteeNick;
    }

    public String getTaskId() {
        return taskId;
    }

    public LocalDateTime getSolutionTimeStamp() {
        return solutionTimeStamp;
    }

    public String getSolutionContent() {
        return solutionContent;
    }

    public Rate getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(menteeNick, solution.menteeNick) &&
                Objects.equals(taskId, solution.taskId) &&
                Objects.equals(solutionContent, solution.solutionContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menteeNick, taskId, solutionContent);
    }
}
