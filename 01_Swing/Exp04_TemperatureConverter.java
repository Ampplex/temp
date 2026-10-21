import javax.swing.*;
import java.awt.*;

public class Exp04_TemperatureConverter extends JFrame {
    public Exp04_TemperatureConverter() {
        setTitle("Temperature Converter"); setSize(380, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField input = new JTextField(10);
        JComboBox<String> direction = new JComboBox<>(new String[]{"Celsius to Fahrenheit", "Fahrenheit to Celsius"});
        JButton convert = new JButton("Convert"); JLabel result = new JLabel("Result: ");
        JPanel p = new JPanel(new GridLayout(4, 1, 5, 5));
        p.add(input); p.add(direction); p.add(convert); p.add(result);
        convert.addActionListener(e -> {
            try {
                double t = Double.parseDouble(input.getText());
                double answer = direction.getSelectedIndex() == 0 ? (t * 9 / 5) + 32 : (t - 32) * 5 / 9;
                result.setText(String.format("Result: %.2f %s", answer, direction.getSelectedIndex() == 0 ? "°F" : "°C"));
            } catch (NumberFormatException ex) { JOptionPane.showMessageDialog(this, "Please enter a valid number."); }
        });
        add(p); setLocationRelativeTo(null); setVisible(true);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(Exp04_TemperatureConverter::new); }
}
