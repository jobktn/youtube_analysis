import java.util.*;

/**
 * The class of indexes the words in a list of YouTube videos.
 */
public class YouTubeVideoIndexer {
    /** @author group08
     * A list of all the words found in the videos.
     */
    private List<String> items = new ArrayList();

    /**
     * A map of words to their related `YouTubeWordItem` objects.
     */
    private Map<String, YouTubeWordItem> words = new HashMap<>();

    /**
     * Indexes the words in the specified list of YouTube videos.
     * @param list The list of YouTube videos to index.
     */
    public void index(List<YouTubeVideo> list){
        for(YouTubeVideo video : list){
            String titleDescription = (video.getTitle()+ " " +video.getDescription()).trim();
            items = List.of(titleDescription.split("\\s+"));

            for(String word : items) {
                if (!words.containsKey(word)) {
                    YouTubeWordItem wordItem = new YouTubeWordItem();
                    wordItem.setWord(word);
                    wordItem.setCount(1);
                    wordItem.add(video);
                    words.put(word, wordItem);

                } else {
                    YouTubeWordItem wordItem = words.get(word);
                    wordItem.setCount(wordItem.getCount() + 1);
                    wordItem.add(video);
                }
            }
        }
    }

    /**
     * Gets the count of occurrences of a specific word in the word index.
     * @param word The word to search for.
     * @return The number of times the specified word shows in the indexed videos.
     */
    public int wordCount(String word){
        YouTubeWordItem wordItem = words.get(word);
        if(wordItem != null){
            return wordItem.getCount();
        } else{
            return 0;
        }
    }

    /**
     * Gets a set of all the videos that contain the specified word.
     * @param word The word to search for.
     * @return A set of all the videos that contain the specified word.
     */
    public Set<YouTubeVideo> findAllVid(String word){
        YouTubeWordItem wordItem = words.get(word);
        if(wordItem != null){
            return wordItem.getVideos();
        } else {
            return new HashSet<>();
        }
    }

    /**
     * Gets the most used word in the indexed videos.
     * @return The word that is used the most in the indexed videos.
     */
    public String findMostUsed() {
        String mostUsed = "";
        int mostUsedCount = 0;

        for (String word : words.keySet()) {
            int count = words.get(word).getCount();
            if (count > mostUsedCount) {
                mostUsed = word;
                mostUsedCount = count;
            }
        }
        return mostUsed;

    }

    /**
     * Get a list of all the words in the indexed videos and sorted by their counts in descending order.
     * @return A list of all the words in the indexed videos and sorted by their counts in descending order.
     */
    public List<YouTubeWordItem> getSortedYoutubeWordItems() {
        List<YouTubeWordItem> sortedWords = new ArrayList<>(words.values());
        sortedWords.sort((w1, w2) -> Integer.compare(w2.getCount(), w1.getCount()));
        return sortedWords;
    }



}
