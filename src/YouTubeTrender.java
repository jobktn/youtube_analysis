import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author group08
 *
 * The class to test parse video data and video index methods.
 */

public class YouTubeTrender {

    /**
     * Performs the first test to parse JSON YoutubeVideo data.
     * @throws YouTubeDataParserException If the YouTube video data file cannot be parsed.
     * @throws FileNotFoundException If the YouTube video data file does not exist.
     */
    public static void test1() throws YouTubeDataParserException, FileNotFoundException {

        System.out.println("Performing Test 1");
        String filename = "data/youtubedata_15_50.json";
        int expectedSize = 50;

        System.out.println("Testing the file: " + filename);
        System.out.println("Expecting size of: " + expectedSize);

        // Read data
        JsonReader jsonReader = Json.createReader(new FileInputStream(filename));
        JsonObject jobj = jsonReader.readObject();

        // read the values of the item field
        JsonArray items = jobj.getJsonArray("items");

        System.out.println("Size of input: " + items.size());
        System.out.println("Success: " + (expectedSize == items.size()));

    }

    /**
     * Performs the second test, to parse JSON YoutubeVideo data and sorting videos by view count.
     * @throws YouTubeDataParserException If the YouTube video data file cannot be parsed.
     * @throws FileNotFoundException If the YouTube video data file does not exist.
     */

    public static void test2() throws YouTubeDataParserException, FileNotFoundException {

        System.out.println("Performing Test 2");
        String filename = "data/youtubedata_loremipsum.json";
        int expectedSize = 10;

        System.out.println("Testing the file: " + filename);
        System.out.println("Expecting size of: " + expectedSize);

        YouTubeDataParser parser = new YouTubeDataParser();

        List<YouTubeVideo> list = parser.parse(filename);
        System.out.println("Found size: " + list.size());

        YouTubeVideoViewComparator viewComparator = new YouTubeVideoViewComparator();
        list.sort(viewComparator);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Video " + i + ": "+ list.get(i));
        }
    }

    /**
     * Implements test method for the YouTubeVideoIndexer class.
     * @throws YouTubeDataParserException If the YouTube video data file cannot be parsed.
     */

    public static void testIndex() throws YouTubeDataParserException {
        Scanner scan = new Scanner(System.in);
        String filename = "data/youtubedata_indextest.json";

        YouTubeDataParser parser = new YouTubeDataParser();
        List<YouTubeVideo> list = parser.parse(filename);

        YouTubeVideoIndexer indexer = new YouTubeVideoIndexer();
        indexer.index(list);

        System.out.println(indexer.wordCount("FIVE"));
        System.out.println(indexer.findMostUsed());
        System.out.println(indexer.getSortedYoutubeWordItems());

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, YouTubeDataParserException {

        testIndex();

    }

}


