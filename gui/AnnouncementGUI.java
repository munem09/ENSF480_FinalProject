import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnnouncementGUI {

    private JFrame window;

    public AnnouncementGUI() {
        // Create the main window
        window = new JFrame("Announcements - Registered Users");
        window.setBounds(100, 100, 400, 300);  // Set window size
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create main panel with BoxLayout for vertical stacking
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(245, 245, 245));
        window.getContentPane().add(panel);

        // Add a title
        JLabel lblTitle = new JLabel("Important Announcements");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitle.setForeground(new Color(34, 45, 50));
        panel.add(lblTitle);

        // Spacer
        panel.add(Box.createVerticalStrut(15));

        // Scrollable text area for announcements
        JTextArea announcementsArea = new JTextArea(10, 30);
        announcementsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        announcementsArea.setLineWrap(true);
        announcementsArea.setWrapStyleWord(true);
        announcementsArea.setEditable(false);
        announcementsArea.setText(
                "1. AcmePlex will have discounted tickets this weekend!\n\n" +
                "2. Registered users can access early bookings for next month's releases.\n\n" +
                "3. Enjoy a free drink with every ticket purchased this Friday."
        );

        JScrollPane scrollPane = new JScrollPane(announcementsArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);

        // Spacer
        panel.add(Box.createVerticalStrut(15));

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(panel.getBackground());

        // Continue button
        JButton btnContinue = new JButton("Continue");
        btnContinue.setFont(new Font("Arial", Font.BOLD, 14));
        btnContinue.setPreferredSize(new Dimension(100, 35));
        btnContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose(); // Close the current window
                // Navigate to TheatreSelectGUI
                TheatreSelectGUI theatreSelectGUI = new TheatreSelectGUI();
                theatreSelectGUI.showGUI(); // Show the TheatreSelectGUI
            }
        });
        buttonPanel.add(btnContinue);

        panel.add(buttonPanel);

        // Spacer
        panel.add(Box.createVerticalStrut(15));
    }

    public void showGUI() {
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AnnouncementGUI announcementGUI = new AnnouncementGUI();
            announcementGUI.showGUI();
        });
    }
}
