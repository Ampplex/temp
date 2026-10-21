import java.sql.*;
import java.util.Scanner;

public class Exp20_TransactionDemo {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in); Connection con = DBUtil.getConnection()) {
            System.out.print("First student ID: "); int id1 = Integer.parseInt(sc.nextLine());
            System.out.print("Second student ID: "); int id2 = Integer.parseInt(sc.nextLine());
            System.out.print("New course for both students: "); String course = sc.nextLine();
            con.setAutoCommit(false);
            try (PreparedStatement ps = con.prepareStatement("UPDATE students SET course = ? WHERE id = ?")) {
                ps.setString(1, course); ps.setInt(2, id1); int first = ps.executeUpdate();
                ps.setString(1, course); ps.setInt(2, id2); int second = ps.executeUpdate();
                if (first == 1 && second == 1) { con.commit(); System.out.println("Both updates committed successfully."); }
                else { con.rollback(); System.out.println("At least one ID was not found. Both updates rolled back."); }
            } catch (SQLException e) { con.rollback(); throw e; }
            finally { con.setAutoCommit(true); }
        } catch (SQLException | NumberFormatException e) { System.out.println("Transaction error: " + e.getMessage()); }
    }
}
