package pl.js.juniorasks.dataproviders.mentors;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.NotifyChannel;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "mentors")
public class MentorDAO {

    @Id
    private String nick;
    private String email;
    private Set<NotifyChannel> notifyChannels = new HashSet<>();
    private Set<Mentee> assignedMentees = new HashSet<>();

    public MentorDAO() {
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

    public Set<Mentee> getAssignedMentees() {
        return assignedMentees;
    }
}
