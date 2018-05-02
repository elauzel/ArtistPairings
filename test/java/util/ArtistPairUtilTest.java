package util;

import common.AbstractTestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class ArtistPairUtilTest extends AbstractTestBase {
    private static final int IRRELEVANT_NUM = 1;

    @Test
    public void getArtistPairings_badArtistsOrNum_returnsEmpty() {
        Assert.assertTrue(ArtistPairUtil.getArtistPairings(new ArrayList<>(), 5).isEmpty());
        Assert.assertTrue(ArtistPairUtil.getArtistPairings(Arrays.asList("one,two,three,four,five", "one,two,three"), 1).isEmpty());
    }

    @Test
    public void getArtistPairings_uniqueArtists_returnsPairings() {
        final List<String> lines = Arrays.asList("one,two,three,four,five", "one,two,six,seven,eight", "two,three,nine,ten,eleven", "one,two,five,eight,eleven,twelve");
        final Map<String, Set<String>> pairsFor2 = Collections.unmodifiableMap(new HashMap<String, Set<String>>() {
            {
                put("one", Stream.of("two", "five", "eight").collect(toSet()));
                put("two", Stream.of("one", "three", "five", "eight", "eleven").collect(toSet()));
                put("three", Stream.of("two").collect(toSet()));
                put("five", Stream.of("one", "two").collect(toSet()));
                put("eight", Stream.of("one", "two").collect(toSet()));
                put("eleven", Stream.of("two").collect(toSet()));
            }
        });
        Assert.assertEquals(pairsFor2, ArtistPairUtil.getArtistPairings(lines, 2));

        final Map<String, Set<String>> pairsFor3 = Collections.unmodifiableMap(new HashMap<String, Set<String>>() {
            {
                put("one", Stream.of("two").collect(toSet()));
                put("two", Stream.of("one").collect(toSet()));
            }
        });
        Assert.assertEquals(pairsFor3, ArtistPairUtil.getArtistPairings(lines, 3));
    }
}
