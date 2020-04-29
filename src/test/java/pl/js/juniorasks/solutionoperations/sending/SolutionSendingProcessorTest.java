package pl.js.juniorasks.solutionoperations.sending;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.dataproviders.TaskProvider;
import pl.js.juniorasks.dataproviders.mentors.MentorProvider;
import pl.js.juniorasks.dataproviders.SolutionProvider;
import pl.js.juniorasks.models.SolutionPrototype;
import pl.js.juniorasks.models.Mentor;
import pl.js.juniorasks.models.Solution;
import pl.js.juniorasks.usernotifiers.NotifierManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SolutionSendingProcessorTest {

    private static final String MENTEE_NICK = "TestMenteeNick";
    private static final String MENTOR_NICK = "TestMentorNick";
    private static final String TASK_ID = "TestTaskId";
    private static final String SOLUTION_CONTENT = "TestSolutionContent";

    @Test
    void sendingSolutionOkTest() {
        SolutionPrototype solutionPrototype = new SolutionPrototype(MENTEE_NICK, TASK_ID, SOLUTION_CONTENT);
        MentorProvider mentorProvider = mock(MentorProvider.class);
        Mentor mentor = new Mentor(MENTOR_NICK, "TestMentorMail");
        when(mentorProvider.getMentor(MENTOR_NICK)).thenReturn(mentor);
        TaskProvider taskProvider = mock(TaskProvider.class);
        when(taskProvider.getMentorNickBasedOnTaskId(TASK_ID)).thenReturn(MENTOR_NICK);
        SolutionProvider solutionProvider = mock(SolutionProvider.class);
        doNothing().when(solutionProvider).addSolution(any());
        NotifierManager notifierManager = mock(NotifierManager.class);
        doNothing().when(notifierManager).notifyUser(any(), any());
        SolutionSendingProcessor processor = new SolutionSendingProcessor(
                mentorProvider, taskProvider, solutionProvider, notifierManager);

        Solution solution = processor.sendSolution(solutionPrototype);

        assertEquals(MENTEE_NICK, solution.getMenteeNick());
        assertEquals(SOLUTION_CONTENT, solution.getSolutionContent());
        assertEquals(TASK_ID, solution.getTaskId());

        verify(taskProvider).getMentorNickBasedOnTaskId(TASK_ID);
        verify(mentorProvider).getMentor(MENTOR_NICK);
        verify(solutionProvider).addSolution(solution);
        verify(notifierManager).notifyUser(mentor, solution);
    }

}