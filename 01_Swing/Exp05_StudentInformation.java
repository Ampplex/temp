import javax.swing.*;
import java.awt.*;

public class Exp05_StudentInformation extends JFrame {
    public Exp05_StudentInformation() {
        setTitle("Student Information"); setSize(400, 300); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField name = new JTextField(), roll = new JTextField(), email = new JTextField();
        JComboBox<String> course = new JComboBox<>(new String[]{"CSE", "IT", "ECE", "Mechanical"});
        JButton show = new JButton("Display Details"); JTextArea output = new JTextArea(5, 25); output.setEditable(false);
        JPanel form = new JPanel(new GridLayout(5, 2, 6, 6));
        form.add(new JLabel("Name:")); form.add(name); form.add(new JLabel("Roll No:")); form.add(roll);
        form.add(new JLabel("Email:")); form.add(email); form.add(new JLabel("Course:")); form.add(course);
        form.add(new JLabel("")); form.add(show);
        show.addActionListener(e -> output.setText("Name: " + name.getText() + "\nRoll No: " + roll.getText() + "\nEmail: " + email.getText() + "\nCourse: " + course.getSelectedItem()));
        add(form, BorderLayout.NORTH); add(new JScrollPane(output), BorderLayout.CENTER);
        setLocationRelativeTo(null); setVisible(true);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(Exp05_StudentInformation::new); }
}
