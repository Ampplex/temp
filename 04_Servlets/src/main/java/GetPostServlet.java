import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/get-post")
public class GetPostServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h2>doGet() was called</h2><form method='post' action='get-post'>Your name: <input name='name'><button>Send using POST</button></form>");
    }
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); String name = req.getParameter("name");
        if (name == null) name = "";
        name = name.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
        resp.getWriter().println("<h2>doPost() was called</h2><p>Hello, " + name + "</p><a href='get-post'>Back</a>");
    }
}
