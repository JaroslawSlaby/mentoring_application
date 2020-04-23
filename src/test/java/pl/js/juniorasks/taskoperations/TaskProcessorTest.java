package pl.js.juniorasks.taskoperations;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.dataproviders.MenteeProvider;
import pl.js.juniorasks.dataproviders.TaskProvider;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Task;
import pl.js.juniorasks.taskoperations.notifiers.TaskNotifierManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TaskProcessorTest {

    private static final String MENTEE_NICK = "TestMenteeNick";
    private static final String MENTEE_MAIL = "TestMenteeMail";
    private static final String TASK_CONTENT = "TestTaskContent";

    @Test
    void okTest() {
        Mentee mentee = new Mentee(MENTEE_NICK, MENTEE_MAIL);
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        when(menteeProvider.getMentee(MENTEE_NICK)).thenReturn(mentee);
        TaskProvider taskProvider = mock(TaskProvider.class);
        doNothing().when(taskProvider).addTask(any());
        TaskNotifierManager taskNotifiermanager = mock(TaskNotifierManager.class);
        doNothing().when(taskNotifiermanager).notifyMentee(any(), any());

        TaskProcessor processor = new TaskProcessor(menteeProvider, taskProvider, taskNotifiermanager);
        Task task = processor.createTaskForMentee(MENTEE_NICK, TASK_CONTENT);

        assertEquals(mentee, task.getMentee());
        assertEquals(TASK_CONTENT, task.getContent());
        verify(menteeProvider).getMentee(MENTEE_NICK);
        verify(taskProvider).addTask(task);
        verify(taskNotifiermanager).notifyMentee(mentee, task);


    }

}