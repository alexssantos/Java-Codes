package infnet.alexsantos.dr4tp3.controller;


import infnet.alexsantos.dr4tp3.model.LoginForm;
import infnet.alexsantos.dr4tp3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class AppController {
    
    @Autowired
    UserService userService;

    private static final String LOGIN_VIEW = "login";
    private static final String CADASTRO_VIEW = "cadastro";
    private static final String HOME_VIEW = "home";


    @GetMapping("/")
    public String home(Model model, Session session, String name)
    {
        //TODO: Verificar SESSAO.
            // OK -> Home
            // NAO -> Login


        model.addAttribute("name", name);
        return "home";
    }

    @RequestMapping(path= "login", method = RequestMethod.GET)
    public String init(Model model)
    {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return LOGIN_VIEW;      //"login.jsp";
    }
    
    @RequestMapping(path = "login", method = RequestMethod.POST)
    public String loginSubmit(Model model, @ModelAttribute("loginForm") LoginForm loginForm) {
        
        if ((loginForm != null) && (!loginForm.getNome().isEmpty()) && (!loginForm.getSenha().isEmpty()))
        {
            //TODO: GET Service e validate usuario.
            // Object = Validate() | (msg, bool)
            if ((loginForm.getNome().equals("alex")) && (loginForm.getSenha().equals("123")))
            {
                //TODO: SAVE session
                model.addAttribute("nome", loginForm.getNome());
                model.addAttribute("msg", "Parabens, você está logado!");
                return HOME_VIEW;
            }
            else {
                model.addAttribute("error", "Invalid Details");
                return LOGIN_VIEW;
            }
        }
        else {
            model.addAttribute("error", "Please enter Details");
            return LOGIN_VIEW;
        }
    }
    

}
