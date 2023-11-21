import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO implements IO {


    @Override
    public List<String> readUserData() {
        ArrayList<String> userData = new ArrayList<>();
        File file = new File("src/UserBase");

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                userData.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        return userData;
    }



    @Override
    public void saveUserData(List<User> users) {
        try {
            FileWriter writer = new FileWriter("UserBase");
            writer.write("User,Password" + "\n");
            for (User c : users) {
                String textTosave = c.getUsername() + "," + c.getPassword();
                writer.write(textTosave + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("noget gik galt ved skrivning til fil");
        }
    }

    public List<String> readMovieData(){
        ArrayList<String> movieData = new ArrayList<>();

        File file = new File("src/100bedstefilm");

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                movieData.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        return movieData;
    }

    @Override
    public List<String> readSeriesData(){
        ArrayList<String> seriesData = new ArrayList<>();

        File file = new File("src/100bedsteserier");

        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                seriesData.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        return seriesData;
    }


}
