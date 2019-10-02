package infnet.alexssantos.dr4at.controller;

import infnet.alexssantos.dr4at.model.domain.Curso;
import infnet.alexssantos.dr4at.model.domain.Professor;
import infnet.alexssantos.dr4at.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "/professor")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @RequestMapping(path = {"","/get"}, method = RequestMethod.GET)
    public String get(Model model)
    {
        List<Professor> profList = professorService.findAll();
        model.addAttribute("PROFESSORES", profList);

        return "professor_list";
    }
}
