
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountGUI {

    public JFrame window;  // Declare JFrame for the window
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField cardNumberField;

    public CreateAccountGUI() {
        window = new JFrame("Create Account - AcmePlex");
        window.setBounds(100, 100, 500, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel as the main content pane for the window
        JPanel panel = new JPanel();
        panel.setLayout(null);  // Set layout to null for absolute positioning
        window.getContentPane().add(panel);

        // Add label for title
        JLabel lblTitle = new JLabel("Create New Account");
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTitle.setBounds(150, 20, 200, 30);
        panel.add(lblTitle);

        // Name input
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 70, 100, 25);
        panel.add(lblName);
        nameField = new JTextField();
        nameField.setBounds(150, 70, 200, 25);
        panel.add(nameField);

        // Email input
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 110, 100, 25);
        panel.add(lblEmail);
        emailField = new JTextField();
        emailField.setBounds(150, 110, 200, 25);
        panel.add(emailField);

        // Password input
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 150, 100, 25);
        panel.add(lblPassword);
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 200, 25);
        panel.add(passwordField);

        // Card Number input
        JLabel lblCardNumber = new JLabel("Card Number:");
        lblCardNumber.setBounds(50, 190, 100, 25);
        panel.add(lblCardNumber);
        cardNumberField = new JTextField();
        cardNumberField.setBounds(150, 190, 200, 25);
        panel.add(cardNumberField);

        // Create Account button
        JButton btnCreateAccount = new JButton("Create Account");
        btnCreateAccount.setBounds(150, 230, 150, 25);
        btnCreateAccount.addActionListener(new CreateAccountActionListener());
        panel.add(btnCreateAccount);

        // Back button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(150, 270, 150, 25);
        btnBack.addActionListener(new BackButtonListener());
        panel.add(btnBack);

        // Information text about annual fee
        JLabel lblFeeInfo = new JLabel("Creating account includes an annual charge of $20.");
        lblFeeInfo.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        lblFeeInfo.setBounds(100, 310, 300, 25);
        panel.add(lblFeeInfo);
    }

    // ActionListener for Create Account button
    class CreateAccountActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String cardNumber = cardNumberField.getText();

            // Here you would create the user account using the data
            System.out.println("Account Created for: " + name + " (" + email + ")");
            System.out.println("Card Number: " + cardNumber);

            // Dispose of the current window and return to WelcomeGUI
            window.dispose();
            WelcomeGUI welcomeGUI = new WelcomeGUI();
            welcomeGUI.window.setVisible(true);
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
                CreateAccountGUI window = new CreateAccountGUI();
                window.window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
