package pl.js.juniorasks.assignment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.js.juniorasks.models.Mentor;

@RestController("/assign")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/{mentorNick}/mentee/{menteeNick}")
    ResponseEntity<Mentor> assignMentee(@PathVariable String mentorNick, @PathVariable String menteeNick) {
        return new ResponseEntity<>(assignmentService.assignMentee(mentorNick, menteeNick), HttpStatus.OK);
    }

    @DeleteMapping("/{mentorNick}/mentee/{menteeNick}")
    ResponseEntity<Mentor> removeMentee(@PathVariable String mentorNick, @PathVariable String menteeNick) {
        return new ResponseEntity<>(assignmentService.removeMentee(mentorNick, menteeNick), HttpStatus.OK);
    }
}
