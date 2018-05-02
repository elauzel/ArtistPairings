package util;

import java.util.*;
import java.util.stream.Collectors;

public class ArtistPairUtil {

    public static Map<String, Set<String>> getArtistPairings(List<String> lines, int numPairsRequired) {
        if (lines.isEmpty() || numPairsRequired < 2) {
            return Collections.emptyMap();
        }

        return CsvUtil.extractUniqueValues(lines).parallelStream()
                .map(artist ->
                        Collections.unmodifiableMap(new HashMap<String, Set<String>>() {
                            {
                                put(artist, findPairsForArtist(artist, lines, numPairsRequired));
                            }
                        }).entrySet()
                )
                .flatMap(Collection::stream)
                .filter(entry -> !entry.getValue().isEmpty())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static Set<String> findPairsForArtist(String primaryArtist, List<String> lines, int numPairsRequired) {
        final List<String> linesWithArtist = lines.parallelStream()
                .filter(line -> line.contains(primaryArtist))
                .collect(Collectors.toList());
        return CsvUtil.extractUniqueValues(linesWithArtist).parallelStream()
                .filter(pairedArtist -> !pairedArtist.equals(primaryArtist) && linesWithArtist.stream().filter(line -> line.contains(pairedArtist)).count() >= numPairsRequired)
                .collect(Collectors.toSet());
    }
}
