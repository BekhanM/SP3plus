import java.util.List;
import java.util.Objects;

public class StreamingService {
    private FileIO io = new FileIO();
    private TextUI ui = new TextUI();
    private List<Content> content;
    private List<User> users;
    private DataValidator dataValidator = new DataValidator();
    Movie movie = new Movie("","","",0);

    public StreamingService() {

    }

    public void setup() {

    }

    public void startMenu() {

    }

    public void mainMenu() {

    }

    public void Login() {

    }

    public void Logout() {

    }
    public void registerUser(String username, String password) {
        User user = new User(username, password);
        users.add(user);
    }

    public void addUser(User user) {


    }

    public void removeUser(User user) {

    }

    public void displaySeries(){
        //-----------Printer listen af SERIES i en pen format------------
        Series series = new Series("","","",0,"","");
        List<Series> serie = series.seriesSeparator();
        for (Series s : serie) {
            System.out.println(s);

        }
    }
    public void displayMovies(){
        //-----------Printer listen af movies i en pen format------------
        Movie movie = new Movie("dasd","132","bingchillin",6.2);
        List<Movie> movies = movie.movieSeparator();
        for (Movie m : movies) {
            System.out.println(m);
        }

    }

    public void searchAll() {
        Movie movie = new Movie("", "", "", 0); // Not sure about the default constructor values

        List<Movie> movies = movie.movieSeparator();
        String input = ui.getInput("Type to search");

        for (Movie m : movies) {
            if (m.getTitle().equalsIgnoreCase(input)) { //fungerer ikke med toString
                ui.displayMessage("Media found" + "\n" + "Do you want to play the media? Y/N");
                String choice = ui.getInput("");

                if (choice.equalsIgnoreCase("Y")) {
                    ui.displayMessage("*Playing media*");
                }
                return; // Exit the method after finding the movie
            }
        }

        displayMovies(); // Not sure what this method does; display movies again after unsuccessful search?
        ui.displayMessage("Media not found, try again");
        searchAll();
    }


    public void searchByName() {

    }

    public void searchByDateOfRelease() {

    }

    public void searchByRating() {

    }

    public void searchByGenre() {

    }

}
