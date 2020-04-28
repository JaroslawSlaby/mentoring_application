package pl.js.juniorasks.models;

import java.util.Objects;

public final class SolutionPrototype {

    private final String menteeNick;
    private final String taskId;
    private final String solutionContent;

    public SolutionPrototype(String menteeNick,
                             String taskId,
                             String solutionContent) {
        this.menteeNick = menteeNick;
        this.taskId = taskId;
        this.solutionContent = solutionContent;
    }

    public String getMenteeNick() {
        return menteeNick;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getSolutionContent() {
        return solutionContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolutionPrototype that = (SolutionPrototype) o;
        return Objects.equals(menteeNick, that.menteeNick) &&
                Objects.equals(taskId, that.taskId) &&
                Objects.equals(solutionContent, that.solutionContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menteeNick, taskId, solutionContent);
    }
}
