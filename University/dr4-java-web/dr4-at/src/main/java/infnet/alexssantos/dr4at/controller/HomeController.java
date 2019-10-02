package infnet.alexssantos.dr4at.controller;

import infnet.alexssantos.dr4at.controller.validate.ValidateWeb;
import infnet.alexssantos.dr4at.model.AlunoCadastroForm;
import infnet.alexssantos.dr4at.model.LoginForm;
import infnet.alexssantos.dr4at.model.domain.Usuario;
import infnet.alexssantos.dr4at.service.AuthService;
import infnet.alexssantos.dr4at.service.UsuarioService;
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

	@Autowired
    private UsuarioService usuarioService;


	@RequestMapping(path= {"","/home"}, method = RequestMethod.GET)
	public String home(Model model, HttpSession session)
	{
        boolean logged = authService.ValidateUserLoged(session);

        if (logged)
        {
            model.addAttribute(MODEL_ATTR_KEY_NAME, session.getAttribute("name"));
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
            model.addAttribute(MODEL_ATTR_KEY_NAME, session.getAttribute(MODEL_ATTR_KEY_NAME));
            model.addAttribute(MODEL_ATTR_KEY_EMAIL, session.getAttribute(MODEL_ATTR_KEY_EMAIL));
            model.addAttribute(MODEL_ATTR_KEY_MSG, "Parabens, você está logado!");
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
        if (ValidateWeb.loginForm(loginForm))
        {
            Usuario user = authService.setLogin(loginForm, session);
            if (user != null)
            {
                model.addAttribute(MODEL_ATTR_KEY_NAME, user.getNome());
                model.addAttribute(MODEL_ATTR_KEY_EMAIL, user.getEmail());
                model.addAttribute(MODEL_ATTR_KEY_MSG, "Parabens, você está logado!");
                return VIEW_HOME;
            }
        }

        model.addAttribute(MODEL_ATTR_KEY_ERROR, "login invalidos");
        return VIEW_LOGIN;
	}

    @RequestMapping(path= "/logout", method = RequestMethod.GET)
    public String logout_view(Model model, HttpSession session)
    {
        authService.setLogout(session);
        model.addAttribute(MODEL_ATTR_KEY_MSG, "Deslogado com sucesso!");
        return VIEW_LOGIN;
    }


	// ======================
	// => REGISTER
	// =====================
	@RequestMapping(path= "/register", method = RequestMethod.GET)
	public String cadastro_view(Model model, HttpSession session)
	{
        boolean logged = authService.ValidateUserLoged(session);

        if (logged)
        {
            model.addAttribute("name", session.getAttribute("name"));
            return VIEW_HOME;
        }
        else
        {
            return VIEW_CADASTRO;
        }
	}

	@RequestMapping(path= "/register", method = RequestMethod.POST)
	public String cadastro(Model model, HttpSession session, @ModelAttribute("registerForm") AlunoCadastroForm form)
	{
        boolean isFormOk = ValidateWeb.cadastroForm(form);

        if (!isFormOk)
        {
            model.addAttribute("error", "Formulario preenchido errado.");
            return VIEW_CADASTRO;
        }

        Usuario usuario = usuarioService.saveByForm(form);
        if (usuario == null)
        {
            model.addAttribute("error", "Usuario já existe.");
            return VIEW_CADASTRO;
        }

        model.addAttribute("msg", "Usuario "+ form.getNome() +" cadastrado com sucesso.");
        return VIEW_LOGIN;
	}
}
