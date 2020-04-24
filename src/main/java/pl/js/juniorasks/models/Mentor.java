package pl.js.juniorasks.models;

import java.util.HashSet;
import java.util.Set;

public final class Mentor extends User {

    private final Set<Mentee> assignedMentees = new HashSet<>();

    public Mentor(String nick, String email) {
        super(nick, email);
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


}
