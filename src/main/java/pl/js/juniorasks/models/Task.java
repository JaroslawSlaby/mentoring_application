package pl.js.juniorasks.models;

import java.util.Objects;

public final class Task {

    private final Mentee mentee;
    private final String content;

    public Task(Mentee mentee, String content) {
        this.mentee = mentee;
        this.content = content;
    }

    public Mentee getMentee() {
        return mentee;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(mentee, task.mentee) &&
                Objects.equals(content, task.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentee, content);
    }
}
