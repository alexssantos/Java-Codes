package infnet.alexsantos.dr4tp3.service;

import infnet.alexsantos.dr4tp3.model.CadastroForm;
import infnet.alexsantos.dr4tp3.model.LoginForm;
import infnet.alexsantos.dr4tp3.model.domain.Usuario;
import infnet.alexsantos.dr4tp3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {
    
    private static final String LOGIN_STATUS_KEY = "login_status";
    private static final String LOGIN_STATUS_FAILED = "FAILED";
    private static final String LOGIN_STATUS_OK = "OK";
    
    @Autowired
    UsuarioRepository dao;

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

    public boolean ValidadeLoginForm(LoginForm form)
    {
        if ((form == null) || (form.getNome().isEmpty()) || (form.getSenha().isEmpty())) {
            return false;
        }
        
        return true;
    }
    
    public boolean ValidateCadastroForm(CadastroForm form)
    {
        if ((form == null) || (form.getNome().isEmpty()) || (form.getSenha().isEmpty()) || form.getEmail().isEmpty()) {
            return false;
        }
    
        return true;
    }
    
    public boolean setLogin(LoginForm form, HttpSession session)
    {
        Usuario usuario = dao.getByNomeAndSenha(form.getNome(), form.getSenha());
        
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
    
    public List<Usuario> getAll()
    {
        return  dao.findAll();
    }
    
    public Usuario getByEmail(String email)
    {
        Usuario usuario = dao.getByEmail(email);
        return usuario;
    }
    
    public Usuario save(Usuario usuario)
    {
        return dao.save(usuario);
    }
    
    public Usuario saveByForm(CadastroForm form)
    {
        Usuario obj = getByEmail(form.getEmail());
        if (obj != null)
        {
            return null;
        }
        Usuario usuario = new Usuario(form.getNome(), form.getEmail(), form.getSenha());
        return save(usuario);
    }
    
    
}
