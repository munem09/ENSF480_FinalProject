import java.util.Date;
import java.util.List;


public class Showtime {
    private int showtimeId;
    private Movie movie;
    private Date showtimeDate;
    private Theatre theatre;
    private List<Seat> seats;  // List of seats available for this showtime

    // Constructor
    public Showtime(int showtimeId, Movie movie, Date showtimeDate, Theatre theatre, List<Seat> seats) {
        this.showtimeId = showtimeId;
        this.movie = movie;
        this.showtimeDate = showtimeDate;
        this.theatre = theatre;
        this.seats = seats;
    }

    // Getters and Setters
    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getShowtimeDate() {
        return showtimeDate;
    }

    public void setShowtimeDate(Date showtimeDate) {
        this.showtimeDate = showtimeDate;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    // Method to check if a seat is available
    public boolean isSeatAvailable(int seatId) {
        for (Seat seat : seats) {
            if (seat.getSeatId() == seatId) {
                return seat.isAvailable();
            }
        }
        return false;  // Seat not found
    }

    // Method to book a seat for the showtime
    public void bookSeat(int seatId) {
        for (Seat seat : seats) {
            if (seat.getSeatId() == seatId && seat.isAvailable()) {
                seat.bookSeat();
                break;
            }
        }
    }

    // Method to cancel a seat booking
    public void cancelSeat(int seatId) {
        for (Seat seat : seats) {
            if (seat.getSeatId() == seatId && seat.isBooked()) {
                seat.cancelSeat();
                break;
            }
        }
    }

    // Method to display showtime information
    public String displayShowtimeInfo() {
        return "Movie: " + movie.getTitle() + " | Showtime: " + showtimeDate + " | Theatre: " + theatre.getName();
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "showtimeId=" + showtimeId +
                ", movie=" + movie.getTitle() +
                ", showtimeDate=" + showtimeDate +
                ", theatre=" + theatre.getName() +
                '}';
    }
}
