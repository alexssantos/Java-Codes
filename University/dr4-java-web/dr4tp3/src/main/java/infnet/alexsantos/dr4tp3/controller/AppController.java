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
    
    private static final String LOGIN_SATATUS_KEY = "login_status";
    private static final String LOGIN_SATATUS_FAILED = "FAILED";
    private static final String LOGIN_SATATUS_OK = "OK";


    @GetMapping("/")
    public String home(Model model, HttpSession session, String name)
    {
        //TODO: Verificar SESSAO.
            // OK -> Home
            // NAO -> Login
        String status = (session.getAttribute(LOGIN_SATATUS_KEY) != null) ? (String) session.getAttribute(LOGIN_SATATUS_KEY) : LOGIN_SATATUS_FAILED;
        if (status.equals(LOGIN_SATATUS_OK))
        {
            model.addAttribute("name", session.getAttribute("name"));
            return HOME_VIEW;
        }
        if (status.equals(LOGIN_SATATUS_FAILED))
        {
            return CADASTRO_VIEW;
        }
        
        return LOGIN_VIEW;
    }

    @RequestMapping(path= "login", method = RequestMethod.GET)
    public String init(Model model)
    {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return LOGIN_VIEW;      //"login.jsp";
    }
    
    @RequestMapping(path = "login", method = RequestMethod.POST)
    public String loginSubmit(Model model, @ModelAttribute("loginForm") LoginForm loginForm, HttpSession session) {
        
        if ((loginForm != null) && (!loginForm.getNome().isEmpty()) && (!loginForm.getSenha().isEmpty()))
        {
            //TODO: GET Service e validate usuario ->  Object = Validate() | (msg, bool)
            
            if ((loginForm.getNome().equals("alex")) && (loginForm.getSenha().equals("123")))
            {
                //TODO: SAVE session
                session.setAttribute(LOGIN_SATATUS_KEY, LOGIN_SATATUS_OK);
                session.setAttribute("name", loginForm.getNome());
                
                model.addAttribute("name", loginForm.getNome());
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
    
    @RequestMapping(path = "cadastro", method = RequestMethod.POST)
    public String cadastroSubmit(Model model, @ModelAttribute("cadastroForm") LoginForm loginForm, HttpSession session)
    {
        // Validate Form
        
        // Save user.
        
        
        //TODO: GET Service e validate usuario ->  Object = Validate() | (msg, bool)
            
        
        return LOGIN_VIEW;
    }
    

}
