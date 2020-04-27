package pl.js.juniorasks.models;

import java.util.Objects;

public class InputPost {

    private final String title;
    private final String content;

    public InputPost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputPost inputPost = (InputPost) o;
        return Objects.equals(title, inputPost.title) &&
                Objects.equals(content, inputPost.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content);
    }
}
