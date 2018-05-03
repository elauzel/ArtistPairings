package util;

import java.time.LocalDateTime;

public class LoggerUtil {
    private static final String NEW_LINE = System.lineSeparator();

    public static void logError(String message) {
        System.err.println(LocalDateTime.now() + "\t" + message + NEW_LINE);
    }
}
