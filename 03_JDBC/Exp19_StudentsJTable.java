import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Exp19_StudentsJTable extends JFrame {
    public Exp19_StudentsJTable() {
        setTitle("Student Records"); setSize(700, 350); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columns = {"ID", "Name", "Age", "Email", "Course"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        try (Connection con = DBUtil.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery("SELECT id,name,age,email,course FROM students ORDER BY id")) {
            while (rs.next()) model.addRow(new Object[]{rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("email"), rs.getString("course")});
        } catch (SQLException e) { JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage()); }
        add(new JScrollPane(table)); setLocationRelativeTo(null); setVisible(true);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(Exp19_StudentsJTable::new); }
}
