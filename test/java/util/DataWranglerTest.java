package util;

import common.AbstractTestBase;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DataWranglerTest extends AbstractTestBase {

    @Test
    public void removeLinesWithoutTwoArtists_hasLinesToRemove_returnsSubset() {
        final List<String> originalLines = FileUtil.readLines(AbstractTestBase.BASE_RESOURCE_DIR + "input.txt");
        final List<String> newLines = DataWrangler.removeLinesWithoutTwoArtists(originalLines);
        assertTrue(originalLines.containsAll(newLines));
        assertEquals(965, newLines.size());
        assertFalse(originalLines.stream().filter(String::isEmpty).collect(Collectors.toList()).isEmpty());
        assertTrue(newLines.stream().filter(String::isEmpty).collect(Collectors.toList()).isEmpty());
    }

    @Test
    public void removeLinesWithoutTwoArtists_noLinesToRemove_returnsOriginal() {
        final List<String> originalLines = FileUtil.readLines(AbstractTestBase.BASE_RESOURCE_DIR + "valid - all lines with two artists.txt");
        assertEquals(originalLines, DataWrangler.removeLinesWithoutTwoArtists(originalLines));
    }
}
