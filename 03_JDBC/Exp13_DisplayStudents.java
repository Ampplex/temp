import java.sql.*;

public class Exp13_DisplayStudents {
    public static void main(String[] args) {
        String sql = "SELECT id, name, age, email, course FROM students ORDER BY id";
        try (Connection con = DBUtil.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            System.out.println("ID\tName\tAge\tEmail\tCourse");
            while (rs.next()) System.out.printf("%d\t%s\t%d\t%s\t%s%n", rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("email"), rs.getString("course"));
        } catch (SQLException e) { System.out.println("Database error: " + e.getMessage()); }
    }
}
