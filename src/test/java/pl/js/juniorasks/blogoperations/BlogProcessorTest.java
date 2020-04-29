package pl.js.juniorasks.blogoperations;

import org.junit.jupiter.api.Test;
import pl.js.juniorasks.dataproviders.BlogWallProvider;
import pl.js.juniorasks.dataproviders.mentees.MenteeProvider;
import pl.js.juniorasks.models.BlogWall;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Post;
import pl.js.juniorasks.models.PostPrototype;
import pl.js.juniorasks.usernotifiers.NotifierManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BlogProcessorTest {

    private static final String MENTOR_NICK = "TestMentorNick";
    private static final String MENTEE_NICK = "TestMenteeNick";
    private static final String POST_CONTENT = "TestPostContent";
    private static final String POST_TITLE = "TestPostTitle";

    @Test
    void okAddPostTest() {
        BlogWall blogWall = new BlogWall(MENTOR_NICK);
        BlogWallProvider blogWallProvider = mock(BlogWallProvider.class);
        when(blogWallProvider.getMentorBlogWall(MENTOR_NICK)).thenReturn(blogWall);
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        NotifierManager notifierManager = mock(NotifierManager.class);
        PostPrototype postPrototype = new PostPrototype(POST_TITLE, POST_CONTENT);

        BlogProcessor processor = new BlogProcessor(blogWallProvider, menteeProvider, notifierManager);
        Post post = processor.addPost(MENTOR_NICK, postPrototype);

        assertEquals(postPrototype.getTitle(), post.getTitle());
        assertEquals(postPrototype.getContent(), post.getContent());
        assertEquals(1, blogWall.getPostCount());

        verify(blogWallProvider).getMentorBlogWall(MENTOR_NICK);
    }

    @Test
    void okSubscribeTest() {
        BlogWall blogWall = new BlogWall(MENTOR_NICK);
        BlogWallProvider blogWallProvider = mock(BlogWallProvider.class);
        when(blogWallProvider.getMentorBlogWall(MENTOR_NICK)).thenReturn(blogWall);
        Mentee mentee = new Mentee(MENTEE_NICK, "mail");
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        when(menteeProvider.getMentee(MENTEE_NICK)).thenReturn(mentee);
        NotifierManager notifierManager = mock(NotifierManager.class);

        BlogProcessor processor = new BlogProcessor(blogWallProvider, menteeProvider, notifierManager);
        Boolean subscribed = processor.subscribeToBlog(MENTOR_NICK, MENTEE_NICK);

        assertTrue(subscribed);
        assertEquals(1, blogWall.getSubscriberCount());
        verify(blogWallProvider).getMentorBlogWall(MENTOR_NICK);
        verify(menteeProvider).getMentee(MENTEE_NICK);
    }

    @Test
    void okUnsubscribeTest() {
        BlogWall blogWall = new BlogWall(MENTOR_NICK);
        BlogWallProvider blogWallProvider = mock(BlogWallProvider.class);
        when(blogWallProvider.getMentorBlogWall(MENTOR_NICK)).thenReturn(blogWall);
        Mentee mentee = new Mentee(MENTEE_NICK, "mail");
        MenteeProvider menteeProvider = mock(MenteeProvider.class);
        when(menteeProvider.getMentee(MENTEE_NICK)).thenReturn(mentee);
        NotifierManager notifierManager = mock(NotifierManager.class);

        BlogProcessor processor = new BlogProcessor(blogWallProvider, menteeProvider, notifierManager);
        processor.subscribeToBlog(MENTOR_NICK, MENTEE_NICK);
        Boolean unsubscribed = processor.unsubscribeFromBlog(MENTOR_NICK, MENTEE_NICK);

        assertTrue(unsubscribed);
        assertEquals(0, blogWall.getSubscriberCount());
        verify(blogWallProvider, times(2)).getMentorBlogWall(MENTOR_NICK);
        verify(menteeProvider, times(2)).getMentee(MENTEE_NICK);
    }
}