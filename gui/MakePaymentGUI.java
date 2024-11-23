import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakePaymentGUI {

    public JFrame window;  // Declare JFrame for the window

    public MakePaymentGUI() {
        window = new JFrame("Make Payment - AcmePlex");
        window.setBounds(100, 100, 500, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel with null layout for absolute positioning
        JPanel panel = new JPanel();
        panel.setLayout(null);  // Set layout to null for absolute positioning
        window.getContentPane().add(panel);

        // Title label for Make Payment
        JLabel lblTitle = new JLabel("Payment Details");
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTitle.setBounds(170, 20, 200, 30);
        panel.add(lblTitle);

        // Name input field
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(30, 70, 100, 25);
        panel.add(lblName);
        JTextField tfName = new JTextField();
        tfName.setBounds(170, 70, 200, 25);
        panel.add(tfName);

        // Email input field
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 110, 100, 25);
        panel.add(lblEmail);
        JTextField tfEmail = new JTextField();
        tfEmail.setBounds(170, 110, 200, 25);
        panel.add(tfEmail);

        // Card Number input field
        JLabel lblCardNumber = new JLabel("Card Number:");
        lblCardNumber.setBounds(30, 150, 100, 25);
        panel.add(lblCardNumber);
        JTextField tfCardNumber = new JTextField();
        tfCardNumber.setBounds(170, 150, 200, 25);
        panel.add(tfCardNumber);

        // Validity (Expiry Date) input field
        JLabel lblValidity = new JLabel("Expiry Date (MM/YY):");
        lblValidity.setBounds(30, 190, 200, 25);
        panel.add(lblValidity);
        JTextField tfValidity = new JTextField();
        tfValidity.setBounds(170, 190, 100, 25);
        panel.add(tfValidity);

        // CVV input field
        JLabel lblCVV = new JLabel("CVV:");
        lblCVV.setBounds(30, 230, 100, 25);
        panel.add(lblCVV);
        JTextField tfCVV = new JTextField();
        tfCVV.setBounds(170, 230, 100, 25);
        panel.add(tfCVV);

        // Spacer for padding between form and buttons
        panel.add(Box.createVerticalStrut(30));

        // Back button to go back to BookingDetailsGUI
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));
        btnBack.setFocusPainted(false);
        btnBack.setBounds(150, 270, 80, 25);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                BookingDetailsGUI bookingDetailsGUI = new BookingDetailsGUI("Acme Theatre 1", "The Great Adventure", "7:00 PM", "A1");
                bookingDetailsGUI.window.setVisible(true);
            }
        });
        panel.add(btnBack);

        // Pay button
        JButton btnPay = new JButton("Pay");
        btnPay.setFont(new Font("Arial", Font.BOLD, 14));
        btnPay.setFocusPainted(false);
        btnPay.setBounds(250, 270, 80, 25);
        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // You can add logic to process payment here
                JOptionPane.showMessageDialog(window, "Receipt sent to Email. Payment Successful for " + tfName.getText());
                window.dispose();  // Close the payment window after payment is successful
            }
        });
        panel.add(btnPay);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                MakePaymentGUI window = new MakePaymentGUI();
                window.window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
