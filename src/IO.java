import java.util.ArrayList;

public interface IO {

    ArrayList<String> readUserData();

    void saveUserData(ArrayList<User> users);

    ArrayList<String> readMovieData();

    ArrayList<String> readSeriesData();

}
