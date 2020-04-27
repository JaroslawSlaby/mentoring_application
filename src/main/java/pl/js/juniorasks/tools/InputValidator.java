package pl.js.juniorasks.tools;

public class InputValidator {

    public static void validateStringValue(String value) {
        validateObjectValue(value);
        if (value.isEmpty()) {
            throw new RuntimeException(); //todo: add custom exception with exception handler
        }
    }

    public static void validateObjectValue(Object value) {
        if (value == null) {
            throw new RuntimeException(); //todo: as previously
        }
    }
}
