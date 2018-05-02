package util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class CsvUtilTest {

    @Test
    public void extractUniqueValues_emptyList_returnsEmpty() {
        Assert.assertTrue(CsvUtil.extractUniqueValues(new ArrayList<>()).isEmpty());
    }

    @Test
    public void extractUniqueValues_validValues_returnsUnique() {
        Assert.assertEquals(Stream.of("one", "two", "three").collect(toSet()), CsvUtil.extractUniqueValues(Arrays.asList("one", "two", "three")));
        Assert.assertEquals(Stream.of("one", "three").collect(toSet()), CsvUtil.extractUniqueValues(Arrays.asList("one", "one", "three")));
        Assert.assertEquals(Stream.of("one").collect(toSet()), CsvUtil.extractUniqueValues(Arrays.asList("one", "one", "one")));
    }
}
