import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exp01_Calculator extends JFrame implements ActionListener {
    private final JTextField display = new JTextField();
    private double first = 0;
    private String operator = "";
    private boolean newNumber = true;

    public Exp01_Calculator() {
        setTitle("Simple Calculator");
        setSize(320, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] keys = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", "=", "+"};
        for (String key : keys) {
            JButton button = new JButton(key);
            button.addActionListener(this);
            panel.add(button);
        }
        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String key = e.getActionCommand();
        if (key.matches("[0-9]")) {
            if (newNumber) display.setText(key); else display.setText(display.getText() + key);
            newNumber = false;
        } else if (key.equals("C")) {
            display.setText(""); first = 0; operator = ""; newNumber = true;
        } else if (key.equals("=")) {
            try {
                double second = Double.parseDouble(display.getText());
                double result;
                switch (operator) {
                    case "+": result = first + second; break;
                    case "-": result = first - second; break;
                    case "*": result = first * second; break;
                    case "/":
                        if (second == 0) throw new ArithmeticException("Cannot divide by zero");
                        result = first / second; break;
                    default: return;
                }
                display.setText(String.valueOf(result)); operator = ""; newNumber = true;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter a number first.");
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else {
            if (display.getText().isEmpty()) return;
            first = Double.parseDouble(display.getText());
            operator = key; newNumber = true;
        }
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(Exp01_Calculator::new); }
}
