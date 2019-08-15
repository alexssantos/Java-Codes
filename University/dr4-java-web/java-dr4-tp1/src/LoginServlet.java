import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPOST");

        String nome = request.getParameter("name");
        String email = request.getParameter("email");
        String senha = request.getParameter("password");

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty())
        {
            response.sendRedirect("loginerror.html");
            return;
        }

        // Define o tipo de dado que será enviado
        response.setContentType( "text/html; charset=UTF-8" );
        request.setCharacterEncoding( "UTF-8");

        // Pega um stream de saída para imprimir a saída
        PrintWriter out = response.getWriter();

        // Gera a saida em formato HTML para o cliente
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Cadastro com Sucesso! </h1>");
        out.println("<h3>Usuario: "+nome+"</h3>");
        out.println("<h3> Email: "+email+" </h3>");
        out.println("</body>");
        out.println("</html>");

        // Fecha o stream de saida
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("button");
        String INDEX_PAGE = "index";

        if (button.equals(INDEX_PAGE)) {
            response.sendRedirect("index.html");
        }
    }
}
