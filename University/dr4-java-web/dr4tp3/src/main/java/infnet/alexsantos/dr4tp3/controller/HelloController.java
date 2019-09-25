package infnet.alexsantos.dr4tp3.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping()
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name)
    {
        model.addAttribute("name", name);
        return "hello";
    }
    
    @GetMapping("/cadastro")
    public String cadastro(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name)
    {
        model.addAttribute("name", name);
        return "cadastro";
    }
    
    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name)
    {
        model.addAttribute("name", name);
        return "login";
    }
    
    @GetMapping("/home")
    public String home(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name)
    {
        model.addAttribute("name", name);
        return "home";
    }

}
