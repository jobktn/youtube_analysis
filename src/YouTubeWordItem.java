import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/** @author group08
 * Represents a word in a YouTube video index.
 */

public class YouTubeWordItem {
    private String word;
    private int count =0;
    private Set<YouTubeVideo> videos = new HashSet<>();

    /**
     * Constructs a new YouTubeWordItem with default values.
     */

    public YouTubeWordItem(){

    }

    /**
     * Adds a YouTubeVideo to the set of videos associated with this word.
     * @param video The YouTubeVideo to add to the set of videos.
     */

    public void add(YouTubeVideo video){
        videos.add(video);
    }

    /**
     * Gets the word.
     * @return The word.
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the word.
     * @param word The word to set.
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Gets the count of occurrences of this word in videos.
     * @return The number of times the word appears in the indexed videos.
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the count of occurrences for this word.
     * @param count The count to set.
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Gets the set of YouTube videos where this word appears.
     * @return A set of YouTubeVideo objects.
     */

    public Set<YouTubeVideo> getVideos() {
        return videos;
    }

    /**
     * Sets the set of YouTube videos associated with this word.
     * @param videos The set of YouTubeVideo objects to set.
     */

    public void setVideos(Set<YouTubeVideo> videos) {
        this.videos = videos;
    }

    /**
     * Returns a string representation of this YouTube word item.
     * @return A string containing the word, its count, the number of videos where it appears, and the list of videos.
     */

    @Override
    public String toString() {
        return  "\n"+"word = " + word  + "\n"+
                "words count = " + count +"\n"+
                "videos count = " + getVideos().size() +'\n'+
                "videos id = " + videos.stream()
                                .map(YouTubeVideo::getId)
                                .collect(Collectors.joining(", "))+"\n";
    }

}
