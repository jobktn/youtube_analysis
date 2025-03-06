import java.util.Comparator;

/** @author group08
 * A comparator that compares two YouTube videos by their dates, from latest to older.
 */
public class YouTubeVideoDateComparator implements Comparator<YouTubeVideo> {
    /**
     * Compares two YouTube videos by their upload dates from latest to older.
     * @param a The first YouTube video to compare.
     * @param b The second YouTube video to compare.
     * @return The result after comparing video a and video b by their upload dates.
     */

    public int compare(YouTubeVideo a, YouTubeVideo b){
        return b.getDate().compareTo(a.getDate());
    }
}
