package pl.js.juniorasks.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Mentor implements User {

    private final String nick;
    private final String email;
    private final Set<NotifyChannel> notifyChannels = new HashSet<>();
    private final Set<Mentee> assignedMentees = new HashSet<>();

    public Mentor(String nick, String email) {
        this.nick = nick;
        this.email = email;
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

    @Override
    public String getNick() {
        return this.nick;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public Set<NotifyChannel> getNotifyChannels() {
        return this.notifyChannels;
    }

    @Override
    public void addNotifyChannel(NotifyChannel channel) {
        this.notifyChannels.add(channel);
    }

    @Override
    public void removeNotifyChannel(NotifyChannel channel) {
        this.notifyChannels.remove(channel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mentor mentor = (Mentor) o;
        return Objects.equals(nick, mentor.nick) &&
                Objects.equals(email, mentor.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, email);
    }
}
