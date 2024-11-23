public class Seat {
    private int seatId;
    private int row;
    private int number;
    private boolean isAvailable;
    private boolean isBooked;

    // Constructor
    public Seat(int seatId, int row, int number) {
        this.seatId = seatId;
        this.row = row;
        this.number = number;
        this.isAvailable = true;  // Initially all seats are available
        this.isBooked = false;    // Initially no seat is booked
    }

    // Getters and Setters
    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    // Method to book the seat
    public void bookSeat() {
        if (isAvailable) {
            isBooked = true;
            isAvailable = false;  // Once booked, the seat is no longer available
        }
    }

    // Method to cancel the seat booking
    public void cancelSeat() {
        if (isBooked) {
            isBooked = false;
            isAvailable = true;  // If canceled, the seat is available again
        }
    }

    // Method to display seat information
    public String displaySeatInfo() {
        return "Row: " + row + ", Seat Number: " + number + " - " + (isAvailable ? "Available" : "Booked");
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", row=" + row +
                ", number=" + number +
                ", isAvailable=" + isAvailable +
                ", isBooked=" + isBooked +
                '}';
    }
}
