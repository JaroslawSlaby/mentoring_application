package pl.js.juniorasks.models.dtos;

import java.util.HashSet;
import java.util.Set;

public class Mentor {

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
}
