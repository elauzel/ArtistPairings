package util;

import java.util.List;
import java.util.stream.Collectors;

public class DataWrangler {

    public static List<String> removeLinesWithoutTwoArtists(List<String> lines) {
        return lines.stream()
                .filter(line -> line.length() > 2 && line.contains(","))
                .collect(Collectors.toList());
    }
}
