import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaymentGUI extends JFrame {
    private JButton proceedButton;

    public PaymentGUI() {
        setTitle("Payment");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        proceedButton = new JButton("Proceed to Payment");

        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement payment processing logic here
                JOptionPane.showMessageDialog(null, "Payment Processing...");
            }
        });

        add(proceedButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaymentGUI().setVisible(true);
            }
        });
    }
}
