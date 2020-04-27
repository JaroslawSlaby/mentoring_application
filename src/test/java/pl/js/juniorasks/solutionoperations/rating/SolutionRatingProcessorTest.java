package pl.js.juniorasks.solutionoperations.rating;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.dataproviders.MenteeProvider;
import pl.js.juniorasks.dataproviders.SolutionProvider;
import pl.js.juniorasks.dataproviders.TaskProvider;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Rate;
import pl.js.juniorasks.models.Solution;
import pl.js.juniorasks.models.Task;
import pl.js.juniorasks.usernotifiers.NotifierManager;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SolutionRatingProcessorTest {

    private static final String MENTEE_NICK = "TestMenteeNick";
    private static final String MENTOR_NICK = "TestMentorNick";
    private static final String TASK_ID = "TestTaskId";
    private static final String SOLUTION_CONTENT = "TestSolutionContent";
    private static final String SOLUTION_ID = "TestSolutionId";

    @Test
    void ratingSolutionOkTest() {
        TaskProvider taskProvider = mock(TaskProvider.class);
        Task task = new Task(MENTEE_NICK, MENTOR_NICK, TASK_ID, "TestTaskContent");
        when(taskProvider.getTask(TASK_ID)).thenReturn(task);
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        Mentee mentee = new Mentee(MENTEE_NICK, "TestMentorMail");
        when(menteeProvider.getMentee(MENTEE_NICK)).thenReturn(mentee);
        SolutionProvider solutionProvider = mock(SolutionProvider.class);
        Solution solution = new Solution(SOLUTION_ID, MENTEE_NICK, TASK_ID, LocalDateTime.now(), SOLUTION_CONTENT);
        when(solutionProvider.getSolution(SOLUTION_ID)).thenReturn(solution);
        NotifierManager notifierManager = mock(NotifierManager.class);
        doNothing().when(notifierManager).notifyUser(any(), any());

        SolutionRatingProcessor processor = new SolutionRatingProcessor(solutionProvider, menteeProvider, notifierManager);

        Rate rate = processor.rateSolution(SOLUTION_ID, "A");

        assertEquals("A", rate.name());
        verify(solutionProvider).getSolution(SOLUTION_ID);
        verify(solutionProvider).rateSolution(solution, Rate.A);
        verify(menteeProvider).getMentee(MENTEE_NICK);
        verify(notifierManager).notifyUser(mentee, solution);

    }

}