package pl.js.juniorasks.solutionoperations;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.dataproviders.MentorProvider;
import pl.js.juniorasks.dataproviders.SolutionProvider;
import pl.js.juniorasks.dataproviders.TaskProvider;
import pl.js.juniorasks.models.Mentor;
import pl.js.juniorasks.models.Solution;
import pl.js.juniorasks.models.Task;
import pl.js.juniorasks.usernotifiers.TaskNotifierManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SolutionProcessorTest {

    private static final String MENTEE_NICK = "TestMenteeNick";
    private static final String MENTOR_NICK = "TestMentorNick";
    private static final String TASK_ID = "TestTaskId";
    private static final String SOLUTION_CONTENT = "TestSolutionContent";

    @Test
    void okTest() {
        TaskProvider taskProvider = mock(TaskProvider.class);
        Task task = new Task(MENTEE_NICK, MENTOR_NICK, TASK_ID, "TestTaskContent");
        when(taskProvider.getTask(TASK_ID)).thenReturn(task);
        MentorProvider mentorProvider = mock(MentorProvider.class);
        Mentor mentor = new Mentor(MENTOR_NICK, "TestMentorMail");
        when(mentorProvider.getMentor(MENTOR_NICK)).thenReturn(mentor);
        SolutionProvider solutionProvider = mock(SolutionProvider.class);
        doNothing().when(solutionProvider).addSolution(any());
        TaskNotifierManager taskNotifierManager = mock(TaskNotifierManager.class);
        doNothing().when(taskNotifierManager).notifyMentee(any(), any());
        SolutionProcessor processor = new SolutionProcessor(taskProvider, mentorProvider,
                solutionProvider, taskNotifierManager);

        Solution solution = processor.sendSolution(MENTEE_NICK, TASK_ID, SOLUTION_CONTENT);

        assertEquals(MENTEE_NICK, solution.getMenteeNick());
        assertEquals(SOLUTION_CONTENT, solution.getSolutionContent());
        assertEquals(TASK_ID, solution.getTaskId());

        verify(taskProvider).getTask(TASK_ID);
        verify(mentorProvider).getMentor(MENTOR_NICK);
        verify(solutionProvider).addSolution(solution);
        verify(taskNotifierManager).notifyMentor(mentor, solution);
    }
}