import java.util.ArrayList;

public class WatchedList {
    ArrayList<MediaContent> watchedList = new ArrayList<>();

    public void addToWatchedList(MediaContent media) {
        watchedList.add(media);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Media media : watchedList) {
            sb.append(media.toString()).append("\n");
        }
        return sb.toString();
    }

    public ArrayList<MediaContent> getWatchedList() {
        return watchedList;
    }
}
