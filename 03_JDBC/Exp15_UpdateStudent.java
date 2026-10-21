import java.sql.*;
import java.util.Scanner;

public class Exp15_UpdateStudent {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in); Connection con = DBUtil.getConnection()) {
            System.out.print("Student ID to update: "); int id = Integer.parseInt(sc.nextLine());
            System.out.print("New name: "); String name = sc.nextLine();
            System.out.print("New course: "); String course = sc.nextLine();
            String sql = "UPDATE students SET name = ?, course = ? WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, name); ps.setString(2, course); ps.setInt(3, id);
                int count = ps.executeUpdate(); System.out.println(count == 1 ? "Student updated." : "Student ID not found.");
            }
        } catch (SQLException | NumberFormatException e) { System.out.println("Error: " + e.getMessage()); }
    }
}
