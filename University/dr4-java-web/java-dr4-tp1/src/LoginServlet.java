import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPOST");

        String un = request.getParameter("user");
        String pw = request.getParameter("password");

        if (un.equals("admin") && pw.equals("admin")) {
            response.sendRedirect("loginsuccess.html");
            return;
        } else {
            response.sendRedirect("loginerror.html");
            return;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("button");
        String INDEX_PAGE = "index";

        if (button.equals(INDEX_PAGE)) {
            response.sendRedirect("index.html");
        }
    }
}
