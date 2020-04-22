package pl.js.juniorasks.assignment;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.users.MenteeProvider;
import pl.js.juniorasks.users.MentorProvider;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Mentor;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AssignmentProcessorTest {

    private static final String MENTOR_NICK = "TestMentorNick";
    private static final String MENTEE_NICK_1 = "TestMenteeNick";
    private static final String MENTEE_NICK_2 = "TestMenteeNick2";

    @Test
    void oneMenteeOkTest() {
        MentorProvider mentorProvider = mock(MentorProvider.class);
        when(mentorProvider.getMentor(MENTOR_NICK)).thenReturn(createMentor());
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        when(menteeProvider.getMentee(MENTEE_NICK_1)).thenReturn(createMentee(MENTEE_NICK_1));
        AssignmentProcessor processor = new AssignmentProcessor(mentorProvider, menteeProvider);

        Mentor mentor = processor.assignMenteeToMentor(MENTOR_NICK, MENTEE_NICK_1);

        boolean hasMentees = mentor.hasMentees();
        int numberOfMentees = mentor.getNumberOfMentees();
        assertTrue(hasMentees);
        assertEquals(1, numberOfMentees);
    }

    @Test
    void oneMenteeAddedTwiceOkTest() {
        MentorProvider mentorProvider = mock(MentorProvider.class);
        when(mentorProvider.getMentor(MENTOR_NICK)).thenReturn(createMentor());
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        when(menteeProvider.getMentee(MENTEE_NICK_1)).thenReturn(createMentee(MENTEE_NICK_1));
        AssignmentProcessor processor = new AssignmentProcessor(mentorProvider, menteeProvider);

        processor.assignMenteeToMentor(MENTOR_NICK, MENTEE_NICK_1);
        Mentor mentor = processor.assignMenteeToMentor(MENTOR_NICK, MENTEE_NICK_1);

        boolean hasMentees = mentor.hasMentees();
        int numberOfMentees = mentor.getNumberOfMentees();
        assertTrue(hasMentees);
        assertEquals(1, numberOfMentees);
    }

    @Test
    void twoMenteesOkTest() {
        MentorProvider mentorProvider = mock(MentorProvider.class);
        when(mentorProvider.getMentor(MENTOR_NICK)).thenReturn(createMentor());
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        when(menteeProvider.getMentee(MENTEE_NICK_1)).thenReturn(createMentee(MENTEE_NICK_1));
        when(menteeProvider.getMentee(MENTEE_NICK_2)).thenReturn(createMentee(MENTEE_NICK_2));
        AssignmentProcessor processor = new AssignmentProcessor(mentorProvider, menteeProvider);

        processor.assignMenteeToMentor(MENTOR_NICK, MENTEE_NICK_1);
        Mentor mentor = processor.assignMenteeToMentor(MENTOR_NICK, MENTEE_NICK_2);

        boolean hasMentees = mentor.hasMentees();
        int numberOfMentees = mentor.getNumberOfMentees();
        assertTrue(hasMentees);
        assertEquals(2, numberOfMentees);
    }

    @Test
    void emptyMenteeTest() {
        MentorProvider mentorProvider = mock(MentorProvider.class);
        when(mentorProvider.getMentor(MENTOR_NICK)).thenReturn(createMentor());
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        when(menteeProvider.getMentee(MENTEE_NICK_1)).thenReturn(Optional.empty());
        AssignmentProcessor processor = new AssignmentProcessor(mentorProvider, menteeProvider);

        assertThrows(NoSuchUserException.class,
                () -> processor.assignMenteeToMentor(MENTOR_NICK, MENTEE_NICK_1));

    }

    @Test
    void emptyMentorTest() {
        MentorProvider mentorProvider = mock(MentorProvider.class);
        when(mentorProvider.getMentor(MENTOR_NICK)).thenReturn(Optional.empty());
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        when(menteeProvider.getMentee(MENTEE_NICK_1)).thenReturn(createMentee(MENTEE_NICK_1));
        AssignmentProcessor processor = new AssignmentProcessor(mentorProvider, menteeProvider);

        assertThrows(NoSuchUserException.class,
                () -> processor.assignMenteeToMentor(MENTOR_NICK, MENTEE_NICK_1));

    }

    @Test
    void removeMenteeTest() {
        MentorProvider mentorProvider = mock(MentorProvider.class);
        when(mentorProvider.getMentor(MENTOR_NICK)).thenReturn(createMentor());
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        when(menteeProvider.getMentee(MENTEE_NICK_1)).thenReturn(createMentee(MENTEE_NICK_1));
        AssignmentProcessor processor = new AssignmentProcessor(mentorProvider, menteeProvider);
        processor.assignMenteeToMentor(MENTOR_NICK, MENTEE_NICK_1);

        Mentor mentor = processor.removeMenteeFromMentor(MENTOR_NICK, MENTEE_NICK_1);

        boolean hasMentees = mentor.hasMentees();
        int numberOfMentees = mentor.getNumberOfMentees();
        assertFalse(hasMentees);
        assertEquals(0, numberOfMentees);
    }

    private Optional<Mentor> createMentor() {
        return Optional.of(new Mentor(MENTOR_NICK));
    }

    private Optional<Mentee> createMentee(String nick) {
        return Optional.of(new Mentee(nick));
    }
}
