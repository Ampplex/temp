import java.sql.*;
import java.util.Scanner;

public class Exp16_DeleteStudent {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in); Connection con = DBUtil.getConnection()) {
            System.out.print("Student ID to delete: "); int id = Integer.parseInt(sc.nextLine());
            try (PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id = ?")) {
                ps.setInt(1, id); int count = ps.executeUpdate(); System.out.println(count == 1 ? "Student deleted." : "Student ID not found.");
            }
        } catch (SQLException | NumberFormatException e) { System.out.println("Error: " + e.getMessage()); }
    }
}
