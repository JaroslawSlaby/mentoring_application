package pl.js.juniorasks.useroperations.mentors;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.dataproviders.mentors.MentorProvider;
import pl.js.juniorasks.models.Mentor;

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
        doNothing().when(mentorProvider).saveMentor(any());
        Mentor mentorPrototype = new Mentor(MENTOR_NICK, MENTOR_MAIL);

        Mentor mentor = processor.addMentor(mentorPrototype);

        assertEquals(MENTOR_NICK, mentor.getNick());
        assertEquals(MENTOR_MAIL, mentor.getEmail());
        verify(mentorProvider).saveMentor(mentor);
    }


    @Test
    void removeMentorOkTest() {
        Mentor mentor = new Mentor(MENTOR_NICK, MENTOR_MAIL);
        MentorProvider mentorProvider = mock(MentorProvider.class);
        MentorProcessor processor = new MentorProcessor(mentorProvider);
        doNothing().when(mentorProvider).saveMentor(any());
        when(mentorProvider.removeMentor(MENTOR_NICK)).thenReturn(mentor);
        when(mentorProvider.getMentor(MENTOR_NICK)).thenReturn(new Mentor(MENTOR_NICK, MENTOR_MAIL));
        processor.addMentor(mentor);

        Mentor returnedMentor = processor.removeMentor(MENTOR_NICK);

        assertEquals(mentor, returnedMentor);
        verify(mentorProvider).saveMentor(returnedMentor);
        verify(mentorProvider).removeMentor(MENTOR_NICK);
    }
}