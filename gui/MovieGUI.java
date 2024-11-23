import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MovieGUI {

    public JFrame window;  // Declare JFrame for the window
    private String selectedTheatre;

    public MovieGUI(String selectedTheatre) {
        this.selectedTheatre = selectedTheatre;

        window = new JFrame("Select Movie - AcmePlex");
        window.setBounds(50, 100, 500, 700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel as the main content pane for the window
        JPanel panel = new JPanel();
        panel.setLayout(null);  // Set layout to null for absolute positioning
        window.getContentPane().add(panel);

        // Add label for title
        JLabel lblTitle = new JLabel("Select Movie at " + selectedTheatre);
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTitle.setBounds(100, 20, 350, 30);
        panel.add(lblTitle);

        // Movie options
        JLabel lblMovie = new JLabel("Choose a Movie:");
        lblMovie.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblMovie.setBounds(50, 70, 150, 20);
        panel.add(lblMovie);

        String[] movies = {"Interstellar", "Deadpool", "The Godfather"};
        JComboBox<String> movieDropdown = new JComboBox<>(movies);
        movieDropdown.setBounds(150, 70, 200, 30);
        panel.add(movieDropdown);

        // Showtimes for the selected movie
        JLabel lblShowtime = new JLabel("Select Showtime:");
        lblShowtime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblShowtime.setBounds(50, 130, 150, 20);
        panel.add(lblShowtime);

        String[] showtimes = {"5:00 PM", "7:00 PM", "9:00 PM"};
        JComboBox<String> showtimeDropdown = new JComboBox<>(showtimes);
        showtimeDropdown.setBounds(150, 130, 150, 30);
        panel.add(showtimeDropdown);

        // Select button to proceed to seat selection
        JButton btnSelectMovie = new JButton("Select");
        btnSelectMovie.setBounds(150, 170, 100, 25);
        btnSelectMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMovie = (String) movieDropdown.getSelectedItem();
                String selectedShowtime = (String) showtimeDropdown.getSelectedItem();

                System.out.println("Selected Movie: " + selectedMovie);
                System.out.println("Selected Showtime: " + selectedShowtime);

                // Close current MovieGUI window
                window.dispose();

                // Open SeatGUI for seat selection
                SeatGUI seatGUI = new SeatGUI(selectedTheatre, selectedMovie, selectedShowtime);
                seatGUI.window.setVisible(true);
            }
        });
        panel.add(btnSelectMovie);

        // Back button to return to TheatreSelectGUI
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(150, 210, 100, 25);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                TheatreSelectGUI theatreSelectGUI = new TheatreSelectGUI();
                theatreSelectGUI.window.setVisible(true);
            }
        });
        panel.add(btnBack);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                MovieGUI window = new MovieGUI("Acme Theatre 1");
                window.window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
