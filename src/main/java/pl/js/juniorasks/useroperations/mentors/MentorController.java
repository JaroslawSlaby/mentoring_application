package pl.js.juniorasks.useroperations.mentors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.js.juniorasks.models.Mentor;

@RestController("/mentors")
public class MentorController {

    private final MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping("/{mentorNick}")
    ResponseEntity<Mentor> getMentor(@PathVariable String mentorNick) {
        return new ResponseEntity<>(mentorService.getMentor(mentorNick), HttpStatus.OK);
    }

    @PostMapping("/{mentorNick}")
    ResponseEntity<Mentor> addMentor(@PathVariable String mentorNick,
                                     @RequestBody String mentorEmail) {
        return new ResponseEntity<>(mentorService.addMentor(mentorNick, mentorEmail), HttpStatus.OK);
    }

    @DeleteMapping("/{mentorNick}")
    ResponseEntity<Mentor> removeMentor(@PathVariable String mentorNick) {
        return new ResponseEntity<>(mentorService.removeMentor(mentorNick), HttpStatus.OK);
    }
}
