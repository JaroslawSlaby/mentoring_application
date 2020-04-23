package pl.js.juniorasks.useroperations.mentees;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.dataproviders.MenteeProvider;
import pl.js.juniorasks.models.Mentee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MenteeProcessorTest {

    private static final String MENTEE_NICK = "TestMenteeNick";

    @Test
    void getMenteeOkTest() {
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        MenteeProcessor processor = new MenteeProcessor(menteeProvider);
        when(menteeProvider.getMentee(MENTEE_NICK)).thenReturn(new Mentee(MENTEE_NICK));

        Mentee mentee = processor.getMentee(MENTEE_NICK);

        assertEquals(MENTEE_NICK, mentee.getNick());
        verify(menteeProvider).getMentee(MENTEE_NICK);
    }

    @Test
    void addMenteeOkTest() {
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        MenteeProcessor processor = new MenteeProcessor(menteeProvider);
        doNothing().when(menteeProvider).addMentee(any());

        Mentee mentee = processor.addMentee(MENTEE_NICK);

        assertEquals(MENTEE_NICK, mentee.getNick());
        verify(menteeProvider).addMentee(mentee);
    }


    @Test
    void removeMenteeOkTest() {
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        MenteeProcessor processor = new MenteeProcessor(menteeProvider);
        doNothing().when(menteeProvider).addMentee(any());
        doNothing().when(menteeProvider).removeMentee(any());
        when(menteeProvider.getMentee(MENTEE_NICK)).thenReturn(new Mentee(MENTEE_NICK));
        processor.addMentee(MENTEE_NICK);

        Mentee mentee = processor.removeMentee(MENTEE_NICK);

        assertEquals(MENTEE_NICK, mentee.getNick());
        verify(menteeProvider).addMentee(mentee);
        verify(menteeProvider).removeMentee(mentee);
    }
}