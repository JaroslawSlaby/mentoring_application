package pl.js.juniorasks.blogoperations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.js.juniorasks.models.PostPrototype;
import pl.js.juniorasks.models.Post;

//@RestController
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog/{mentorId}")
    ResponseEntity<Post> addPost(@PathVariable String mentorId, @RequestBody PostPrototype content) {
        return new ResponseEntity<>(blogService.addPost(mentorId, content), HttpStatus.OK);
    }

    @GetMapping("/blog/{mentorId}/{postId}")
    ResponseEntity<Post> getPost(@PathVariable String mentorNick, @PathVariable String postId) {
        return new ResponseEntity<>(blogService.getPost(mentorNick, postId), HttpStatus.OK);
    }
}
