import java.util.List;

public class Movie {
    private int movieId;
    private String title;
    private String genre;
    private int duration; // Duration in minutes
    private String description;
    private List<Showtime> showtimes; // List of showtimes for this movie

    // Constructor
    public Movie(int movieId, String title, String genre, int duration, String description) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.description = description;
    }

    // Getters and Setters
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Showtime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(List<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    // Methods
    public void addShowtime(Showtime showtime) {
        this.showtimes.add(showtime);
    }

    public Showtime getShowtime(int showtimeId) {
        for (Showtime showtime : showtimes) {
            if (showtime.getShowtimeId() == showtimeId) {
                return showtime;
            }
        }
        return null;
    }

    public boolean hasShowtime(int showtimeId) {
        for (Showtime showtime : showtimes) {
            if (showtime.getShowtimeId() == showtimeId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                '}';
    }
}
