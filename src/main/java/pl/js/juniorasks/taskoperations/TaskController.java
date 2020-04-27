package pl.js.juniorasks.taskoperations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.js.juniorasks.models.Task;

@RestController("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{taskId}")
    ResponseEntity<Task> getTask(@PathVariable String taskId) {
        return new ResponseEntity<>(taskService.getTask(taskId), HttpStatus.OK);
    }

    @PostMapping("/{mentorNick}/add-task/{menteeNick}")
    ResponseEntity<Task> addTask(@PathVariable String mentorNick, //todo: introduce input task and output task or task project and task result!
                                 @PathVariable String menteeNick,
                                 @RequestBody String task) {
        return new ResponseEntity<>(taskService.addTask(mentorNick, menteeNick, task), HttpStatus.OK);
    }

}
