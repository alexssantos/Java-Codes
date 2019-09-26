package infnet.alexsantos.dr4tp3.service;

import infnet.alexsantos.dr4tp3.model.LoginForm;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {
    
    private static final String LOGIN_SATATUS_KEY = "login_status";
    private static final String LOGIN_SATATUS_FAILED = "FAILED";
    private static final String LOGIN_SATATUS_OK = "OK";
    
    //@Autowired
    //UserRepository

    public boolean ValidateUserLoged(HttpSession session)
    {
        String status = (session.getAttribute(LOGIN_SATATUS_KEY) != null) ? (String) session.getAttribute(LOGIN_SATATUS_KEY) : LOGIN_SATATUS_FAILED;
        
        if (status.equals(LOGIN_SATATUS_OK))
        {
            return true;
        }
        if (status.equals(LOGIN_SATATUS_FAILED))
        {
            return false;
        }
        
        return false;
    }

    public boolean ValidadeLoginForm(LoginForm form)
    {
        if ((form == null) || (form.getNome().isEmpty()) || (form.getSenha().isEmpty())) {
            return false;
        }
        
        return true;
    }
    
    public boolean setLogin(LoginForm form, HttpSession session)
    {
        //TODO: verificar no banco e validar valores de NOME, SENHA.
    
        if (!(form.getNome().equals("alex")) || !(form.getSenha().equals("123"))){
            return false;
        }
        
        //TODO: SAVE session
        session.setAttribute(LOGIN_SATATUS_KEY, LOGIN_SATATUS_OK);
        session.setAttribute("name", form.getNome());
        
        return true;
    }
    
    public void setLogout(HttpSession session)
    {
        session.removeAttribute(LOGIN_SATATUS_KEY);
    }
}
