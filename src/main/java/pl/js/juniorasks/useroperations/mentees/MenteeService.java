package pl.js.juniorasks.useroperations.mentees;

import org.springframework.stereotype.Service;
import pl.js.juniorasks.models.Mentee;

import static pl.js.juniorasks.tools.InputValidator.validateObjectValue;
import static pl.js.juniorasks.tools.InputValidator.validateStringValue;

@Service
public class MenteeService {

    private final MenteeProcessor menteeProcessor;

    public MenteeService(MenteeProcessor menteeProcessor) {
        this.menteeProcessor = menteeProcessor;
    }

    public Mentee getMentee(String menteeNick) {
        validateStringValue(menteeNick);
        return menteeProcessor.getMentee(menteeNick);
    }

    public Mentee addMentee(Mentee mentee) {
        validateObjectValue(mentee);
        return menteeProcessor.addMentee(mentee);
    }

    public Mentee removeMentee(String menteeNick) {
        validateStringValue(menteeNick);
        return menteeProcessor.removeMentee(menteeNick);
    }
}
