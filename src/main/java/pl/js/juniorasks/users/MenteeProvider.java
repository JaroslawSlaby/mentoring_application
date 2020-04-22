package pl.js.juniorasks.users;

import pl.js.juniorasks.models.Mentee;

import java.util.Optional;

public interface MenteeProvider {
    Optional<Mentee> getMentee(String menteeNick);
}
