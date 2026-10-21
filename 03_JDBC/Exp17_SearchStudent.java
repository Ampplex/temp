import java.sql.*;
import java.util.Scanner;

public class Exp17_SearchStudent {
    public static void main(String[] args) {
        String sql;
        try (Scanner sc = new Scanner(System.in); Connection con = DBUtil.getConnection()) {
            System.out.print("Search by 1=ID or 2=Name: "); int choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                System.out.print("Enter ID: "); int id = Integer.parseInt(sc.nextLine());
                sql = "SELECT id, name, age, email, course FROM students WHERE id = ?";
                try (PreparedStatement ps = con.prepareStatement(sql)) { ps.setInt(1, id); show(ps); }
            } else if (choice == 2) {
                System.out.print("Enter name or part of name: "); String name = sc.nextLine();
                sql = "SELECT id, name, age, email, course FROM students WHERE name LIKE ?";
                try (PreparedStatement ps = con.prepareStatement(sql)) { ps.setString(1, "%" + name + "%"); show(ps); }
            } else System.out.println("Invalid choice.");
        } catch (SQLException | NumberFormatException e) { System.out.println("Error: " + e.getMessage()); }
    }
    private static void show(PreparedStatement ps) throws SQLException {
        try (ResultSet rs = ps.executeQuery()) {
            boolean found = false;
            while (rs.next()) { found = true; System.out.printf("%d | %s | %d | %s | %s%n", rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("email"), rs.getString("course")); }
            if (!found) System.out.println("No matching student found.");
        }
    }
}
