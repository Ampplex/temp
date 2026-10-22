<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html><html><head><title>Insert Student</title></head><body>
<h2>Insert Student</h2>
<form method="post" action="student-insert.jsp">
Name: <input name="name" required><br><br>Age: <input type="number" name="age" min="1" required><br><br>
Email: <input type="email" name="email"><br><br>Course: <input name="course" required><br><br>
Department ID: <input type="number" name="dept_id" value="1" required><br><br><button type="submit">Insert</button>
</form>
<%
String url="jdbc:mysql://localhost:3306/college?useSSL=false&serverTimezone=UTC", user="root", password="change_me";
try { Class.forName("com.mysql.cj.jdbc.Driver"); } catch(Exception ignored) {}
if ("POST".equalsIgnoreCase(request.getMethod())) {
  try (Connection con=DriverManager.getConnection(url,user,password);
       PreparedStatement ps=con.prepareStatement("INSERT INTO students(name,age,email,course,dept_id) VALUES(?,?,?,?,?)")) {
    ps.setString(1,request.getParameter("name")); ps.setInt(2,Integer.parseInt(request.getParameter("age")));
    ps.setString(3,request.getParameter("email")); ps.setString(4,request.getParameter("course")); ps.setInt(5,Integer.parseInt(request.getParameter("dept_id")));
    ps.executeUpdate(); out.println("<p>Student inserted successfully.</p>");
  } catch(Exception ex) { out.println("<p>Insert failed: "+ex.getMessage().replace("<","&lt;")+"</p>"); }
}
%>
<h3>Current Student Records</h3>
<%
try(Connection con=DriverManager.getConnection(url,user,password); PreparedStatement ps=con.prepareStatement("SELECT id,name,age,email,course FROM students ORDER BY id"); ResultSet rs=ps.executeQuery()) {
%><table border="1" cellpadding="5"><tr><th>ID</th><th>Name</th><th>Age</th><th>Email</th><th>Course</th></tr>
<% while(rs.next()) { %><tr><td><%=rs.getInt("id")%></td><td><%=rs.getString("name")%></td><td><%=rs.getInt("age")%></td><td><%=rs.getString("email")%></td><td><%=rs.getString("course")%></td></tr><% } %></table>
<% } catch(SQLException ex) { out.println("<p>Database error: "+ex.getMessage().replace("<","&lt;")+"</p>"); } %>
</body></html>
