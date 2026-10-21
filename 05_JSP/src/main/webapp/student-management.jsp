<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html><html><head><title>Student Management</title></head><body>
<h2>Student Management (Search / Update / Delete)</h2>
<form method="get" action="student-management.jsp">Search by ID: <input type="number" name="searchId"><button>Search</button></form>
<hr><h3>Update Student</h3>
<form method="post" action="student-management.jsp">
<input type="hidden" name="action" value="update">Student ID: <input type="number" name="id" required>
New name: <input name="name" required> New course: <input name="course" required><button>Update</button></form>
<h3>Delete Student</h3>
<form method="post" action="student-management.jsp"><input type="hidden" name="action" value="delete">Student ID: <input type="number" name="id" required><button>Delete</button></form>
<%
String url="jdbc:mysql://localhost:3306/college?useSSL=false&serverTimezone=UTC", user="root", password="change_me";
String action=request.getParameter("action");
if("POST".equalsIgnoreCase(request.getMethod()) && action!=null) {
  try(Connection con=DriverManager.getConnection(url,user,password)) {
    int id=Integer.parseInt(request.getParameter("id")); int count;
    if("update".equals(action)) { try(PreparedStatement ps=con.prepareStatement("UPDATE students SET name=?,course=? WHERE id=?")) { ps.setString(1,request.getParameter("name")); ps.setString(2,request.getParameter("course")); ps.setInt(3,id); count=ps.executeUpdate(); } }
    else { try(PreparedStatement ps=con.prepareStatement("DELETE FROM students WHERE id=?")) { ps.setInt(1,id); count=ps.executeUpdate(); } }
    out.println(count==1?"<p>Operation successful.</p>":"<p>No student found with that ID.</p>");
  } catch(Exception ex) { out.println("<p>Operation failed: "+ex.getMessage().replace("<","&lt;")+"</p>"); }
}
String search=request.getParameter("searchId");
try(Connection con=DriverManager.getConnection(url,user,password)) {
  String sql="SELECT id,name,age,email,course FROM students";
  if(search!=null && !search.trim().isEmpty()) sql += " WHERE id = ?";
  sql += " ORDER BY id";
  try(PreparedStatement ps=con.prepareStatement(sql)) {
    if(search!=null && !search.trim().isEmpty()) ps.setInt(1,Integer.parseInt(search));
    try(ResultSet rs=ps.executeQuery()) {
%><h3>Student Records</h3><table border="1" cellpadding="5"><tr><th>ID</th><th>Name</th><th>Age</th><th>Email</th><th>Course</th></tr>
<% while(rs.next()) { %><tr><td><%=rs.getInt("id")%></td><td><%=rs.getString("name")%></td><td><%=rs.getInt("age")%></td><td><%=rs.getString("email")%></td><td><%=rs.getString("course")%></td></tr><% } %></table>
<% } } } catch(Exception ex) { out.println("<p>Database error: "+ex.getMessage().replace("<","&lt;")+"</p>"); } %>
</body></html>
