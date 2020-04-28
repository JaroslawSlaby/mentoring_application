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
    private static final String MENTEE_MAIL = "TestMenteeMail";

    @Test
    void getMenteeOkTest() {
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        MenteeProcessor processor = new MenteeProcessor(menteeProvider);
        when(menteeProvider.getMentee(MENTEE_NICK)).thenReturn(new Mentee(MENTEE_NICK, MENTEE_MAIL));

        Mentee mentee = processor.getMentee(MENTEE_NICK);

        assertEquals(MENTEE_NICK, mentee.getNick());
        verify(menteeProvider).getMentee(MENTEE_NICK);
    }

    @Test
    void addMenteeOkTest() {
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        MenteeProcessor processor = new MenteeProcessor(menteeProvider);
        doNothing().when(menteeProvider).addMentee(any());

        Mentee mentee = processor.addMentee(MENTEE_NICK, MENTEE_MAIL);

        assertEquals(MENTEE_NICK, mentee.getNick());
        verify(menteeProvider).addMentee(mentee);
    }


    @Test
    void removeMenteeOkTest() {
        Mentee mentee = new Mentee(MENTEE_NICK, MENTEE_MAIL);
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        MenteeProcessor processor = new MenteeProcessor(menteeProvider);
        doNothing().when(menteeProvider).addMentee(any());
        when(menteeProvider.removeMentee(MENTEE_NICK)).thenReturn(mentee);
        when(menteeProvider.getMentee(MENTEE_NICK)).thenReturn(new Mentee(MENTEE_NICK, MENTEE_MAIL));
        processor.addMentee(MENTEE_NICK, MENTEE_MAIL);

        Mentee returnedMentee = processor.removeMentee(MENTEE_NICK);

        assertEquals(mentee, returnedMentee);
        verify(menteeProvider).addMentee(returnedMentee);
        verify(menteeProvider).removeMentee(MENTEE_NICK);
    }
}