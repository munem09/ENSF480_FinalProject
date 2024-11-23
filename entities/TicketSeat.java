public class TicketSeat {
    private int seatId;
    private Seat seat;
    private Ticket ticket;

    // Constructor
    public TicketSeat(int seatId, Seat seat, Ticket ticket) {
        this.seatId = seatId;
        this.seat = seat;
        this.ticket = ticket;
    }

    // Getters and Setters
    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    // Method to display seat and ticket details
    public String displaySeatTicketInfo() {
        return "Seat ID: " + seatId + " | Seat Row: " + seat.getRow() + " | Seat Number: " + seat.getNumber() +
                " | Ticket ID: " + ticket.getTicketId() + " | Movie: " + ticket.getShowtime().getMovie().getTitle();
    }

    @Override
    public String toString() {
        return "TicketSeat{" +
                "seatId=" + seatId +
                ", seat=" + seat.getSeatId() +
                ", ticket=" + ticket.getTicketId() +
                '}';
    }
}
