package pl.js.juniorasks.models;

import java.util.Objects;

public final class Task implements Notification {

    private final String menteeNick;
    private final String mentorNick;
    private final String id;
    private final String content;

    public Task(String menteeNick, String mentorNick, String id, String content) {
        this.menteeNick = menteeNick;
        this.mentorNick = mentorNick;
        this.id = id;
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

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(menteeNick, task.menteeNick) &&
                Objects.equals(mentorNick, task.mentorNick) &&
                Objects.equals(id, task.id) &&
                Objects.equals(content, task.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menteeNick, mentorNick, id, content);
    }

    @Override
    public String getHTMLRepresentation() {
        return "<h3> New task for " + menteeNick + "</h3>\n" +
                "<h5> Author: " + mentorNick + "</h5>\n\n" +
                "<p>" + content + "</p>\n" +
                "<h5>Good luck!</h5>";
    }
}
