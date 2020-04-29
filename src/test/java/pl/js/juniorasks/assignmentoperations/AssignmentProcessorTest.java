package pl.js.juniorasks.assignmentoperations;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Mentor;
import pl.js.juniorasks.dataproviders.mentees.MenteeProvider;
import pl.js.juniorasks.dataproviders.mentors.MentorProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        when(menteeProvider.getMentee(MENTEE_NICK_1)).thenReturn(null);
        AssignmentProcessor processor = new AssignmentProcessor(mentorProvider, menteeProvider);

        Mentor mentor = processor.assignMenteeToMentor(MENTOR_NICK, MENTEE_NICK_1);

        assertEquals(1, mentor.getNumberOfMentees());
    }

    @Test
    void emptyMentorTest() {
        MentorProvider mentorProvider = mock(MentorProvider.class);
        when(mentorProvider.getMentor(MENTOR_NICK)).thenReturn(null);
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        when(menteeProvider.getMentee(MENTEE_NICK_1)).thenReturn(createMentee(MENTEE_NICK_1));
        AssignmentProcessor processor = new AssignmentProcessor(mentorProvider, menteeProvider);

        assertThrows(NullPointerException.class,
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

    private Mentor createMentor() {
        return new Mentor(MENTOR_NICK, "mail");
    }

    private Mentee createMentee(String nick) {
        return new Mentee(nick, "mail");
    }
}
