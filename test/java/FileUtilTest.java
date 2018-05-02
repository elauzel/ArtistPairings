import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FileUtilTest {
    private static final String NONEXISTANT_FILE = "";

    @Test
    public void readLines_badFile_returnsEmpty() {
        assertTrue(FileUtil.readLines(NONEXISTANT_FILE).isEmpty());
    }
}
