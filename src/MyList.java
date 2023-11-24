import java.util.ArrayList;

public class MyList {
    ArrayList<MediaContent> myList = new ArrayList<>();

    public void addToMyList(MediaContent media) {
        myList.add(media);
    }

    public void removeFromMyList(MediaContent media) {
        myList.remove(media);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Media media : myList) {
            sb.append(media.toString()).append("\n");
        }
        return sb.toString();
    }

    public ArrayList<MediaContent> getMyList() {
        return myList;
    }
}