import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FavoriteColorServlet", urlPatterns = "/favorite-color")
public class FavoriteColorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String colorChoice = request.getParameter("colorChoice");
        request.setAttribute("colorChoice", colorChoice);
        request.getRequestDispatcher("/favorite-color.jsp").forward(request, response);
    }
}
