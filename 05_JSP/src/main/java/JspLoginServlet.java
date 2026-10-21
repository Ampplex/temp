import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/jsp-login")
public class JspLoginServlet extends HttpServlet {
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username"), password = req.getParameter("password");
        if ("admin".equals(username) && "java123".equals(password)) resp.getWriter().println("<h2>Welcome, admin!</h2>");
        else resp.getWriter().println("<h2>Invalid credentials.</h2><a href='login.jsp'>Try again</a>");
    }
}
