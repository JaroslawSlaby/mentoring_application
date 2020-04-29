package pl.js.juniorasks.dataproviders.mentees;

import org.springframework.data.annotation.Id;
import pl.js.juniorasks.models.NotifyChannel;

import java.util.HashSet;
import java.util.Set;

public class MenteeDAO {

    @Id
    private String nick;
    private String email;
    private Set<NotifyChannel> notifyChannels = new HashSet<>();

    public MenteeDAO() {
    }

    public MenteeDAO(String nick, String email) {
        this.nick = nick;
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }

    public Set<NotifyChannel> getNotifyChannels() {
        return notifyChannels;
    }
}
