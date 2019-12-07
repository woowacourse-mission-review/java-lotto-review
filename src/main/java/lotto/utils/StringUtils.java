package lotto.utils;

public class StringUtils {
    private StringUtils() {
    }

    public static boolean isBlank(final String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isNotBlank(final String input) {
        return !isBlank(input);
    }

    public static boolean isEmpty(final String input) {
        return input == null || input.isEmpty();
    }

    public static boolean isNotEmpty(final String input) {
        return !isEmpty(input);
    }

    public static boolean isNull(final String input) {
        return input == null;
    }

    public static boolean isNotNull(final String input) {
        return !isNull(input);
    }
}
