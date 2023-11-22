import java.util.ArrayList;
import java.util.List;

public class StreamingService {
    FileIO io = new FileIO();
    ArrayList<String> userData = io.readUserData();
    ArrayList<String> movieData = io.readMovieData();
    ArrayList<String> seriesData = io.readSeriesData();
    DataValidator dataValidator = new DataValidator();
    ArrayList<User> users = new ArrayList<>();
    private TextUI ui = new TextUI();
    private List<Content> content;

    public void startMenu() {
        ui.displayMessage("Hej og velkommen til landets værste streamingtjeneste");
        String i = ui.getInput("Vælg en funktion:" +
                "\n1) Logge ind." +
                "\n2) Lave en ny bruger.");
        if (i.equals("1")) {
            login();
        } else if (i.equals("2")) {
            addUser();
        } else {
            ui.displayMessage("Forkert valg. Vælg funktion 1 eller 2.");
            startMenu();
        }
    }

    public void mainMenu() {
        String i = ui.getInput("Du har følgende valgmuligheder:" +
                "\n1) Søge efter en bestemt film" +
                "\n2) Søge alle film i en kategori" +
                "\n3) Se din liste over sete film" +
                "\n4) Se din liste over gemte film" +
                "\n5) logout");

        if (i.equals("1")) {
            searchByName();
        }
        if (i.equals("2")) {
            searchByGenre();
        }
        if (i.equals("3")) {
            displayWatchedList();
        }
        if (i.equals("4")) {
            displayMyList();
        }
        if (i.equals("5")) {
            logout();
        }
    }

    public void login() {
        String userInputUsername = ui.getInput("Brugernavn: ");
        if (dataValidator.checkLoginUsername(userData, userInputUsername)) {
            loginPassword(userInputUsername);
        } else {
            login();
        }
    }

    public void loginPassword(String user) {
        String userInputUsername = user;
        String userInputPassword = ui.getInput("Kodeord: ");
        if (dataValidator.checkLoginPassword(userData, userInputPassword)) {
            ui.displayMessage("Du er nu logget ind som: " + user);
            mainMenu();
        } else {
            loginPassword(user);
        }
    }

    public void logout() {

    }

    public void addUser() {
        String userInputUsername = ui.getInput("Indtast et nyt brugernavn: ");
        if (dataValidator.checkRegisterUsername(userData, userInputUsername)) {
            String userInputPassword = ui.getInput("Indsæt ønskede kodeord\nKodeord skal minimum være 8 karakterer, skal have et tal og et stort bogstav");
            dataValidator.validatePassword(userInputPassword);
            String userInputPassword2 = ui.getInput("Gentag kodeord");
            if (userInputPassword.equals(userInputPassword2)) {
                registerUser(userInputUsername, userInputPassword);
                ui.displayMessage("Du er nu registreret som bruger:");
                startMenu();
            }
        } else {
            addUser();
        }
    }

    public void registerUser(String username, String password) {
        User user = new User(username, password);
        userData.add(user.toString());
        users.add(user);
        io.saveUserData(users);
    }

    public void removeUser(User user) {

    }

    public void displaySeries() {
        //-----------Printer listen af SERIES i en pen format------------
        Series series = new Series("", "", "", 0, "", "");
        List<Series> serie = series.seriesSeparator();
        for (Series s : serie) {
            System.out.println(s);

        }
    }

    public void displayMovies() {
        //-----------Printer listen af movies i en pen format------------
        Movie movie = new Movie("dasd", "132", "bingchillin", 6.2);
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

    public void searchByDateOfRelease() { // NICE TO HAVE

    }

    public void searchByRating() { // NICE TO HAVE

    }

    public void searchByGenre() {

    }

    public void displayWatchedList() {

    }

    public void displayMyList() {

    }
}


