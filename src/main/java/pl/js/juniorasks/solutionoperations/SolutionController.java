package pl.js.juniorasks.solutionoperations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.js.juniorasks.models.Rate;
import pl.js.juniorasks.models.Solution;

@RestController("/solutions")
public class SolutionController {

    private final SolutionService solutionService;

    public SolutionController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @GetMapping("/{solutionId}")
    ResponseEntity<Solution> getSolution(@PathVariable String solutionId) {
        return new ResponseEntity<>(solutionService.getSolution(solutionId), HttpStatus.OK);
    }

    @PostMapping("/{menteeNick}/add-solution/{taskId}")
    ResponseEntity<Solution> addSolution(@PathVariable String menteeNick,
                                         @PathVariable String taskId,
                                         @RequestBody String solution) {
        return new ResponseEntity<>(solutionService.addSolution(menteeNick, taskId, solution), HttpStatus.OK);
    }

    @PostMapping("{solutionId}/rate-solution/{rate}")
    ResponseEntity<Rate> rateSolution(@PathVariable String solutionId,
                                      @PathVariable String rate) {
        return new ResponseEntity<>(solutionService.rateSolution(solutionId, rate), HttpStatus.OK);
    }

}
