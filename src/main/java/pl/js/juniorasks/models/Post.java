package pl.js.juniorasks.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Post {

    private final String title;
    private final String content;
    private final LocalDateTime timestamp;

    public Post(PostPrototype postPrototype, LocalDateTime timestamp) {
        this.title = postPrototype.getTitle();
        this.content = postPrototype.getContent();
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) &&
                Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content);
    }
}
