import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class MediaContent extends Media {
        private final List<MediaContent> mediaList = new ArrayList<>(); // skal bruges til separationsmetoden
        private final String season;
        private final String episode;

        public MediaContent(String title, String releaseDate, String genre, double rating, String season, String episode) {
            super(title, releaseDate, genre, rating);
            this.season = season;
            this.episode = episode;
        }

        public String getTitle() {
            Scanner scan = new Scanner("src/MediaContentContent");
            mediaContentSeparator().subList(0, 1);
            scan.hasNextLine();
            return title;
        }

        public double getRating() {
            Scanner scan = new Scanner("src/MediaContentContent");
            mediaContentSeparator().subList(1, 2);
            scan.hasNextLine();
            return rating;
        }

        public String getReleaseDate() {
            Scanner scan = new Scanner("src/MediaContentContent");
            mediaContentSeparator().subList(2, 3);
            scan.hasNextLine();
            return releaseDate;
        }

        public String getGenre() {
            Scanner scan = new Scanner("src/MediaContentContent");
            mediaContentSeparator().subList(3, 4);
            scan.hasNextLine();
            return genre;
        }

        public String getSeason() {
            Scanner scan = new Scanner("src/MediaContentContent");
            mediaContentSeparator().subList(4, 5);
            scan.hasNextLine();
            return season;
        }

        public String getEpisode() {
            Scanner scan = new Scanner("src/MediaContentContent");
            mediaContentSeparator().subList(5, 6);
            scan.hasNextLine();
            return episode;
        }

        @Override
        public String toString() {
            if (!getSeason().isEmpty() && !getEpisode().isEmpty()) {
                return super.toString() + " Season: " + getSeason() + " Episode: " + getEpisode();
            } else {
                return super.toString();
            }
        }


        public List<MediaContent> mediaContentSeparator() {
            List<String> data = io.readMediaData();

            for (String s : data) {
                String[] row = s.split(";");
                String title = row[0].trim();
                String releaseDate = row[1].trim();
                String genre = row[2].trim();
                double rating = Double.parseDouble(row[3].replace(",", ".").trim());

                if (row.length > 4) { // tjek om der er sæson
                    int totalEpisodes = 0;
                    String[] seasonAndEpisodes = row[4].split(","); // splitter sesonger og episoder med comma
                    String totalSeasons = String.valueOf(seasonAndEpisodes.length);
                    for (String seasonAndEpisode : seasonAndEpisodes) {
                        String[] parts = seasonAndEpisode.trim().split("-"); // splitter season(ental) og episode
                        String season = parts[0].trim();

                        int episode = Integer.parseInt(parts[1].trim());
                        totalEpisodes += episode;

                    }
                    registerMediaContent(title, releaseDate, genre, rating, totalSeasons + " ", String.valueOf(totalEpisodes));

                } else {
                    // movie
                    registerMediaContent(title, releaseDate, genre, rating, "", "");
                }
            }
            return mediaList;
        }




        private void registerMediaContent(String title, String releaseDate, String genre, double rating, String season, String episode) {
            MediaContent mediaContent = new MediaContent(title, releaseDate, genre, rating, season, episode);
            mediaList.add(mediaContent);
        }
    }