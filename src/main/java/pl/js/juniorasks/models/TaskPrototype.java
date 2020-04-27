package pl.js.juniorasks.models;

import java.util.Objects;

public final class TaskPrototype {

    private final String menteeNick;
    private final String mentorNick;
    private final String content;

    public TaskPrototype(String menteeNick, String mentorNick, String content) {
        this.menteeNick = menteeNick;
        this.mentorNick = mentorNick;
        this.content = content;
    }

    public String getMenteeNick() {
        return menteeNick;
    }

    public String getContent() {
        return content;
    }

    public String getMentorNick() {
        return mentorNick;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskPrototype task = (TaskPrototype) o;
        return Objects.equals(menteeNick, task.menteeNick) &&
                Objects.equals(mentorNick, task.mentorNick) &&
                Objects.equals(content, task.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menteeNick, mentorNick, content);
    }

}
