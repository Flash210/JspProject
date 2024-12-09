// LogoutServlet.java
import javax.servlet.annotation.WebServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/LogoutServlet") // Define the URL pattern here
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }

        // Set message and redirect to index.jsp
        HttpSession newSession = request.getSession();
        newSession.setAttribute("message", "You are disconnected.");
        response.sendRedirect("index.jsp");
    }
}
