package pl.js.juniorasks.taskoperations;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.dataproviders.MenteeProvider;
import pl.js.juniorasks.dataproviders.TaskProvider;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Task;
import pl.js.juniorasks.models.TaskPrototype;
import pl.js.juniorasks.usernotifiers.NotifierManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TaskProcessorTest {

    private static final String MENTEE_NICK = "TestMenteeNick";
    private static final String MENTOR_NICK = "TestMentorNick";
    private static final String MENTEE_MAIL = "TestMenteeMail";
    private static final String TASK_CONTENT = "TestTaskContent";
    private static final String TASK_ID = "TestTaskId";

    @Test
    void okAddTaskTest() {
        TaskPrototype taskPrototype = new TaskPrototype(MENTEE_NICK, MENTOR_NICK, TASK_CONTENT);
        Mentee mentee = new Mentee(MENTEE_NICK, MENTEE_MAIL);
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        when(menteeProvider.getMentee(MENTEE_NICK)).thenReturn(mentee);
        TaskProvider taskProvider = mock(TaskProvider.class);
        doNothing().when(taskProvider).addTask(any());
        NotifierManager notifiermanager = mock(NotifierManager.class);
        doNothing().when(notifiermanager).notifyUser(any(), any());

        TaskProcessor processor = new TaskProcessor(menteeProvider, taskProvider, notifiermanager);
        Task task = processor.createTaskForMentee(taskPrototype);

        assertEquals(mentee.getNick(), task.getMenteeNick());
        assertEquals(TASK_CONTENT, task.getContent());
        verify(menteeProvider).getMentee(MENTEE_NICK);
        verify(taskProvider).addTask(task);
        verify(notifiermanager).notifyUser(mentee, task);
    }

    @Test
    void okGetTaskTest() {
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        Task task = new Task(MENTEE_NICK, MENTOR_NICK, TASK_ID, TASK_CONTENT);
        TaskProvider taskProvider = mock(TaskProvider.class);
        when(taskProvider.getTask(any())).thenReturn(task);
        NotifierManager notifierManager = mock(NotifierManager.class);

        TaskProcessor processor = new TaskProcessor(menteeProvider, taskProvider, notifierManager);
        Task returnedTask = processor.getTask(TASK_ID);

        assertEquals(TASK_CONTENT, returnedTask.getContent());
        verify(taskProvider).getTask(TASK_ID);
    }

}