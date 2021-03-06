package pl.js.juniorasks.usernotifiers;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Mentor;
import pl.js.juniorasks.models.NotifyChannel;
import pl.js.juniorasks.models.Solution;
import pl.js.juniorasks.models.Task;
import pl.js.juniorasks.usernotifiers.notifiers.Notifier;

import java.time.LocalDateTime;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class NotifierManagerImplTest {

    private static final String MENTEE_NICK = "TestMenteeNick";
    private static final String MENTOR_NICK = "TestMentorNick";
    private static final String MENTOR_MAIL = "TestMentorMail";
    private static final String MENTEE_MAIL = "TestMenteeMail";
    private static final String TASK_CONTENT = "TestTaskContent";
    private static final String TASK_ID = "1";
    private static final String SOLUTION_ID = "1";
    private static final String SOLUTION_CONTENT = "TestSolutionContent";

    @Test
    void okMenteeTest() {
        Map<NotifyChannel, Notifier> mapMock = mock(Map.class);
        Notifier notifier = mock(Notifier.class);
        when(mapMock.get(NotifyChannel.MAIL)).thenReturn(notifier);
        Mentee mentee = new Mentee(MENTEE_NICK, MENTEE_MAIL);
        mentee.addNotifyChannel(NotifyChannel.MAIL);
        Task task = new Task(MENTEE_NICK, MENTOR_NICK, TASK_ID, TASK_CONTENT);
        NotifierManager manager = new NotifierManagerImpl(mapMock);

        manager.notifyUser(mentee, task);

        verify(mapMock).get(NotifyChannel.MAIL);
        verify(notifier).notify(mentee, task);
    }

    @Test
    void okMenteeTwoChannelsTest() {
        Map<NotifyChannel, Notifier> mapMock = mock(Map.class);
        Notifier notifier = mock(Notifier.class);
        when(mapMock.get(NotifyChannel.MAIL)).thenReturn(notifier);
        when(mapMock.get(NotifyChannel.SMS)).thenReturn(notifier);
        Mentee mentee = new Mentee(MENTEE_NICK, MENTEE_MAIL);
        mentee.addNotifyChannel(NotifyChannel.MAIL);
        mentee.addNotifyChannel(NotifyChannel.SMS);
        Task task = new Task(MENTEE_NICK, MENTOR_NICK, TASK_ID, TASK_CONTENT);
        NotifierManager manager = new NotifierManagerImpl(mapMock);

        manager.notifyUser(mentee, task);

        verify(mapMock).get(NotifyChannel.MAIL);
        verify(mapMock).get(NotifyChannel.SMS);
        verify(notifier, times(2)).notify(mentee, task);
    }

    @Test
    void okMentorTest() {
        Map<NotifyChannel, Notifier> mapMock = mock(Map.class);
        Notifier notifier = mock(Notifier.class);
        when(mapMock.get(NotifyChannel.MAIL)).thenReturn(notifier);
        Mentor mentor = new Mentor(MENTEE_NICK, MENTOR_MAIL);
        mentor.addNotifyChannel(NotifyChannel.MAIL);
        Solution solution = new Solution(SOLUTION_ID, MENTEE_NICK, TASK_ID, LocalDateTime.now(), SOLUTION_CONTENT);
        NotifierManager manager = new NotifierManagerImpl(mapMock);

        manager.notifyUser(mentor, solution);

        verify(mapMock).get(NotifyChannel.MAIL);
        verify(notifier).notify(mentor, solution);
    }

    @Test
    void okMentorTwoChannelsTest() {
        Map<NotifyChannel, Notifier> mapMock = mock(Map.class);
        Notifier notifier = mock(Notifier.class);
        when(mapMock.get(NotifyChannel.MAIL)).thenReturn(notifier);
        when(mapMock.get(NotifyChannel.SMS)).thenReturn(notifier);
        Mentor mentor = new Mentor(MENTEE_NICK, MENTOR_MAIL);
        mentor.addNotifyChannel(NotifyChannel.MAIL);
        mentor.addNotifyChannel(NotifyChannel.SMS);
        Solution solution = new Solution(SOLUTION_ID, MENTEE_NICK, TASK_ID, LocalDateTime.now(), SOLUTION_CONTENT);
        NotifierManager manager = new NotifierManagerImpl(mapMock);

        manager.notifyUser(mentor, solution);

        verify(mapMock).get(NotifyChannel.MAIL);
        verify(mapMock).get(NotifyChannel.SMS);
        verify(notifier, times(2)).notify(mentor, solution);
    }
}