import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheatreSelectGUI {

    public JFrame window;  // Declare JFrame for the window
    private JComboBox<String> theatreDropdown;  // Dropdown for theatre selection

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
        lblTitle.setBounds(150, 20, 200, 30);
        panel.add(lblTitle);

        // Dropdown for selecting a theatre
        String[] theatres = {"Theatre 1", "Theatre 2", "Theatre 3", "Theatre 4"};
        theatreDropdown = new JComboBox<>(theatres);
        theatreDropdown.setBounds(150, 70, 200, 30);
        panel.add(theatreDropdown);

        // Button to select the theatre
        JButton btnSelectTheatre = new JButton("Select Theatre");
        btnSelectTheatre.setBounds(150, 120, 150, 25);
        btnSelectTheatre.addActionListener(new SelectTheatreListener());
        panel.add(btnSelectTheatre);

        // Back button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(150, 160, 150, 25);
        btnBack.addActionListener(new BackButtonListener());
        panel.add(btnBack);
    }

    // ActionListener for the "Select Theatre" button
    class SelectTheatreListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedTheatre = (String) theatreDropdown.getSelectedItem();
            System.out.println("Theatre selected: " + selectedTheatre);
            // Proceed with the selected theatre (you can add more logic here)
        }
    }

    // ActionListener for Back button
    class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            window.dispose();
            WelcomeGUI welcomeGUI = new WelcomeGUI();
            welcomeGUI.window.setVisible(true);
        }
    }

    // Main method to run the application
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
