package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileUtil {
    public static String FS = System.getProperty("file.separator");

    public static List<String> readLines(String filename) {
        try {
            return Files.readAllLines(Paths.get(filename));
        } catch (IOException ioe) {
            LoggerUtil.logError("Error reading file: " + ioe.getMessage());
            return new ArrayList<>();
        }
    }

    public static boolean writeLines(Collection<String> lines, String filename) {
        try {
            Files.write(Paths.get(filename), lines);
            return true;
        } catch (Exception e) {
            LoggerUtil.logError("Error writing file: " + e.getMessage());
            return false;
        }
    }
}
