import util.ArtistPairUtil;
import util.DataWrangler;
import util.FileUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ArtistPairAnalyzer {
    private static final String BASE_DIR = "." + FileUtil.FS + "src" + FileUtil.FS + "resource" + FileUtil.FS;
    private static final String INPUT = BASE_DIR + "input.txt";
    private static final String OUTPUT = BASE_DIR + "output.csv";

    public static void main(String[] args) {
        final List<String> originalLines = FileUtil.readLines(INPUT);
        final List<String> validLines = DataWrangler.removeLinesWithoutTwoArtists(originalLines);
        final Map<String, Set<String>> pairMap = ArtistPairUtil.getArtistPairings(validLines, 50);
        final Set<String> individualPairs = pairMap.keySet().stream()
                .flatMap(key -> pairMap.get(key).stream().map(value -> key + "," + value))
                .collect(Collectors.toSet());
        FileUtil.writeLines(individualPairs, OUTPUT);
    }
}
