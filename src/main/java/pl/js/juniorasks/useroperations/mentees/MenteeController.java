package pl.js.juniorasks.useroperations.mentees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.js.juniorasks.models.Mentee;

@RestController("/mentees")
public class MenteeController {


    private final MenteeService menteeService;

    public MenteeController(MenteeService menteeService) {
        this.menteeService = menteeService;
    }

    @GetMapping("/{mentorNick}")
    ResponseEntity<Mentee> getMentee(@PathVariable String menteeNick) {
        return new ResponseEntity<>(menteeService.getMentee(menteeNick), HttpStatus.OK);
    }
}
