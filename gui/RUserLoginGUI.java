import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RUserLoginGUI {

    private JFrame window;
    private JTextField emailField;
    private JPasswordField passwordField;

    public RUserLoginGUI() {
        // Create main window
        window = new JFrame("Registered User Login - AcmePlex");
        window.setBounds(100, 100, 400, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with vertical layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(245, 245, 245));
        window.getContentPane().add(panel);

        // Title label
        JLabel lblTitle = new JLabel("Registered User Login");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitle.setForeground(new Color(34, 45, 50));
        panel.add(lblTitle);

        // Spacer
        panel.add(Box.createVerticalStrut(15));

        // email field
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        emailPanel.setBackground(panel.getBackground());
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailPanel.add(lblEmail);
        emailPanel.add(emailField);
        panel.add(emailPanel);

        // Spacer
        panel.add(Box.createVerticalStrut(10));

        // Password field
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        passwordPanel.setBackground(panel.getBackground());
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordPanel.add(lblPassword);
        passwordPanel.add(passwordField);
        panel.add(passwordPanel);

        // Spacer
        panel.add(Box.createVerticalStrut(15));

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(panel.getBackground());

        // Login button
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogin.setPreferredSize(new Dimension(100, 35));
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Check credentials (replace with actual authentication logic)
                if (email.equals("registeredUser") && password.equals("password123")) {
                    JOptionPane.showMessageDialog(window, "Login successful! Welcome");
                    window.dispose(); // Close login window
                    AnnouncementGUI announcementGUI = new AnnouncementGUI();
                    announcementGUI.showGUI(); // Open AnnouncementGUI
                } else {
                    JOptionPane.showMessageDialog(window, "Invalid email or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel.add(btnLogin);

        // Back button
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));
        btnBack.setPreferredSize(new Dimension(100, 35));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                WelcomeGUI welcomeGUI = new WelcomeGUI();
                welcomeGUI.window.setVisible(true);
            }
        });
        buttonPanel.add(btnBack);

        panel.add(buttonPanel);

        // Spacer
        panel.add(Box.createVerticalStrut(15));
    }

    public void showGUI() {
        window.setVisible(true);
    }

    // Getter method for the window field
    public JFrame getWindow() {
        return window;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RUserLoginGUI rUserLoginGUI = new RUserLoginGUI();
            rUserLoginGUI.showGUI();
        });
    }
}
