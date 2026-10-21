import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/student-details")
public class StudentDetailsServlet extends HttpServlet {
    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name"), roll = request.getParameter("roll"), course = request.getParameter("course");
        response.getWriter().println("<html><body><h2>Student Details</h2><p>Name: " + esc(name) + "</p><p>Roll: " + esc(roll) + "</p><p>Course: " + esc(course) + "</p></body></html>");
    }
    private String esc(String s) { if (s == null) return ""; return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#x27;"); }
}
