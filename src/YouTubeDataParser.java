import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonArray;

/** @author group08
 * The class to parse a JSON file containing YouTube video data into a list of `YouTubeVideo` objects.
 */

public class YouTubeDataParser {

    /**
     * Parses the specified JSON file and returns a list of `YouTubeVideo` objects.
     * @param filename The path to the JSON file.
     * @return A list of `YouTubeVideo` objects.
     * @throws YouTubeDataParserException If there is an error parsing the JSON file.
     */

    public List<YouTubeVideo> parse(String filename) throws YouTubeDataParserException {
        List<YouTubeVideo> list = new ArrayList<>();

        try {
            //read data
            JsonReader jsonReader = Json.createReader(new FileInputStream(filename));
            JsonObject jobj = jsonReader.readObject();

            // read the values of the "items" field
            JsonArray items = jobj.getJsonArray("items");

            //get JSON object in JsonArray
            for (int i = 0; i < items.size(); i++) {
                //creat object for parsing
                YouTubeVideo youTubeObj = new YouTubeVideo();

                JsonObject video = items.getJsonObject(i);
                //create object snippet to keep data from "snippet" field
                JsonObject snippet = video.getJsonObject("snippet");

                //parse each data from snippet
                youTubeObj.setChannel(snippet.getString("channelTitle"));
                youTubeObj.setDate(snippet.getString("publishedAt"));
                youTubeObj.setTitle(snippet.getString("title"));
                youTubeObj.setDescription(snippet.getString("description"));
                youTubeObj.setId(snippet.getString("channelId"));

                //create object statistic to keep data from "statistics"
                JsonObject statistic = video.getJsonObject("statistics");

                //parse view count from statistic
                youTubeObj.setViewCount(Integer.parseInt(statistic.getString("viewCount")));

                //add parsed youTubeObj to list
                list.add(youTubeObj);

            }

        }
        catch (FileNotFoundException e) {
            throw new YouTubeDataParserException("Parsing Error - File Not Found.");
        } catch (JsonParsingException e){
            throw new YouTubeDataParserException("Parsing Error - Malformed JSON file.");
        }
        return list;
    }
}
