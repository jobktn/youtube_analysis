
/** @author group08
 * An exception that is thrown when there is an error parsing YouTube video data.
 */
public class YouTubeDataParserException extends Exception {

    /**
     * Constructs a new YouTubeDataParserException with the customized message.
     * @param message The exception message.
     */
    public YouTubeDataParserException(String message) {
        super(message);
    }
    //e.g. the file not found, malformed JSOn file)
}
