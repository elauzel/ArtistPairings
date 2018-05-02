package util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CsvUtil {
    public static Set<String> extractUniqueValues(List<String> validLines) {
        return validLines.stream()
                .flatMap(line -> Arrays.stream(line.split(",")))
                .collect(Collectors.toSet());
    }
}
