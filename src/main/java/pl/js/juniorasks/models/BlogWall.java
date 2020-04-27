package pl.js.juniorasks.models;

import java.util.HashSet;
import java.util.Set;

public class BlogWall { //todo: introduce observer

    private final Set<Post> posts = new HashSet<>();

    public void addPost(Post post) {
        this.posts.add(post);
    }
}
