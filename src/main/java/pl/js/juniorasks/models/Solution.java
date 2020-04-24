package pl.js.juniorasks.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Solution {

    private final String menteeNick;
    private final String taskId;
    private final LocalDateTime solutionTimeStamp;
    private final String solutionContent;

    public Solution(String menteeNick, String taskId, LocalDateTime solutionTimeStamp, String solutionContent) {
        this.menteeNick = menteeNick;
        this.taskId = taskId;
        this.solutionTimeStamp = solutionTimeStamp;
        this.solutionContent = solutionContent;
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
