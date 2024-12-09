// Authentication.java
import javax.servlet.annotation.WebServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/verif")
public class Authentication extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if ("guest".equals(login) && "horizon2024".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("login", login);

            session.setAttribute("message", "Authentication successful!");
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid login or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
