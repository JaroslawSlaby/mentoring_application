package pl.js.juniorasks.models;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Mentor implements User {

    private String nick;
    private String email;
    private Set<NotifyChannel> notifyChannels = EnumSet.of(NotifyChannel.MAIL);
    private Set<String> assignedMentees = new HashSet<>();

    public Mentor() {
    }

    public Mentor(String nick, String email) {
        this.nick = nick;
        this.email = email;
    }

    public void assignMentee(String menteeNick) {
        this.assignedMentees.add(menteeNick);
    }

    public void removeMentee(String menteeNick) {
        this.assignedMentees.remove(menteeNick);
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
