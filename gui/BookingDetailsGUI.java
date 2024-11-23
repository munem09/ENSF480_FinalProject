import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingDetailsGUI {

    public JFrame window;  // Declare JFrame for the window

    private String selectedTheatre;
    private String selectedMovie;
    private String selectedShowtime;
    private String selectedSeat;

    private JLabel lblTotalAmount;  // Label for displaying total amount

    public BookingDetailsGUI(String selectedTheatre, String selectedMovie, String selectedShowtime, String selectedSeat) {
        this.selectedTheatre = selectedTheatre;
        this.selectedMovie = selectedMovie;
        this.selectedShowtime = selectedShowtime;
        this.selectedSeat = selectedSeat;

        window = new JFrame("Booking Details - AcmePlex");
        window.setBounds(100, 100, 400, 500);  // Increased window height for the total amount display
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main panel with BoxLayout for vertical stacking of components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        window.getContentPane().add(panel);

        // Header label for Booking Details
        JLabel lblTitle = new JLabel("Booking Details");
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblTitle);

        // Spacer for some padding between title and booking details
        panel.add(Box.createVerticalStrut(20));

        // Panel for displaying booking information (Movie, Show, and Seat details)
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        detailsPanel.add(new JLabel("Theatre: " + selectedTheatre));
        detailsPanel.add(new JLabel("Movie: " + selectedMovie));
        detailsPanel.add(new JLabel("Showtime: " + selectedShowtime));
        detailsPanel.add(new JLabel("Selected Seats: " + selectedSeat));  // Show multiple seats

        panel.add(detailsPanel);

        // Spacer for padding between booking details and total amount
        panel.add(Box.createVerticalStrut(20));

        // Calculate the total amount based on the number of seats
        String[] seats = selectedSeat.split(",");  // Split the selected seats string by comma
        int numberOfSeats = seats.length;  // Get the number of seats selected
        int totalAmount = numberOfSeats * 15;  // $15 per seat

        // Create a label to display the total amount
        lblTotalAmount = new JLabel("Total Amount: $" + totalAmount);
        lblTotalAmount.setFont(new Font("Arial", Font.BOLD, 16));
        lblTotalAmount.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblTotalAmount);

        // Spacer for padding between total amount and buttons
        panel.add(Box.createVerticalStrut(30));

        // Create a panel for the buttons (Back, Proceed to Payment)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Back button to go back to SeatGUI
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));
        btnBack.setBackground(new Color(255, 99, 71)); // A nice red color for back button
        btnBack.setForeground(Color.WHITE);
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                SeatGUI seatGUI = new SeatGUI(selectedTheatre, selectedMovie, selectedShowtime);
                seatGUI.window.setVisible(true);
            }
        });
        buttonPanel.add(btnBack);

        // Proceed to Payment button
        JButton btnProceedToPayment = new JButton("Proceed to Payment");
        btnProceedToPayment.setFont(new Font("Arial", Font.BOLD, 14));
        btnProceedToPayment.setBackground(new Color(34, 139, 34)); // A green color for proceed button
        btnProceedToPayment.setForeground(Color.WHITE);
        btnProceedToPayment.setFocusPainted(false);
        btnProceedToPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(window, "Proceeding to payment for Seat(s) " + selectedSeat);
                window.dispose(); // Close BookingDetailsGUI
                // Instantiate MakePaymentGUI and show it
                MakePaymentGUI makePaymentGUI = new MakePaymentGUI();
                makePaymentGUI.window.setVisible(true); // Show MakePaymentGUI window
            }
        });
        buttonPanel.add(btnProceedToPayment);

        // Add the button panel to the main panel
        panel.add(buttonPanel);

        // Add a spacer at the bottom for padding
        panel.add(Box.createVerticalStrut(20));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                BookingDetailsGUI window = new BookingDetailsGUI("Acme Theatre 1", "The Great Adventure", "7:00 PM", "10,11,12");
                window.window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
