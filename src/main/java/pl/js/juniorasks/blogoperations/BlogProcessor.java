package pl.js.juniorasks.blogoperations;

import pl.js.juniorasks.dataproviders.BlogWallProvider;
import pl.js.juniorasks.dataproviders.mentees.MenteeProvider;
import pl.js.juniorasks.models.BlogWall;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.NotifyChannel;
import pl.js.juniorasks.models.Post;
import pl.js.juniorasks.models.PostPrototype;
import pl.js.juniorasks.tools.IDGenerator;
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
    } //todo consider splitting into getting posts, subscriptions and adding posts processor

    public Post getPost(String mentorNick, String postId) {
        BlogWall mentorBlogWall = provideMentorBlogWall(mentorNick);
        return mentorBlogWall.getPost(postId);
    }

    public Boolean subscribeToBlog(String mentorNick, String menteeNick) {
        BlogWall mentorBlogWall = provideMentorBlogWall(mentorNick);
        Mentee mentee = menteeProvider.getMentee(menteeNick);
        Boolean subscribed = mentorBlogWall.subscribe(mentee.getEmail());
        saveBlogWall(mentorBlogWall);
        return subscribed;
    }

    public Boolean unsubscribeFromBlog(String mentorNick, String menteeNick) {
        BlogWall mentorBlogWall = provideMentorBlogWall(mentorNick);
        Mentee mentee = menteeProvider.getMentee(menteeNick);
        Boolean unsubscribed = mentorBlogWall.unsubscribe(mentee.getEmail());
        saveBlogWall(mentorBlogWall);
        return unsubscribed;
    }

    public Post addPost(String mentorNick, PostPrototype postPrototype) {
        BlogWall mentorBlogWall = provideMentorBlogWall(mentorNick);
        Post post = new Post(IDGenerator.getNextId(), postPrototype, LocalDateTime.now());
        mentorBlogWall.addPost(post, notifierManager.getNotifier(NotifyChannel.MAIL));
        saveBlogWall(mentorBlogWall);
        return post;
    }

    private BlogWall provideMentorBlogWall(String mentorNick) {
        return blogWallProvider.getMentorBlogWall(mentorNick);
    }

    private void saveBlogWall(BlogWall blogWall) {
        blogWallProvider.saveBlogWall(blogWall);
    }
}
