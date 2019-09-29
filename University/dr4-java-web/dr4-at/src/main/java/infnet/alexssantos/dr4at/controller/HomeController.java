package infnet.alexssantos.dr4at.controller;

import infnet.alexssantos.dr4at.controller.validate.ValidateWeb;
import infnet.alexssantos.dr4at.model.LoginForm;
import infnet.alexssantos.dr4at.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/")
public class HomeController {

	private static final String LOGIN_VIEW = "login";
	private static final String CADASTRO_VIEW = "cadastro";
	private static final String HOME_VIEW = "home";


	@Autowired
    private AuthService authService;

	@RequestMapping(path= {"","/home"}, method = RequestMethod.GET)
	public String home(Model model, HttpSession session)
	{
        boolean logged = authService.ValidateUserLoged(session);

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


	// ======================
	// => LOGIN
	// =====================
	@RequestMapping(path= "/login", method = RequestMethod.GET)
	public String login_view(Model model)
	{
		return HOME_VIEW;
	}

	@RequestMapping(path= "/login", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute("loginForm") LoginForm loginForm, HttpSession session)
	{
        if (ValidateWeb.isLoginForm(loginForm))
        {
            boolean loginOk = authService.setLogin(loginForm, session);
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

    @RequestMapping(path= "/logout", method = RequestMethod.GET)
    public String logout_view(Model model, HttpSession session)
    {
        authService.setLogout(session);
        return HOME_VIEW;
    }


	// ======================
	// => REGISTER
	// =====================
	@RequestMapping(path= "/register", method = RequestMethod.GET)
	public String cadastro_view(Model model, HttpSession session)
	{
		//
		return CADASTRO_VIEW;
	}

	@RequestMapping(path= "/register", method = RequestMethod.POST)
	public String cadstro(Model model, HttpSession session, @ModelAttribute("registerForm") LoginForm loginForm)
	{
		//
		return CADASTRO_VIEW;
	}
}
