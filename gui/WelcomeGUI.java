import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeGUI {

    public JFrame window;

    public WelcomeGUI() {
        window = new JFrame("Welcome to AcmePlex");
        window.setBounds(100, 100, 683, 157);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        window.getContentPane().add(panel);

        JLabel lblWelcome = new JLabel("WELCOME TO ACMEPLEX!");
        lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblWelcome.setBounds(190, 20, 300, 30);
        panel.add(lblWelcome);

        JButton btnCreateAccount = new JButton("Create Account");
        btnCreateAccount.addActionListener(new CreateAccountListener());
        btnCreateAccount.setBounds(50, 80, 150, 25);
        panel.add(btnCreateAccount);

        JButton btnGuest = new JButton("Continue as Guest");
        btnGuest.addActionListener(new GuestListener());
        btnGuest.setBounds(210, 80, 150, 25);
        panel.add(btnGuest);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new LoginListener());
        btnLogin.setBounds(370, 80, 150, 25);
        panel.add(btnLogin);

        JButton btnCancelTicket = new JButton("Cancel Ticket");
        btnCancelTicket.addActionListener(new CancelTicketListener());
        btnCancelTicket.setBounds(530, 80, 150, 25);
        panel.add(btnCancelTicket);
    }

    class CreateAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            window.dispose();
            CreateAccountGUI createAccountGUI = new CreateAccountGUI();
            createAccountGUI.window.setVisible(true);
        }
    }

    class GuestListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            window.dispose();
            TheatreSelectGUI theatreSelectGUI = new TheatreSelectGUI();
            theatreSelectGUI.window.setVisible(true);
        }
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            window.dispose();
            RUserLoginGUI loginGUI = new RUserLoginGUI();
            loginGUI.getWindow().setVisible(true); // Direct access to the window field
        }
    }
    

    class CancelTicketListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            window.dispose();
            new CancelTicketGUI().setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                WelcomeGUI window = new WelcomeGUI();
                window.window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
