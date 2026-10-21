import javax.swing.*;
import java.awt.*;

public class Exp02_StudentRegistration extends JFrame {
    public Exp02_StudentRegistration() {
        setTitle("Student Registration"); setSize(420, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel form = new JPanel(new GridLayout(6, 2, 8, 8));
        JTextField name = new JTextField(), roll = new JTextField();
        JRadioButton male = new JRadioButton("Male"), female = new JRadioButton("Female");
        ButtonGroup gender = new ButtonGroup(); gender.add(male); gender.add(female);
        JPanel genderPanel = new JPanel(); genderPanel.add(male); genderPanel.add(female);
        JComboBox<String> course = new JComboBox<>(new String[]{"B.Tech CSE", "B.Tech IT", "BCA", "MCA"});
        JCheckBox java = new JCheckBox("Java"), dbms = new JCheckBox("DBMS"), web = new JCheckBox("Web Technology");
        JPanel subjects = new JPanel(); subjects.add(java); subjects.add(dbms); subjects.add(web);
        JButton submit = new JButton("Submit");
        form.add(new JLabel("Student Name:")); form.add(name);
        form.add(new JLabel("Roll Number:")); form.add(roll);
        form.add(new JLabel("Gender:")); form.add(genderPanel);
        form.add(new JLabel("Course:")); form.add(course);
        form.add(new JLabel("Subjects:")); form.add(subjects);
        form.add(new JLabel("")); form.add(submit);
        submit.addActionListener(e -> {
            String g = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "Not selected";
            String s = (java.isSelected() ? "Java " : "") + (dbms.isSelected() ? "DBMS " : "") + (web.isSelected() ? "Web Technology" : "");
            JOptionPane.showMessageDialog(this, "Name: " + name.getText() + "\nRoll: " + roll.getText() + "\nGender: " + g + "\nCourse: " + course.getSelectedItem() + "\nSubjects: " + s);
        });
        add(form); setLocationRelativeTo(null); setVisible(true);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(Exp02_StudentRegistration::new); }
}
