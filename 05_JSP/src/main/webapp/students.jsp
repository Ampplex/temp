<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html><html><head><title>Student Records</title></head><body>
<h2>All Student Records</h2>
<%
String url = "jdbc:mysql://localhost:3306/college?useSSL=false&serverTimezone=UTC";
String dbUser = "root", dbPassword = "change_me";
try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
     PreparedStatement ps = con.prepareStatement("SELECT id,name,age,email,course FROM students ORDER BY id");
     ResultSet rs = ps.executeQuery()) {
%>
<table border="1" cellpadding="6"><tr><th>ID</th><th>Name</th><th>Age</th><th>Email</th><th>Course</th></tr>
<% while (rs.next()) { %><tr><td><%= rs.getInt("id") %></td><td><%= rs.getString("name") %></td><td><%= rs.getInt("age") %></td><td><%= rs.getString("email") %></td><td><%= rs.getString("course") %></td></tr><% } %>
</table>
<% } catch (SQLException ex) { out.println("<p>Database error: " + ex.getMessage().replace("<", "&lt;") + "</p>"); } %>
</body></html>
