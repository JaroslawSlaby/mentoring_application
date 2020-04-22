package pl.js.juniorasks.models;

import java.util.Objects;

public class Mentee {

    private final String nick;

    public Mentee(String nick) {
        this.nick = nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mentee mentee = (Mentee) o;
        return Objects.equals(nick, mentee.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick);
    }
}
