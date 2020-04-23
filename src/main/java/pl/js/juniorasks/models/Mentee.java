package pl.js.juniorasks.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Mentee {

    private final String nick;
    private final String email;
    private final List<NotifyChannel> notifyChannels = new ArrayList<>();

    public Mentee(String nick, String email) {
        this.nick = nick;
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }

    public List<NotifyChannel> getNotifyChannels() {
        return notifyChannels;
    }

    public void addNotifyChannel(NotifyChannel channel) {
        this.notifyChannels.add(channel);
    }

    public void removeNotifyChannel(NotifyChannel notifyChannel) {
        this.notifyChannels.remove(notifyChannel);
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
