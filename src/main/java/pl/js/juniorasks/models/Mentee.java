package pl.js.juniorasks.models;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Mentee implements User {

    private String nick;
    private String email;
    private Set<NotifyChannel> notifyChannels = EnumSet.of(NotifyChannel.MAIL);

    public Mentee() {
    }

    public Mentee(String nick, String email) {
        this.nick = nick;
        this.email = email;
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
        Mentee mentee = (Mentee) o;
        return Objects.equals(nick, mentee.nick) &&
                Objects.equals(email, mentee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, email);
    }
}
