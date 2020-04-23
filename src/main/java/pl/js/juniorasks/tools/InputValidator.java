package pl.js.juniorasks.tools;

public class InputValidator {

    public static void validateStringValue(String value) {
        if (value == null || value.isEmpty()) {
            throw new RuntimeException(); //todo: add custom exception with exception handler
        }
    }
}
