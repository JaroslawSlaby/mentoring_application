package pl.js.juniorasks.models;

import java.util.Objects;

public final class Task {

    private final String menteeNick;
    private final String content;

    public Task(String menteeNick, String content) {
        this.menteeNick = menteeNick;
        this.content = content;
    }

    public String getMenteeNick() {
        return menteeNick;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(menteeNick, task.menteeNick) &&
                Objects.equals(content, task.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menteeNick, content);
    }
}
