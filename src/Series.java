import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Series extends Media {
    private List<Series>seriesList = new ArrayList<>(); // skal bruges til separationsmetoden
    private String season;
    private String episode;


    public Series(String title,String releaseDate, String genre, double rating, String season, String episode) {

        super(title,releaseDate,genre,rating);
        this.season =season;
        this.episode=episode;
    }

    public String getTitle() {
        Scanner scan = new Scanner("src/100bedstefilm");
        seriesSeparator().subList(0,1);
        scan.hasNextLine();
        return title;
    }

    public double getRating() {
        Scanner scan = new Scanner("src/100bedstefilm");
        seriesSeparator().subList(1,2);
        scan.hasNextLine();
        return rating;
    }

    public String getReleaseDate() {
        Scanner scan = new Scanner("src/100bedstefilm");
        seriesSeparator().subList(2,3);
        scan.hasNextLine();
        return releaseDate;
    }

    public String getGenre() {
        Scanner scan = new Scanner("src/100bedstefilm");
        seriesSeparator().subList(3,4);
        scan.hasNextLine();
        return genre;
    }

    public String getSeason() {
        Scanner scan = new Scanner("src/100bedstefilm");
        seriesSeparator().subList(4,5);
        scan.hasNextLine();
        return season;
    }

    public String getEpisode() {
        Scanner scan = new Scanner("src/100bedstefilm");
        seriesSeparator().subList(5,6);
        scan.hasNextLine();
        return episode;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Season: " + getSeason() + "Episode: " + getEpisode();
    }


    public List<Series> seriesSeparator() {
        List<String> data = io.readSeriesData();
        for (String s : data) {
            String[] row = s.split(";");
            String title = row[0].trim();
            String releaseDate = row[1].trim();
            String genre = row[2].trim();
            double rating = Double.parseDouble(row[3].replace(",", ".").trim());

            String[] seasonAndEpisodes = row[4].split(","); // splitter sesonger og episoder med comma
            for (String seasonAndEpisode : seasonAndEpisodes) {
                String[] parts = seasonAndEpisode.trim().split("-"); // splitter season(ental) og episode
                String season = parts[0].trim();
                String episode = parts[1].trim();
                registerSeries(title, releaseDate, genre, rating, season+" ", episode);
            }
        }
        return seriesList;
    }

    private void registerSeries(String title,String releaseDate, String genre, double rating, String season, String episode) {
        Series series=new Series(title,releaseDate,genre,rating,season,episode);
        seriesList.add(series);

    }


}
