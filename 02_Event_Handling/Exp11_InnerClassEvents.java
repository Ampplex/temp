import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exp11_InnerClassEvents extends JFrame {
    private final JTextField a = new JTextField(6), b = new JTextField(6);
    private final JLabel result = new JLabel("Result: ");
    public Exp11_InnerClassEvents() {
        setTitle("Arithmetic Operations"); setSize(450, 180); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel top = new JPanel(); top.add(new JLabel("First number:")); top.add(a); top.add(new JLabel("Second:")); top.add(b);
        JPanel buttons = new JPanel();
        JButton add = new JButton("Add"), subtract = new JButton("Subtract"), multiply = new JButton("Multiply"), divide = new JButton("Divide");
        add.addActionListener(new AddListener()); // named inner class
        subtract.addActionListener(e -> calculate('-')); // anonymous class can also be written as lambda; replace below with anonymous listener
        multiply.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { calculate('*'); } });
        divide.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { calculate('/'); } });
        buttons.add(add); buttons.add(subtract); buttons.add(multiply); buttons.add(divide);
        add(top, BorderLayout.NORTH); add(buttons, BorderLayout.CENTER); add(result, BorderLayout.SOUTH);
        setLocationRelativeTo(null); setVisible(true);
    }
    private class AddListener implements ActionListener { public void actionPerformed(ActionEvent e) { calculate('+'); } }
    private void calculate(char op) {
        try {
            double x = Double.parseDouble(a.getText()), y = Double.parseDouble(b.getText()), r;
            switch (op) { case '+': r=x+y; break; case '-': r=x-y; break; case '*': r=x*y; break; default: if (y==0) throw new ArithmeticException("Cannot divide by zero"); r=x/y; }
            result.setText("Result: " + r);
        } catch (NumberFormatException ex) { JOptionPane.showMessageDialog(this, "Enter valid numbers."); }
          catch (ArithmeticException ex) { JOptionPane.showMessageDialog(this, ex.getMessage()); }
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(Exp11_InnerClassEvents::new); }
}
