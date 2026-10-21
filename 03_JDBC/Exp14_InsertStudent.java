import java.sql.*;
import java.util.Scanner;

public class Exp14_InsertStudent {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in); Connection con = DBUtil.getConnection()) {
            // nextLine() reads the entire line up to Enter, including spaces, and consumes the newline.
            // Example: entering "Ada Lovelace" stores both words; pressing Enter without text returns "".
            System.out.print("Name: "); String name = sc.nextLine();
            System.out.print("Age: "); int age = Integer.parseInt(sc.nextLine());
            System.out.print("Email: "); String email = sc.nextLine();
            System.out.print("Course: "); String course = sc.nextLine();
            System.out.print("Department ID (1 if unknown): "); int dept = Integer.parseInt(sc.nextLine());
            String sql = "INSERT INTO students(name, age, email, course, dept_id) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, name); ps.setInt(2, age); ps.setString(3, email); ps.setString(4, course); ps.setInt(5, dept);
                System.out.println(ps.executeUpdate() == 1 ? "Student inserted successfully." : "No row inserted.");
            }
        } catch (SQLException | NumberFormatException e) { System.out.println("Error: " + e.getMessage()); }
    }
}
