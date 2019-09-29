package infnet.alexssantos.dr4at.service;

import infnet.alexssantos.dr4at.model.AlunoCadastroForm;
import infnet.alexssantos.dr4at.model.LoginForm;
import infnet.alexssantos.dr4at.model.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AuthService {

    private static final String LOGIN_STATUS_KEY = "login_status";
    private static final String LOGIN_STATUS_FAILED = "FAILED";
    private static final String LOGIN_STATUS_OK = "OK";


    @Autowired
    UsuarioService usuarioService;


    public boolean ValidateUserLoged(HttpSession session)
    {
        String status = (session.getAttribute(LOGIN_STATUS_KEY) != null) ? (String) session.getAttribute(LOGIN_STATUS_KEY) : LOGIN_STATUS_FAILED;

        if (status.equals(LOGIN_STATUS_OK))
        {
            return true;
        }
        if (status.equals(LOGIN_STATUS_FAILED))
        {
            return false;
        }

        return false;
    }

    public boolean setLogin(LoginForm form, HttpSession session)
    {
        Usuario usuario = new Usuario(); //usuarioService.getDao().getByNomeAndSenha(form.getNome(), form.getSenha());

        if (usuario == null){
            return false;
        }

        //TODO: SAVE session
        session.setAttribute(LOGIN_STATUS_KEY, LOGIN_STATUS_OK);
        session.setAttribute("name", form.getNome());

        return true;
    }

    public void setLogout(HttpSession session)
    {
        session.removeAttribute(LOGIN_STATUS_KEY);
    }
}
