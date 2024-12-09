// InfoServlet.java
import javax.servlet.annotation.WebServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;

@WebServlet("/detail") // Define the URL pattern here
public class InfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Get session if exists

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (session == null) {
            out.println("<h3>You must log in to view this information.</h3>");
        } else {
            String login = (String) session.getAttribute("login");
            Date creationTime = new Date(session.getCreationTime());
            Date currentTime = new Date();
            long elapsedTimeMillis = currentTime.getTime() - creationTime.getTime();

            long elapsedHours = elapsedTimeMillis / (1000 * 60 * 60);
            long elapsedMinutes = (elapsedTimeMillis % (1000 * 60 * 60)) / (1000 * 60);
            long elapsedSeconds = (elapsedTimeMillis % (1000 * 60)) / 1000;

            out.println("<h3>Session Information</h3>");
            out.println("<p>Login: " + login + "</p>");
            out.println("<p>System Date: " + currentTime.toString() + "</p>");
            out.println("<p>Session Creation Date: " + creationTime.toString() + "</p>");
            out.println("<p>Session ID: " + session.getId() + "</p>");
            out.println("<p>Time Elapsed: " + elapsedHours + " hours, " + elapsedMinutes + " minutes, " + elapsedSeconds + " seconds.</p>");
            out.println("<a href='LogoutServlet'>Logout</a>");
        }
    }
}
