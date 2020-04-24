package pl.js.juniorasks.useroperations.mentors;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.models.Mentor;
import pl.js.juniorasks.dataproviders.MentorProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MentorProcessorTest {

    private static final String MENTOR_NICK = "TestMentorNick";
    private static final String MENTOR_MAIL = "TestMentorMail";

    @Test
    void getMentorOkTest() {
        MentorProvider mentorProvider = mock(MentorProvider.class);
        MentorProcessor processor = new MentorProcessor(mentorProvider);
        when(mentorProvider.getMentor(MENTOR_NICK)).thenReturn(new Mentor(MENTOR_NICK, MENTOR_MAIL));

        Mentor mentor = processor.getMentor(MENTOR_NICK);

        assertEquals(MENTOR_NICK, mentor.getNick());
        assertEquals(MENTOR_MAIL, mentor.getEmail());
        verify(mentorProvider).getMentor(MENTOR_NICK);
    }

    @Test
    void addMentorOkTest() {
        MentorProvider mentorProvider = mock(MentorProvider.class);
        MentorProcessor processor = new MentorProcessor(mentorProvider);
        doNothing().when(mentorProvider).addMentor(any());

        Mentor mentor = processor.addMentor(MENTOR_NICK, MENTOR_MAIL);

        assertEquals(MENTOR_NICK, mentor.getNick());
        assertEquals(MENTOR_MAIL, mentor.getEmail());
        verify(mentorProvider).addMentor(mentor);
    }


    @Test
    void removeMentorOkTest() {
        MentorProvider mentorProvider = mock(MentorProvider.class);
        MentorProcessor processor = new MentorProcessor(mentorProvider);
        doNothing().when(mentorProvider).addMentor(any());
        doNothing().when(mentorProvider).removeMentor(any());
        when(mentorProvider.getMentor(MENTOR_NICK)).thenReturn(new Mentor(MENTOR_NICK, MENTOR_MAIL));
        processor.addMentor(MENTOR_NICK, MENTOR_MAIL);

        Mentor mentor = processor.removeMentor(MENTOR_NICK);

        assertEquals(MENTOR_NICK, mentor.getNick());
        assertEquals(MENTOR_MAIL, mentor.getEmail());
        verify(mentorProvider).addMentor(mentor);
        verify(mentorProvider).removeMentor(mentor);
    }
}