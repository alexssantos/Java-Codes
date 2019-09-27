package infnet.alexssantos.dr4at.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/home")
public class HomeController {

	private static final String LOGIN_VIEW = "login";

	@RequestMapping(path= "/login", method = RequestMethod.GET)
	public String login(Model model)
	{
		return LOGIN_VIEW;
	}

}
