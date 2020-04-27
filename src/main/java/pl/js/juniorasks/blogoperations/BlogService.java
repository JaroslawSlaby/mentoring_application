package pl.js.juniorasks.blogoperations;

import org.springframework.stereotype.Service;
import pl.js.juniorasks.models.PostPrototype;
import pl.js.juniorasks.models.Post;
import pl.js.juniorasks.tools.InputValidator;

import static pl.js.juniorasks.tools.InputValidator.validateObjectValue;
import static pl.js.juniorasks.tools.InputValidator.validateStringValue;

@Service
public class BlogService {

    private final BlogProcessor blogProcessor;

    public BlogService(BlogProcessor blogProcessor) {
        this.blogProcessor = blogProcessor;
    }

    public Post addPost(String mentorId, PostPrototype content) {
        validateStringValue(mentorId);
        validateObjectValue(content);

        return blogProcessor.addPost(mentorId, content);
    }
}
