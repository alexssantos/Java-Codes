package infnet.alexsantos.dr4tp3.service;

import infnet.alexsantos.dr4tp3.model.LoginForm;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //@Autowired
    //UserRepository

    public boolean ValidateUserLoged(Session sessao)
    {
        return true;
    }

    public boolean ValidadeLogin(LoginForm form)
    {
        //TODO: verificar no banco e validar valores de NOME, SENHA.


        return true;
    }
}
