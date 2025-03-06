import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author group08
 */

public class youtubeFileParse {

    /**
     * Test of parse method, of class YouTubeDataParser.
     */

@DisplayName("Test parse file")
@Test
 public void testParsefile() throws YouTubeDataParserException {
        String fileName = "data/youtubedata_15_50.json";
        YouTubeDataParser instance = new YouTubeDataParser();
        // List<YouTubeVideo> expResult = null;

        List<YouTubeVideo> result = instance.parse(fileName);
        assertNotNull(result);
    }

}