package infnet.alexssantos.dr4at.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/")
public class HomeController {

	private static final String LOGIN_VIEW = "login";
	private static final String HOME_VIEW = "home";


	@RequestMapping(path= {"","/login"}, method = RequestMethod.GET)
	public String home(Model model, HttpSession session)
	{
		//
		return login(model);
	}


	@RequestMapping(path= "/login", method = RequestMethod.GET)
	public String login(Model model)
	{
		return LOGIN_VIEW;
	}

	@RequestMapping(path= "/home", method = RequestMethod.GET)
	public String homePage(Model model)
	{
		return HOME_VIEW;
	}

}
