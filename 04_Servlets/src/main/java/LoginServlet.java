import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username"), pass = req.getParameter("password");
        resp.setContentType("text/html;charset=UTF-8");
        boolean ok = "admin".equals(user) && "java123".equals(pass);
        resp.getWriter().println(ok ? "<h2>Login successful</h2>" : "<h2>Invalid username or password</h2>");
    }
}
