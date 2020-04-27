package pl.js.juniorasks.solutionoperations;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.dataproviders.SolutionProvider;
import pl.js.juniorasks.models.Solution;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SolutionProcessorTest {

    private static final String MENTEE_NICK = "TestMenteeNick";
    private static final String TASK_ID = "TestTaskId";
    private static final String SOLUTION_CONTENT = "TestSolutionContent";
    private static final String SOLUTION_ID = "TestSolutionId";

    @Test
    void sendingSolutionOkTest() {
        Solution solution = new Solution(SOLUTION_ID,
                MENTEE_NICK, TASK_ID, LocalDateTime.now(), SOLUTION_CONTENT);
        SolutionProvider solutionProvider = mock(SolutionProvider.class);
        when(solutionProvider.getSolution(any())).thenReturn(solution);

        SolutionProcessor processor = new SolutionProcessor(solutionProvider);

        Solution returnedSolution = processor.getSolution(SOLUTION_ID);
        assertEquals(solution, returnedSolution);
        verify(solutionProvider).getSolution(SOLUTION_ID);
    }


}