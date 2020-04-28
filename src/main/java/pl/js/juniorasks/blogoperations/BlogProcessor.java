package pl.js.juniorasks.blogoperations;

import pl.js.juniorasks.dataproviders.BlogWallProvider;
import pl.js.juniorasks.dataproviders.MenteeProvider;
import pl.js.juniorasks.models.BlogWall;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Post;
import pl.js.juniorasks.models.PostPrototype;
import pl.js.juniorasks.usernotifiers.NotifierManager;

import java.time.LocalDateTime;

public class BlogProcessor {

    private final BlogWallProvider blogWallProvider;
    private final MenteeProvider menteeProvider;
    private final NotifierManager notifierManager;

    public BlogProcessor(BlogWallProvider blogWallProvider,
                         MenteeProvider menteeProvider,
                         NotifierManager notifierManager) {
        this.blogWallProvider = blogWallProvider;
        this.menteeProvider = menteeProvider;
        this.notifierManager = notifierManager;
    }

    public Boolean subscribeToBlog(String mentorNick, String menteeNick) {
        BlogWall mentorBlogWall = provideMentorBlogWall(mentorNick);
        Mentee mentee = menteeProvider.getMentee(menteeNick);
        return mentorBlogWall.subscribe(mentee); //todo: consider if dto should be saved in some way
    }

    public Boolean unsubscribeFromBlog(String mentorNick, String menteeNick) {
        BlogWall mentorBlogWall = provideMentorBlogWall(mentorNick);
        Mentee mentee = menteeProvider.getMentee(menteeNick);
        return mentorBlogWall.unsubscribe(mentee);
    }

    public Post addPost(String mentorNick, PostPrototype postPrototype) {
        BlogWall mentorBlogWall = provideMentorBlogWall(mentorNick);
        Post post = new Post(postPrototype, LocalDateTime.now());
        mentorBlogWall.addPost(post, notifierManager);
        return post;
    }

    private BlogWall provideMentorBlogWall(String mentorNick) {
        return blogWallProvider.getMentorBlogWall(mentorNick);
    }
}
