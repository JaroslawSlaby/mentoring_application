package pl.js.juniorasks.taskoperations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.js.juniorasks.models.Solution;
import pl.js.juniorasks.models.Task;

@RestController("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/{mentorNick}/add-task/{menteeNick}")
    ResponseEntity<Task> addTask(@PathVariable String mentorNick,
                                 @PathVariable String menteeNick,
                                 @RequestBody String task) {
        return new ResponseEntity<>(taskService.addTask(mentorNick, menteeNick, task), HttpStatus.OK);
    }


}
