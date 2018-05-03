package util;

import common.AbstractTestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileUtilTest extends AbstractTestBase {
    private static final String VALID_FILE = "input.txt";

    @Test
    public void readLines_invalidFiles_returnEmpty() {
        assertTrue(FileUtil.readLines("").isEmpty());
        assertTrue(FileUtil.readLines(BASE_RESOURCE_DIR + "nonexistant.file").isEmpty());
        assertTrue(FileUtil.readLines(BASE_RESOURCE_DIR + "empty.txt").isEmpty());
    }

    @Test
    public void readLines_validFile_returnsLines() {
        assertEquals(1000, FileUtil.readLines(BASE_RESOURCE_DIR + VALID_FILE).size());
    }

    @Test
    public void writeLines_invalidFile_logsError() {
        assertFalse(FileUtil.writeLines(new ArrayList<>(), BASE_RESOURCE_DIR + "*"));
    }

    @Test
    public void writeLines_validFile_success() {
        final ArrayList<String> emptyLines = new ArrayList<>();
        final String filename = BASE_RESOURCE_DIR + "test-output.txt";
        assertTrue(FileUtil.writeLines(emptyLines, filename));
        Assert.assertEquals(emptyLines, FileUtil.readLines(filename));
        final List<String> actualLines = Arrays.asList("line1", "line2");
        assertTrue(FileUtil.writeLines(actualLines, filename));
        assertEquals(actualLines, FileUtil.readLines(filename));
    }
}
