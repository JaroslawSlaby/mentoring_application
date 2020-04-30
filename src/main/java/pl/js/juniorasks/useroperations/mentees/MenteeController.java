package pl.js.juniorasks.useroperations.mentees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.js.juniorasks.models.Mentee;

@RestController
public class MenteeController {

    private final MenteeService menteeService;

    public MenteeController(MenteeService menteeService) {
        this.menteeService = menteeService;
    }

    @GetMapping("/mentees/{menteeNick}")
    ResponseEntity<Mentee> getMentee(@PathVariable String menteeNick) {
        return new ResponseEntity<>(menteeService.getMentee(menteeNick), HttpStatus.OK);
    }

    @PostMapping("/mentees")
    ResponseEntity<Mentee> addMentee(@RequestBody Mentee mentee) {
        return new ResponseEntity<>(menteeService.addMentee(mentee), HttpStatus.OK);
    }

    @DeleteMapping("/mentees/{menteeNick}")
    ResponseEntity<Mentee> deleteMentee(@PathVariable String menteeNick) {
        return new ResponseEntity<>(menteeService.removeMentee(menteeNick), HttpStatus.OK);
    }
}
