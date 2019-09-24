package alexssantos.loginsession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping({"/", "/hello"})
	public ModelAndView hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
		ModelAndView mav = new ModelAndView("hello");
		mav.addObject("name", name);
		return mav;
	}
}
