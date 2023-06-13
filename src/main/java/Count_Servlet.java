import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "count", urlPatterns = "count")
public class Count_Servlet extends HttpServlet {
    private int counter = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String reset = request.getParameter("reset");

        if(reset != null) {
            counter = 0;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><p>counter is now " + counter + "</p?></body></html>");
        counter++;
    }
}
