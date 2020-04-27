package pl.js.juniorasks.tools;

public class IDGenerator {

    private static long id = 0;

    public static String getNextId() {
        return String.valueOf(id++);
    }
}
