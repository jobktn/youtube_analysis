import java.util.Comparator;

/** @author group08
 * A comparator that compares two YouTube videos by their view counts, in ascending order.
 */
public class YouTubeVideoViewComparator implements Comparator<YouTubeVideo> {

    /**
     * Compares two YouTube videos by their view counts, in ascending order.
     * @param a The first YouTube video to compare.
     * @param b The second YouTube video to compare.
     * @return The result after comparing video a and video b by their view counts.
     */

    public int compare(YouTubeVideo a, YouTubeVideo b){
        return a.getViewCount() - b.getViewCount();
    }
}
