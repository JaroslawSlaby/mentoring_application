package pl.js.juniorasks.solutionoperations.sending;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.dataproviders.MentorProvider;
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
        when(mentorProvider.getMentorBasedOnTaskId(TASK_ID)).thenReturn(mentor);
        SolutionProvider solutionProvider = mock(SolutionProvider.class);
        doNothing().when(solutionProvider).addSolution(any());
        NotifierManager notifierManager = mock(NotifierManager.class);
        doNothing().when(notifierManager).notifyUser(any(), any());
        SolutionSendingProcessor processor = new SolutionSendingProcessor(
                mentorProvider, solutionProvider, notifierManager);

        Solution solution = processor.sendSolution(solutionPrototype);

        assertEquals(MENTEE_NICK, solution.getMenteeNick());
        assertEquals(SOLUTION_CONTENT, solution.getSolutionContent());
        assertEquals(TASK_ID, solution.getTaskId());

        verify(mentorProvider).getMentorBasedOnTaskId(TASK_ID);
        verify(solutionProvider).addSolution(solution);
        verify(notifierManager).notifyUser(mentor, solution);
    }

}