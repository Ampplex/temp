import javax.swing.*;
import java.awt.*;

public class Exp07_Login extends JFrame {
    public Exp07_Login() {
        setTitle("Login Window"); setSize(320, 180); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField username = new JTextField(); JPasswordField password = new JPasswordField(); JButton login = new JButton("Login");
        setLayout(new GridLayout(3, 2, 6, 6)); add(new JLabel("Username:")); add(username); add(new JLabel("Password:")); add(password); add(new JLabel("")); add(login);
        login.addActionListener(e -> {
            if (username.getText().equals("admin") && new String(password.getPassword()).equals("java123")) JOptionPane.showMessageDialog(this, "Login successful");
            else JOptionPane.showMessageDialog(this, "Invalid username or password");
        });
        setLocationRelativeTo(null); setVisible(true);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(Exp07_Login::new); }
}
