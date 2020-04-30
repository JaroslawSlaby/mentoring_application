package pl.js.juniorasks.models;

import pl.js.juniorasks.usernotifiers.notifiers.Notifier;

import java.util.HashSet;
import java.util.Set;

public final class BlogWall {

    private final String mentorNick;
    private final Set<Post> posts = new HashSet<>();
    private final Set<String> subscriberMails = new HashSet<>();

    public BlogWall(String mentorNick) {
        this.mentorNick = mentorNick;
    }

    public void addPost(Post post, Notifier mailNofitier) {
        this.posts.add(post);
        notifySubscribers(post, mailNofitier);
    }

    public Boolean subscribe(String subscriberMail) {
        return this.subscriberMails.add(subscriberMail);
    }

    public Boolean unsubscribe(String subscriberMail) {
        return this.subscriberMails.remove(subscriberMail);
    }

    public int getPostCount() {
        return this.posts.size();
    }

    public int getSubscriberCount() {
        return this.subscriberMails.size();
    }

    public Post getPost(String postId) {
        return this.posts.stream()
                .filter(post -> post.getId().equals(postId))
                .findFirst()
                .orElseThrow();
    }

    private void notifySubscribers(Post post, Notifier mailNotifier) {
        this.subscriberMails.forEach(user -> mailNotifier.notify(user, post));
    }
}
