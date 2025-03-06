import java.util.Comparator;

/** @author group08
 * A comparator to compare two YouTube videos by the lengths of descriptions, in descending order.
 */
public class YouTubeVideoDescriptionComparator implements Comparator<YouTubeVideo> {

    /**
     * Compares two YouTube videos by the lengths of their descriptions, in descending order.
     * @param a The first YouTube video to compare.
     * @param b The second YouTube video to compare.
     * @return  The result after comparing video a and video b by their descriptions.
     */

    public int compare(YouTubeVideo a, YouTubeVideo b){
        return b.getDescription().trim().length() - a.getDescription().trim().length();
    }
}