<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html><html><head><title>JSP Welcome</title></head><body>
<h1>Welcome to JSP</h1>
<%-- JSP comment --%>
<%! int visitCount = 0; %>
<% visitCount++; String studentName = request.getParameter("name"); if (studentName == null || studentName.trim().isEmpty()) studentName = "Student"; %>
<p>Hello, <%= studentName.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;") %>!</p>
<p>This page has been requested <%= visitCount %> time(s) by the current JSP instance.</p>
<p>Today's date: <%= new java.util.Date() %></p>
</body></html>
