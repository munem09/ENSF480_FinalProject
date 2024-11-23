import java.util.ArrayList;
import java.util.List;

public class Showroom {
    private int showroomId;
    private String name;
    private Theatre theatre;
    private List<Showtime> showtimes;
    private List<Seat> availableSeats;

    // Constructor
    public Showroom(int showroomId, String name, Theatre theatre) {
        this.showroomId = showroomId;
        this.name = name;
        this.theatre = theatre;
        this.showtimes = new ArrayList<>();
        this.availableSeats = new ArrayList<>();
    }

    // Getters and Setters
    public int getShowroomId() {
        return showroomId;
    }

    public void setShowroomId(int showroomId) {
        this.showroomId = showroomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public List<Showtime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(List<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    // Method to add a showtime
    public void addShowtime(Showtime showtime) {
        this.showtimes.add(showtime);
    }

    // Method to add available seat
    public void addAvailableSeat(Seat seat) {
        this.availableSeats.add(seat);
    }

    // Method to display showroom details
    public String displayShowroomInfo() {
        return "Showroom: " + name + " | Theatre: " + theatre.getName() + 
               " | Available Seats: " + availableSeats.size();
    }

    @Override
    public String toString() {
        return "Showroom{" +
                "showroomId=" + showroomId +
                ", name='" + name + '\'' +
                ", theatre=" + theatre.getName() +
                '}';
    }
}
