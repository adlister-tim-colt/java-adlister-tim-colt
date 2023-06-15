import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name="PizzaOrderServlet", urlPatterns = "/pizza-order")
public class PizzaOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher("/pizza-order.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            String size = request.getParameter("size");
            String sauce = request.getParameter("sauce");
            String crust = request.getParameter("crust");
            String toppings = Arrays.toString(request.getParameterValues("toppings"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address1 = request.getParameter("address1");
            String address2 = request.getParameter("address2");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");
            System.out.println(size + " with " + sauce +  " sauce " + "& " + crust + " Style Crust");
            System.out.println(toppings);
            System.out.println(firstName + " " + lastName);
            System.out.println(address1 + " " + address2);
            System.out.println(city + " "  + state + " " + zip);


            response.sendRedirect("/pizza-order");

    }

}
