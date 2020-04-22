package pl.js.juniorasks.tools;

public class InputValidator {

    public static void validateStringValue(String value) {
        if (value == null || value.isEmpty()) {
            throw new RuntimeException();
        }
    }
}
