import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeatGUI {

    public JFrame window;  // Declare JFrame for the window
    private String selectedTheatre;
    private String selectedMovie;
    private String selectedShowtime;

    private StringBuilder selectedSeats;  // Variable to store selected seats

    public SeatGUI(String selectedTheatre, String selectedMovie, String selectedShowtime) {
        this.selectedTheatre = selectedTheatre;
        this.selectedMovie = selectedMovie;
        this.selectedShowtime = selectedShowtime;

        selectedSeats = new StringBuilder();  // Initialize the StringBuilder to store selected seats

        window = new JFrame("Select Seats - AcmePlex");
        window.setBounds(100, 100, 500, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main panel with BoxLayout for vertical stacking of components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        window.getContentPane().add(panel);

        // Header label for Seat Selection
        JLabel lblTitle = new JLabel("Select Seats for " + selectedMovie + " at " + selectedTheatre);
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblTitle);

        // Spacer for padding between title and "Screen" text
        panel.add(Box.createVerticalStrut(60));

        // "Screen" label
        JLabel lblScreen = new JLabel("Screen");
        lblScreen.setFont(new Font("Arial", Font.BOLD, 18));
        lblScreen.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblScreen);

        // Spacer for padding between "Screen" and the dashed line
        panel.add(Box.createVerticalStrut(5));

        // Custom dashed line below "Screen"
        JPanel dashedLinePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                float[] dashPattern = {5, 5};
                g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dashPattern, 0));
                g2.setColor(Color.BLACK);
                int lineWidth = 200; // Width of the dashed line
                int xStart = (getWidth() - lineWidth) / 2; // Center the line
                g2.drawLine(xStart, getHeight() / 2, xStart + lineWidth, getHeight() / 2);
            }
        };
        dashedLinePanel.setPreferredSize(new Dimension(400, 10));
        dashedLinePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(dashedLinePanel);

        // Spacer for some padding between dashed line and seat grid
        panel.add(Box.createVerticalStrut(20));

        // Create a panel for the seat grid with GridLayout
        JPanel seatGridPanel = new JPanel();
        seatGridPanel.setLayout(new GridLayout(5, 5, 10, 10));  // Create a 5x5 grid layout for seats

        // Adding seat buttons in a grid pattern
        JButton[] seatButtons = new JButton[25];  // 25 seats in the grid
        for (int i = 0; i < 25; i++) {
            seatButtons[i] = new JButton(String.valueOf(i + 1));
            seatButtons[i].setFont(new Font("Arial", Font.PLAIN, 14));
            seatButtons[i].setBackground(Color.GREEN);
            seatButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton selectedSeatButton = (JButton) e.getSource();
                    String seatNumber = selectedSeatButton.getText();  // Get the selected seat number
                    if (selectedSeats.indexOf(seatNumber) == -1) {  // If seat is not already selected
                        if (selectedSeats.length() > 0) {
                            selectedSeats.append(",");  // Add a comma if this is not the first seat
                        }
                        selectedSeats.append(seatNumber);  // Append the seat number to the selected seats string
                        selectedSeatButton.setBackground(Color.RED);  // Change the color to indicate the seat is taken
                        JOptionPane.showMessageDialog(window, "You have selected Seat " + seatNumber);
                    } else {
                        // If the seat is already selected, deselect it
                        selectedSeats.delete(selectedSeats.indexOf(seatNumber), selectedSeats.indexOf(seatNumber) + seatNumber.length());
                        if (selectedSeats.length() > 0 && selectedSeats.charAt(selectedSeats.length() - 1) == ',') {
                            selectedSeats.deleteCharAt(selectedSeats.length() - 1);  // Remove the trailing comma
                        }
                        selectedSeatButton.setBackground(Color.GREEN);  // Change the color back
                        JOptionPane.showMessageDialog(window, "You have deselected Seat " + seatNumber);
                    }
                }
            });
            seatGridPanel.add(seatButtons[i]);
        }

        // Add the seat grid panel to the main panel
        panel.add(seatGridPanel);

        // Spacer for padding between grid and buttons
        panel.add(Box.createVerticalStrut(20));

        // Create a panel for the Continue and Back buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Continue button
        JButton btnContinue = new JButton("Continue");
        btnContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedSeats.length() == 0) {
                    JOptionPane.showMessageDialog(window, "Please select at least one seat before continuing.");
                    return;
                }

                // Pass the selected details to BookingDetailsGUI
                window.dispose();
                BookingDetailsGUI bookingDetailsGUI = new BookingDetailsGUI(selectedTheatre, selectedMovie, selectedShowtime, selectedSeats.toString());
                bookingDetailsGUI.window.setVisible(true);
            }
        });
        buttonPanel.add(btnContinue);

        // Back button to go back to MovieGUI
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                MovieGUI movieGUI = new MovieGUI(selectedTheatre);  // Pass the selected theatre
                movieGUI.window.setVisible(true);
            }
        });
        buttonPanel.add(btnBack);

        // Add the button panel to the main panel
        panel.add(buttonPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                SeatGUI window = new SeatGUI("Acme Theatre 1", "The Great Adventure", "7:00 PM");
                window.window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
