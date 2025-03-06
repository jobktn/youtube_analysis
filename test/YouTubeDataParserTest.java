import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author group08
 */
public class YouTubeDataParserTest {


    /**
     * Tests of parse method, of class YouTubeDataParser compare with String txt.
     */
    @DisplayName("Testing the parse method")
    @Test
    public void testParse() throws YouTubeDataParserException{

        String exp = "{ channel = 'Joe Bloggs'\n" +
                "date = '2016-04-20T23:15:17.000Z'\n" +
                "title = 'This should have a really useful title'\n" +
                "description = 'This should have a really useful description.  However lots of youtubers put links and other promotional material.'\n" +
                "viewCount = 14180950\n" +
                "id = 'UCehf4850q1L3ng7s7L54ATA' }"+"\n";
        String fileName = "data/youtubedata.json";
        YouTubeDataParser instance = new YouTubeDataParser();
        List<YouTubeVideo> result;

        result = instance.parse(fileName);
        String op = result.get(0).toString();
        assertEquals(exp,op);

    }
}

