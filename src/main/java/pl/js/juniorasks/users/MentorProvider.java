package pl.js.juniorasks.users;

import pl.js.juniorasks.models.Mentor;

import java.util.Optional;

public interface MentorProvider {
    Optional<Mentor> getMentor(String mentorNick);
}
