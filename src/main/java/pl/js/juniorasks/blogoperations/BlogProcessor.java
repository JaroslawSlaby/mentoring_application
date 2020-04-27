package pl.js.juniorasks.blogoperations;

import pl.js.juniorasks.dataproviders.BlogWallProvider;
import pl.js.juniorasks.models.BlogWall;
import pl.js.juniorasks.models.Post;
import pl.js.juniorasks.models.PostPrototype;

import java.time.LocalDateTime;

public class BlogProcessor {

    private final BlogWallProvider blogWallProvider;

    public BlogProcessor(BlogWallProvider blogWallProvider) {
        this.blogWallProvider = blogWallProvider;
    }

    public Post addPost(String mentorId, PostPrototype postPrototype) {
        BlogWall mentorBlogWall = blogWallProvider.getMentorBlogWall(mentorId);
        Post post = new Post(postPrototype, LocalDateTime.now());
        mentorBlogWall.addPost(post);
        return post;
    }
}
