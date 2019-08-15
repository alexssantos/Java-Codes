package sevlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login")
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int matricula = Integer.parseInt(request.getParameter("matricula"));
        String senha = request.getParameter("senha");

        // TODO: make func Auth User
        if (matricula == 123 && senha.equals("java"))
        {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("mat", matricula);

            RequestDispatcher fwMain = request.getRequestDispatcher("/main");
        }
        else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<Title> Servlet Login <Title>");
                out.println("</head>");
                out.println("<body>");

                out.println("</body>");
                out.println("</html>");
            }
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
