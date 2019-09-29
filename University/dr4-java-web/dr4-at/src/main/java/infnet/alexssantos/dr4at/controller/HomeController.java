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
public class HomeController extends AbstractController{

	@Autowired
    private AuthService authService;

	@RequestMapping(path= {"","/home"}, method = RequestMethod.GET)
	public String home(Model model, HttpSession session)
	{
        boolean logged = authService.ValidateUserLoged(session);

        if (logged)
        {
            model.addAttribute(VIEW_ATTR_KEY_NAME, session.getAttribute("name"));
            return VIEW_HOME;
        }
        else
        {
            return VIEW_LOGIN;
        }
	}


	// ======================
	// => LOGIN
	// =====================
	@RequestMapping(path= "/login", method = RequestMethod.GET)
	public String login_view(Model model, HttpSession session)
	{
        boolean logged = authService.ValidateUserLoged(session);

        if (logged)
        {
            model.addAttribute(VIEW_ATTR_KEY_NAME, session.getAttribute("name"));
            return VIEW_HOME;
        }
        else
        {
            return VIEW_LOGIN;
        }
	}

	@RequestMapping(path= "/login", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute("loginForm") LoginForm loginForm, HttpSession session)
	{
        if (ValidateWeb.isLoginForm(loginForm))
        {
            boolean loginOk = authService.setLogin(loginForm, session);
            if (loginOk)
            {
                model.addAttribute(VIEW_ATTR_KEY_NAME, loginForm.getNome());
                model.addAttribute(VIEW_ATTR_KEY_MSG, "Parabens, você está logado!");
                return VIEW_HOME;
            }
        }

        model.addAttribute(VIEW_ATTR_KEY_ERROR, "login invalidos");
        return VIEW_LOGIN;
	}

    @RequestMapping(path= "/logout", method = RequestMethod.GET)
    public String logout_view(Model model, HttpSession session)
    {
        authService.setLogout(session);
        model.addAttribute(VIEW_ATTR_KEY_MSG, "Deslogado com sucesso!");
        return VIEW_LOGIN;
    }


	// ======================
	// => REGISTER
	// =====================
	@RequestMapping(path= "/register", method = RequestMethod.GET)
	public String cadastro_view(Model model, HttpSession session)
	{
		//
		return VIEW_CADASTRO;
	}

	@RequestMapping(path= "/register", method = RequestMethod.POST)
	public String cadstro(Model model, HttpSession session, @ModelAttribute("registerForm") LoginForm loginForm)
	{
		//
		return VIEW_CADASTRO;
	}
}
