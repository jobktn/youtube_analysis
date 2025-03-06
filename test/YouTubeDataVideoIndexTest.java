import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class YouTubeDataVideoIndexTest {

    /**
     * Tests of Video Index, of class YouTubeVideoIndexer.
     */

    @DisplayName("Testing the Video Index")
    @Test

    public void testVideoIndex() throws YouTubeDataParserException{
        String fileName = "data/youtubedata_indextest.json";

        YouTubeDataParser instance = new YouTubeDataParser();
        YouTubeVideoIndexer vdoIndex = new YouTubeVideoIndexer();

        List<YouTubeVideo> videoList = instance.parse(fileName);
        vdoIndex.index(videoList);

        assertNotNull(videoList);
        assertFalse(videoList.isEmpty());

        System.out.println("Total videos indexed: " + videoList.size());

        String mostUsedWord = vdoIndex.findMostUsed();
        System.out.println("Most used word: " + mostUsedWord);

    }

}
