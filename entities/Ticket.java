import java.util.Date;

public class Ticket {
    private int ticketId;
    private RegisteredUser user;
    private Showtime showtime;
    private Seat seat;
    private double price;
    private Date issueDate;
    private boolean isCancelled;

    // Constructor
    public Ticket(int ticketId, RegisteredUser user, Showtime showtime, Seat seat, double price, Date issueDate) {
        this.ticketId = ticketId;
        this.user = user;
        this.showtime = showtime;
        this.seat = seat;
        this.price = price;
        this.issueDate = issueDate;
        this.isCancelled = false;
    }

    // Getters and Setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    // Method to cancel the ticket
    public void cancelTicket() {
        if (!isCancelled) {
            isCancelled = true;
            seat.cancelSeat(); // Cancel the seat booking as well
        }
    }

    // Method to display ticket details
    public String displayTicketInfo() {
        return "Ticket ID: " + ticketId + " | Movie: " + showtime.getMovie().getTitle() + 
               " | Showtime: " + showtime.getShowtimeDate() + " | Seat: Row " + seat.getRow() +
               " Seat " + seat.getNumber() + " | Price: $" + price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", user=" + user.getName() +
                ", showtime=" + showtime.getShowtimeId() +
                ", seat=" + seat.getSeatId() +
                ", price=" + price +
                ", issueDate=" + issueDate +
                ", isCancelled=" + isCancelled +
                '}';
    }
}
