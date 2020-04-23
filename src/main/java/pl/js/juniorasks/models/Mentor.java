package pl.js.juniorasks.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Mentor {

    private final String nick;

    private final Set<Mentee> assignedMentees = new HashSet<>();

    public Mentor(String nick) {
        this.nick = nick;
    }

    public void assignMentee(Mentee mentee) {
        this.assignedMentees.add(mentee);
    }

    public void removeMentee(Mentee mentee) {
        this.assignedMentees.remove(mentee);
    }

    public boolean hasMentees() {
        return !this.assignedMentees.isEmpty();
    }

    public int getNumberOfMentees() {
        return this.assignedMentees.size();
    }

    public String getNick() {
        return nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mentor mentor = (Mentor) o;
        return Objects.equals(nick, mentor.nick) &&
                Objects.equals(assignedMentees, mentor.assignedMentees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, assignedMentees);
    }
}
