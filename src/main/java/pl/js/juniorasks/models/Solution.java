package pl.js.juniorasks.models;

import java.time.LocalDateTime;
import java.util.Objects;

public final class Solution {

    private final String solutionId;
    private final String menteeNick;
    private final String taskId;
    private final LocalDateTime solutionTimeStamp;
    private final String solutionContent;

    public Solution(String solutionId,
                    String menteeNick,
                    String taskId,
                    LocalDateTime solutionTimeStamp,
                    String solutionContent) {
        this.solutionId = solutionId;
        this.menteeNick = menteeNick;
        this.taskId = taskId;
        this.solutionTimeStamp = solutionTimeStamp;
        this.solutionContent = solutionContent;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution that = (Solution) o;
        return Objects.equals(solutionId, that.solutionId) &&
                Objects.equals(menteeNick, that.menteeNick) &&
                Objects.equals(taskId, that.taskId) &&
                Objects.equals(solutionContent, that.solutionContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(solutionId, menteeNick, taskId, solutionContent);
    }
}
