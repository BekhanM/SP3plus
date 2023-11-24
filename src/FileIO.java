import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO implements IO {
    TextUI ui = new TextUI();

    @Override
    public ArrayList<String> readUserData() {
        ArrayList<String> userData = new ArrayList<>();
        File file = new File("src/UserBase");

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                userData.add(s);
            }
        } catch (FileNotFoundException e) {
            ui.displayMessage("file not found");
        }

        return userData;
    }


    public void saveUserData(ArrayList<User> users) {
        try {
            File file = new File("src/UserBase");
            //boolean fileExists = file.exists();

            FileWriter writer = new FileWriter(file, true); // true flag for append mode
            //BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // If the file doesn't exist or is empty, add headers
            if (!file.exists() || file.length() == 0) {
                writer.write("Username,Password" + "\n");
            }

            // Append new data
            for (User c : users) {
                String textToSave = c.getUsername() + "," + c.getPassword();
                writer.write(textToSave + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            ui.displayMessage("Something went wrong while writing to the file");
        }
    }


    public ArrayList<String> readMovieData() {
        ArrayList<String> movieData = new ArrayList<>();

        File file = new File("src/100bedstefilm");

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                movieData.add(s);
            }
        } catch (FileNotFoundException e) {
            ui.displayMessage("file not found");
        }
        return movieData;
    }

    @Override
    public ArrayList<String> readSeriesData() {
        ArrayList<String> seriesData = new ArrayList<>();

        File file = new File("src/100bedsteserier");

        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                seriesData.add(s);
            }
        } catch (FileNotFoundException e) {
            ui.displayMessage("file not found");
        }
        return seriesData;
    }

    public ArrayList<String> readMediaData() {
        ArrayList<String> mediaData = new ArrayList<>();

        File file = new File("src/MediaContentContent");

        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                mediaData.add(s);
            }
        } catch (FileNotFoundException e) {
            ui.displayMessage("file not found");
        }
        return mediaData;
    }

    public void saveMyListData(String username, ArrayList<MediaContent> saveData) {
        ArrayList<String> savedData = new ArrayList<>();
        try {
            File f = new File("UserMyList/userMyList_" + username + ".txt");
            FileWriter writer = new FileWriter(f, true);
            for (MediaContent s : saveData) {
                writer.write(s + "\n");
                savedData.add(String.valueOf(s));
            }
            writer.close();
        } catch (IOException e) {
            ui.displayMessage("Something went wrong while writing to the file");
        }
    }

    public void saveWatchedListData(String username, ArrayList<MediaContent> saveData) {
        ArrayList<String> savedData = new ArrayList<>();
        try {
            File f = new File("UserWatchedList/userWatchedList_" + username + ".txt");
            FileWriter writer = new FileWriter(f, true);
            for (MediaContent s : saveData) {
                writer.write(String.valueOf(s + "\n"));
                savedData.add(String.valueOf(s));
                }
            writer.close();
        } catch (IOException e) {
            ui.displayMessage("Something went wrong while writing to the file");
        }
    }

    public ArrayList<String> readMyWatchedList(String username, ArrayList<String> readsMyWatchedList) {
        ArrayList<String> watchedListData = new ArrayList<>();
        File file = new File("UserWatchedList/userWatchedList_" + username + ".txt");
        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                watchedListData.add(s);
            }
        } catch (FileNotFoundException e) {
            ui.displayMessage("file not found");
        }
        return watchedListData;
    }

    public ArrayList<String> readMyList(String username, ArrayList<String> readsMyList) {
        ArrayList<String> myListData = new ArrayList<>();
        File file = new File("UserMyList/userMyList_" + username + ".txt");
        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                myListData.add(s);
            }
        } catch (FileNotFoundException e) {
            ui.displayMessage("file not found");
        }
        return myListData;
    }
}