package pl.js.juniorasks.solutionoperations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.js.juniorasks.models.SolutionPrototype;
import pl.js.juniorasks.models.Rate;
import pl.js.juniorasks.models.Solution;

@RestController("/solutions")
public class SolutionController {
    //todo: consider splitting into two separate controllers - one for sending and the other for rating
    private final SolutionService solutionService;

    public SolutionController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @GetMapping("/{solutionId}")
    ResponseEntity<Solution> getSolution(@PathVariable String solutionId) {
        return new ResponseEntity<>(solutionService.getSolution(solutionId), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Solution> addSolution(@RequestBody SolutionPrototype solution) {
        return new ResponseEntity<>(solutionService.addSolution(solution), HttpStatus.OK);
    }

    @PostMapping("{solutionId}/rate-solution/{rate}")
    ResponseEntity<Rate> rateSolution(@PathVariable String solutionId,
                                      @PathVariable String rate) {
        return new ResponseEntity<>(solutionService.rateSolution(solutionId, rate), HttpStatus.OK);
    }

}
