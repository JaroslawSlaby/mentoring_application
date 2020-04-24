package pl.js.juniorasks.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    protected final String nick;
    protected final String email;
    private final List<NotifyChannel> notifyChannels = new ArrayList<>();

    public User(String nick, String email) {
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
        User user = (User) o;
        return Objects.equals(nick, user.nick) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, email);
    }
}