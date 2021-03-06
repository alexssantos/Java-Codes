package infnet.alexsantos.dr4tp3.controller;


import infnet.alexsantos.dr4tp3.model.CadastroForm;
import infnet.alexsantos.dr4tp3.model.LoginForm;
import infnet.alexsantos.dr4tp3.model.domain.Usuario;
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
    public String home(Model model, HttpSession session)
    {
        boolean logged = userService.ValidateUserLoged(session);
        
        if (logged)
        {
            model.addAttribute("name", session.getAttribute("name"));
            return HOME_VIEW;
        }
        else
        {
            return LOGIN_VIEW;
        }
    }

    @RequestMapping(path= "login", method = RequestMethod.GET)
    public String login(Model model)
    {
        return LOGIN_VIEW;
    }
    
    @RequestMapping(path = "login", method = RequestMethod.POST)
    public String loginSubmit(Model model, @ModelAttribute("loginForm") LoginForm loginForm, HttpSession session) {
        
        if (userService.ValidadeLoginForm(loginForm))
        {
            boolean loginOk = userService.setLogin(loginForm, session);
            if (loginOk)
            {
                model.addAttribute("name", loginForm.getNome());
                model.addAttribute("msg", "Parabens, você está logado!");
                return HOME_VIEW;
            }
        }
        
        model.addAttribute("error", "login invalidos");
        return LOGIN_VIEW;
    }
    
    @RequestMapping(path= "logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session)
    {
        userService.setLogout(session);
        model.addAttribute("msg", "Deslogado com sucesso!");
        return LOGIN_VIEW;
    }
    
    @RequestMapping(path = "cadastro", method = RequestMethod.GET)
    public String cadastro(Model model, HttpSession session)
    {
        boolean logged = userService.ValidateUserLoged(session);
    
        if (logged)
        {
            model.addAttribute("name", session.getAttribute("name"));
            return HOME_VIEW;
        }
        else
        {
            return CADASTRO_VIEW;
        }
    }
    
    
    @RequestMapping(path = "cadastro", method = RequestMethod.POST)
    public String cadastroSubmit(Model model, @ModelAttribute("cadastroForm") CadastroForm cadastroForm, HttpSession session)
    {
        boolean isFormOk = userService.ValidateCadastroForm(cadastroForm);
        
        if (!isFormOk)
        {
	        model.addAttribute("error", "Formulario preenchido errado.");
	        return CADASTRO_VIEW;
        }
        
        Usuario usuario = userService.saveByForm(cadastroForm);
        if (usuario == null)
        {
	        model.addAttribute("error", "Usuario já existe.");
	        return CADASTRO_VIEW;
        }
	
	    model.addAttribute("msg", "Usuario "+ cadastroForm.getNome() +" cadastrado com sucesso.");
        return LOGIN_VIEW;
    }
    

}
