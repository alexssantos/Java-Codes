package alexssantos.infnet.demologin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping({"/","/hello"})
    public String Hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name)
    {
        model.addAttribute("name", name);
        return "hello"; //Model object passes value to hello view (hello.jsp).
    }
}