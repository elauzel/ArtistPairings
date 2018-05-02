package util;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArtistPairUtil {

    public static Map<String, Set<String>> getArtistPairings(List<String> lines, int numPairsRequired) {
        if (lines.isEmpty() || numPairsRequired < 2) {
            return Collections.emptyMap();
        }
        Set<String> uniqueArtists = CsvUtil.extractUniqueValues(lines);
        return Collections.emptyMap();
    }
}
