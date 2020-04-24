package pl.js.juniorasks.solutionoperations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.js.juniorasks.models.Solution;

@RestController("/solutions")
public class SolutionController {

    private final SolutionService solutionService;

    public SolutionController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @PostMapping("/{menteeNick}/add-solution/{taskId}")
    ResponseEntity<Solution> addSolution(@PathVariable String menteeNick,
                                         @PathVariable String taskId,
                                         @RequestBody String solution) {
        return new ResponseEntity<>(solutionService.addSolution(menteeNick, taskId, solution), HttpStatus.OK);
    }
}
