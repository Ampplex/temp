import java.sql.*;

public class Exp18_JoinTables {
    public static void main(String[] args) {
        String sql = "SELECT s.id, s.name, s.course, d.dept_name FROM students s JOIN departments d ON s.dept_id = d.dept_id ORDER BY s.id";
        try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            System.out.println("ID\tStudent\tCourse\tDepartment");
            while (rs.next()) System.out.printf("%d\t%s\t%s\t%s%n", rs.getInt("id"), rs.getString("name"), rs.getString("course"), rs.getString("dept_name"));
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }
}
