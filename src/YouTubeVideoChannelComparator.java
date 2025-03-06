import java.util.Comparator;


/** @author group08
 * A comparator that compares two YouTube videos by their channels, in alphabet descending order.
 */

public class YouTubeVideoChannelComparator implements Comparator<YouTubeVideo> {

    /**
     * Compares two YouTubeVideo objects by their channel names.
     * @param a The first YouTubeVideo for comparison.
     * @param b The second YouTubeVideo for comparison.
     * @return The result after comparing video a and video b by their channel names.
     */

    public int compare(YouTubeVideo a, YouTubeVideo b){
        return a.getChannel().toLowerCase().compareTo(b.getChannel().toLowerCase());
    }
}
