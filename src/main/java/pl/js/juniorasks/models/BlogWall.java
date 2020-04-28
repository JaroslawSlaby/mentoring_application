package pl.js.juniorasks.models;

import pl.js.juniorasks.usernotifiers.NotifierManager;

import java.util.HashSet;
import java.util.Set;

public final class BlogWall {

    private final String mentorNick;
    private final Set<Post> posts = new HashSet<>();
    private final Set<User> subscribers = new HashSet<>();

    public BlogWall(String mentorNick) {
        this.mentorNick = mentorNick;
    }

    public void addPost(Post post, NotifierManager notifierManager) {
        this.posts.add(post);
        notifySubscribers(post, notifierManager);
    }

    public Boolean subscribe(User observer) {
        return this.subscribers.add(observer);
    }

    public Boolean unsubscribe(User observer) {
        return this.subscribers.remove(observer);
    }

    public int getPostCount() {
        return this.posts.size();
    }

    public int getSubscriberCount() {
        return this.subscribers.size();
    }

    private void notifySubscribers(Post post, NotifierManager notifierManager) {
        subscribers.forEach(user -> notifierManager.notifyUser(user, post));
    }
}
