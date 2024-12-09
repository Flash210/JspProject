// Authentication.java
import javax.servlet.annotation.WebServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/verif") // Define the URL pattern here
public class Authentication extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if ("guest".equals(login) && "horizon2024".equals(password)) {
            // Create session and set login attribute
            HttpSession session = request.getSession();
            session.setAttribute("login", login);

            // Set success message and redirect to index.jsp
            session.setAttribute("message", "Authentication successful!");
            response.sendRedirect("index.jsp");
        } else {
            // Set error message and redirect to login.jsp
            request.setAttribute("errorMessage", "Invalid login or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
