package pl.js.juniorasks.models;

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
}
