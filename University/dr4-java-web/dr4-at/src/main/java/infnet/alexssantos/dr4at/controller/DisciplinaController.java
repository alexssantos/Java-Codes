package infnet.alexssantos.dr4at.controller;

import infnet.alexssantos.dr4at.model.domain.Disciplina;
import infnet.alexssantos.dr4at.model.domain.Professor;
import infnet.alexssantos.dr4at.service.DisciplinaService;
import infnet.alexssantos.dr4at.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "/disciplina")
public class DisciplinaController {

    public static final String VIEW_LIST_DISCIPLINA = "disciplina_list";

    @Autowired
    DisciplinaService disciplinaService;

    @RequestMapping(path = {"","/get"}, method = RequestMethod.GET)
    public String get(Model model)
    {
        List<Disciplina> list = disciplinaService.findAll();
        model.addAttribute("LIST", list);
        return VIEW_LIST_DISCIPLINA;
    }
}
