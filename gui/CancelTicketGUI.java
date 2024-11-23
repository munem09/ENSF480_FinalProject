import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CancelTicketGUI extends JFrame {

    public CancelTicketGUI() {
        setTitle("Cancel Ticket");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Header label
        JLabel headerLabel = new JLabel("Cancel Your Ticket", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(headerLabel, BorderLayout.NORTH);

        // Panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding for fields

        // Ticket ID label and text field
        JLabel ticketIDLabel = new JLabel("Ticket ID:");
        ticketIDLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField ticketIDField = new JTextField(15);
        ticketIDField.setFont(new Font("Arial", Font.PLAIN, 14));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        inputPanel.add(ticketIDLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(ticketIDField, gbc);

        // Email label and text field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField emailField = new JTextField(15);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        inputPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(emailField, gbc);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton cancelButton = new JButton("Cancel Ticket");
        JButton backButton = new JButton("Back");

        // Cancel Ticket button action
        cancelButton.addActionListener(e -> {
            String ticketID = ticketIDField.getText();
            String email = emailField.getText();

            // Basic validation for empty fields
            if (ticketID.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Placeholder for backend cancellation logic
                JOptionPane.showMessageDialog(this, "Ticket ID " + ticketID + " has been canceled.\nConfirmation sent to " + email + ".");
                // Redirect to WelcomeGUI or another screen
                new WelcomeGUI().window.setVisible(true);
                dispose();
            }
        });

        // Back button action
        backButton.addActionListener(e -> {
            new WelcomeGUI().window.setVisible(true);
            dispose();
        });

        buttonPanel.add(cancelButton);
        buttonPanel.add(backButton);

        // Add components to the frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CancelTicketGUI().setVisible(true));
    }
}
