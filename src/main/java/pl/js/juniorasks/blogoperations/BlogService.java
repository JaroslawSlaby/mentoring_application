package pl.js.juniorasks.blogoperations;

import org.springframework.stereotype.Service;
import pl.js.juniorasks.models.PostPrototype;
import pl.js.juniorasks.models.Post;
import pl.js.juniorasks.tools.InputValidator;

import static pl.js.juniorasks.tools.InputValidator.validateObjectValue;
import static pl.js.juniorasks.tools.InputValidator.validateStringValue;

//@Service
public class BlogService {

    private final BlogProcessor blogProcessor;

    public BlogService(BlogProcessor blogProcessor) {
        this.blogProcessor = blogProcessor;
    }

    public Post getPost(String mentorNick, String postId) {
        validateStringValue(mentorNick);
        validateStringValue(postId);

        return blogProcessor.getPost(mentorNick, postId);
    }

    public Post addPost(String mentorNick, PostPrototype content) {
        validateStringValue(mentorNick);
        validateObjectValue(content);

        return blogProcessor.addPost(mentorNick, content);
    }
}
