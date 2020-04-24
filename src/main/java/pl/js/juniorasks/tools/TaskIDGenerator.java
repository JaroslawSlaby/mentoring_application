package pl.js.juniorasks.tools;

public class TaskIDGenerator {

    private static long taskId = 0;

    public static String getNextTaskId() {
        return String.valueOf(taskId++);
    }
}
