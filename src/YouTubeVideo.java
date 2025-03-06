/** @author group08
 * Represents a YouTube video details.
 */

public class YouTubeVideo {
    private String channel;
    private String date;
    private String title;
    private String description;
    private int viewCount;
    private String id;

    /**
     * Gets the channel that uploaded the video.
     * @return The channel name.
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Sets the channel that uploaded the video.
     * @param channel The channel name to set.
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * Gets the date when the video was uploaded.
     * @return The date when the video was uploaded.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date when the video was uploaded.
     * @param date The date when the video was uploaded.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the title of the video.
     * @return The title of the video.
     */

    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the video.
     * @param title The title of the video.
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of the video.
     * @return The description of the video.
     */

    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the video.
     * @param description The description of the video.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the view count of the video.
     * @return The view count.
     */
    public int getViewCount() {
        return viewCount;
    }

    /**
     * Sets the view count for the video.
     * @param viewCount The view count to set.
     */
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * Gets the unique ID of the video.
     * @return The unique ID of the video.
     */

    public String getId() {
        return id;
    }

    /**
     * Sets the unique ID of the video.
     * @param id The unique ID of the video.
     */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns a string representation of this YouTube video.
     * @return A string containing the video's channel, date, title, description, view count, and id.
     */

    @Override
    public String toString() {
        return
                "\n"+ "id = " + id + "\n"+
                "channel = " + channel + "\n"+
                "title = " + title +"\n"+
                "date = " + date +"\n"+
                //"description = '" + description + '\'' +"\n"+
                "views = " + viewCount +"\n";

    }
}
