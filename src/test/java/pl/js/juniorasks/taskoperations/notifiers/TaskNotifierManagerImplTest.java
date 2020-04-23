package pl.js.juniorasks.taskoperations.notifiers;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.NotifyChannel;
import pl.js.juniorasks.models.Task;

import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TaskNotifierManagerImplTest {

    private static final String MENTEE_NICK = "TestMenteeNick";
    private static final String MENTEE_MAIL = "TestMenteeMail";
    private static final String TASK_CONTENT = "TestTaskContent";

    @Test
    void okTest() {
        Map<NotifyChannel, TaskNotifier> mapMock = mock(Map.class);
        TaskNotifier taskNotifier = mock(TaskNotifier.class);
        when(mapMock.get(NotifyChannel.MAIL)).thenReturn(taskNotifier);
        Mentee mentee = new Mentee(MENTEE_NICK, MENTEE_MAIL);
        mentee.addNotifyChannel(NotifyChannel.MAIL);
        Task task = new Task(MENTEE_NICK, TASK_CONTENT);
        TaskNotifierManager manager = new TaskNotifierManagerImpl(mapMock);

        manager.notifyMentee(mentee, task);

        verify(mapMock).get(NotifyChannel.MAIL);
        verify(taskNotifier).notify(mentee, task);
    }

    @Test
    void okTwoChannelsTest() {
        Map<NotifyChannel, TaskNotifier> mapMock = mock(Map.class);
        TaskNotifier taskNotifier = mock(TaskNotifier.class);
        when(mapMock.get(NotifyChannel.MAIL)).thenReturn(taskNotifier);
        when(mapMock.get(NotifyChannel.SMS)).thenReturn(taskNotifier);
        Mentee mentee = new Mentee(MENTEE_NICK, "TestMenteeMail");
        mentee.addNotifyChannel(NotifyChannel.MAIL);
        mentee.addNotifyChannel(NotifyChannel.SMS);
        Task task = new Task(MENTEE_NICK, "TestTaskContent");
        TaskNotifierManager manager = new TaskNotifierManagerImpl(mapMock);

        manager.notifyMentee(mentee, task);

        verify(mapMock).get(NotifyChannel.MAIL);
        verify(mapMock).get(NotifyChannel.SMS);
        verify(taskNotifier, times(2)).notify(mentee, task);
    }

}