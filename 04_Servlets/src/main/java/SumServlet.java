import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/sum")
public class SumServlet extends HttpServlet {
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            double a = Double.parseDouble(req.getParameter("a")), b = Double.parseDouble(req.getParameter("b"));
            resp.getWriter().println("<h2>Sum = " + (a + b) + "</h2>");
        } catch (NumberFormatException e) { resp.getWriter().println("<h2>Please enter valid numbers.</h2>"); }
    }
}
