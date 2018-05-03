import util.ArtistPairUtil;
import util.DataWrangler;
import util.FileUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArtistPairAnalyzer {
    private static String INPUT = "." + FileUtil.FS + "src" + FileUtil.FS + "resource" + FileUtil.FS + "input.txt";

    public static void main(String[] args) {
        final List<String> originalLines = FileUtil.readLines(INPUT);
        final List<String> validLines = DataWrangler.removeLinesWithoutTwoArtists(originalLines);
        final Map<String, Set<String>> artistPairings = ArtistPairUtil.getArtistPairings(validLines, 50);
        artistPairings.keySet().forEach(key -> artistPairings.get(key).forEach(value -> System.out.println(key + "," + value)));
    }
}
