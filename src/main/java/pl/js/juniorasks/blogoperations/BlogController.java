package pl.js.juniorasks.blogoperations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.js.juniorasks.models.PostPrototype;
import pl.js.juniorasks.models.Post;

@RestController("/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/{mentorId}")
    ResponseEntity<Post> addPost(@PathVariable String mentorId, @RequestBody PostPrototype content) {
        return new ResponseEntity<>(blogService.addPost(mentorId, content), HttpStatus.OK);
    }
}
