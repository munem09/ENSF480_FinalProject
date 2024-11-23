import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TheatreSelectGUI {

    public JFrame window;  // Declare JFrame for the window

    public TheatreSelectGUI() {

        window = new JFrame("Select Theatre - AcmePlex");
        window.setBounds(100, 100, 500, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel as the main content pane for the window
        JPanel panel = new JPanel();
        panel.setLayout(null);  // Set layout to null for absolute positioning
        window.getContentPane().add(panel);

        // Add label for title
        JLabel lblTitle = new JLabel("Select Theatre");
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTitle.setBounds(180, 20, 200, 30);
        panel.add(lblTitle);

        // Theatre options
        JLabel lblTheatre = new JLabel("Choose a Theatre:");
        lblTheatre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblTheatre.setBounds(50, 70, 150, 20);
        panel.add(lblTheatre);

        String[] theatres = {"Acme Theatre 1", "Acme Theatre 2", "Acme Theatre 3"};
        JComboBox<String> theatreDropdown = new JComboBox<>(theatres);
        theatreDropdown.setBounds(150, 70, 150, 30);
        panel.add(theatreDropdown);

        // Select Theatre button
        JButton btnSelectTheatre = new JButton("Select Theatre");
        btnSelectTheatre.setBounds(150, 110, 150, 30);
        btnSelectTheatre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTheatre = (String) theatreDropdown.getSelectedItem();
                System.out.println("Selected Theatre: " + selectedTheatre);  // You can process this info as needed

                // Pass the selected theatre to the MovieGUI
                window.dispose();  // Close the current window
                MovieGUI movieGUI = new MovieGUI(selectedTheatre);  // Pass the selected theatre to MovieGUI
                movieGUI.window.setVisible(true);
            }
        });
        panel.add(btnSelectTheatre);

        // Back button to go back to the WelcomeGUI
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(150, 150, 100, 30);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                WelcomeGUI welcomeGUI = new WelcomeGUI();
                welcomeGUI.window.setVisible(true);
            }
        });
        panel.add(btnBack);

    }

    public void showGUI() {
        window.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                TheatreSelectGUI window = new TheatreSelectGUI();
                window.window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
