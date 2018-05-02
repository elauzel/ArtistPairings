import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
}
