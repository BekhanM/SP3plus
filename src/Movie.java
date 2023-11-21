import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Movie extends Media
{
    private List<Movie>movieList = new ArrayList<>();

    public Movie(String title,String releaseDate, String genre, double rating) // Tar constructor fra Media
    {
        /*super(title, genre, rating, releaseDate);*/
        super(title,releaseDate,genre,rating);
    }


    // Laver getters igen
    public String getTitle()
    {
            Scanner scan = new Scanner("src/100bedstefilm");
            movieSeparator().subList(0,1);
            scan.hasNextLine();
            return title;

    }
    public String getGenre()
    {
        Scanner scan = new Scanner("src/100bedstefilm");
        movieSeparator().subList(1,2);
        scan.hasNextLine();
        return genre;
    }

    public double getRating()
    {
        Scanner scan = new Scanner("src/100bedstefilm");
        movieSeparator().subList(2,3);
        scan.hasNextLine();
        return rating;
    }

    public String getReleaseDate()
    {
        Scanner scan = new Scanner("src/100bedstefilm");
        movieSeparator().subList(3,4);
        scan.hasNextLine();
        return releaseDate;
    }




    public List<Movie> movieSeparator() {
        List<String> data = io.readMovieData();
        for (String s : data) {
            String[] row = s.split(";");
            String title = row[0].trim();
            String releaseDate = row[1].trim();
            String genre = row[2].trim();
            double rating = Double.parseDouble(row[3].replace(",",".").trim());// bruger replace so det kan skrives som double

            registerMovies(title, releaseDate, genre, rating);
        }
        return movieList;
    }

    public void registerMovies(String title, String releaseDate,String genre, double rating) {
        Movie movie=new Movie(title,releaseDate,genre,rating);
        movieList.add(movie);

    }



    @Override
    public String toString() // Bruger super toString fra Media
    {

        return super.toString();
    }

}
