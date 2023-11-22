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

    public void setup() {
        ArrayList<String> userData = io.readUserData();

        ArrayList<String> movieData = io.readMovieData();

        ArrayList<String> seriesData = io.readSeriesData();

        DataValidator dataValidator = new DataValidator();

        ArrayList<User> users = new ArrayList<>();
    }

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
                "\n1) Vis listen over alle film" +
                "\n2) Søge efter en bestemt film" +
                "\n3) Søge alle film i en kategori" +
                "\n4) Se din liste over sete film" +
                "\n5) Se din liste over gemte film" +
                "\n6) logout");
        if (i.equals("1")) {
            displayMovies();
        }
        if (i.equals("2")) {
            searchByName();
        }
        if (i.equals("3")) {
            searchByGenre();
        }
        if (i.equals("4")) {
            displayWatchedList();
        }
        if (i.equals("5")) {
            displayMyList();
        }
        if (i.equals("6")) {
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
        String userInputPassword = ui.getInput("Kodeord: ");
        if (dataValidator.checkLoginPassword(userData, userInputPassword)) {
            ui.displayMessage("Du er nu logget ind som: " + user);
            mainMenu();
        } else {
            loginPassword(user);
        }
    }

    public void logout() {
        String i = ui.getInput("Er du sikker du vil logge ud, bro?\nTast 1 hvis du gerne vil logge ud:\nTast 2 hvis du ikke vil logge ud:");
        if (i.equals("1")) {
            startMenu();
        } else if (i.equals("2")) {
            mainMenu();
        } else {
            ui.displayMessage("Forkert valg. Vælg funktion 1 eller 2.");
            logout();
        }
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

    public void removeUser() {
        String i = ui.getInput("Er du sikker du vil fjerne din konto ud, bro?\nTast 1 hvis du gerne vil slette din konto:\nTast 2 hvis du ikke vil slette din konto:");
        if (i.equals("1")) {
            String uname = ui.getInput("Indtast brugernavn: ");
            String pword = ui.getInput("Indtast kodeord: ");
            terminateUser(uname, pword);
        } else if (i.equals("2")) {
            mainMenu();
        }
    }

    public void terminateUser(String username, String password) {
        User userToRemove = new User(username, password);
        for (User currentUser : users) {
            if (currentUser.equals(userToRemove)) {
                for (User user : users) {
                    users.remove(user);
                    userData.remove(user.toString());
                }
            }
        }
        io.saveUserData(users);
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

    }


    public void searchByName() {
        Movie movie = new Movie("", "", "", 0);

        List<Movie> movies = movie.movieSeparator();
        String input = ui.getInput("Type to search");

        for (Movie m : movies) {
            if (m.getTitle().equalsIgnoreCase(input)) {
                playMethod();
            } else {
                searchChoices();
                ui.displayMessage("Media not found, try again");
                searchByName();
            }
            break;
        }
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

    public void playMethod() {
        ui.displayMessage("Media found" + "\n" + "Do you want to play the media? Y/N");
        String choice = ui.getInput("");

        if (choice.equalsIgnoreCase("Y")) {
            ui.displayMessage("*Playing media*");

        }
    }

    public void searchChoices() {
        ui.displayMessage("Media not found" + "\n" + "Do you want to ");

        String input = ui.getInput("1: Display our catalog" + "\n" + "2: Search again" + "\n" + "3: Go back to main menu");

        if (input.equalsIgnoreCase("1")) {
            displayMovies();
        } else if (input.equalsIgnoreCase("2")) {
            searchByName();
        } else if (input.equalsIgnoreCase("3")) {
            mainMenu();
        }
    }
}


