package infnet.alexssantos.dr4at.controller;

import infnet.alexssantos.dr4at.model.domain.Aluno;
import infnet.alexssantos.dr4at.model.domain.Curso;
import infnet.alexssantos.dr4at.model.domain.Disciplina;
import infnet.alexssantos.dr4at.service.AlunoService;
import infnet.alexssantos.dr4at.service.CursoService;
import infnet.alexssantos.dr4at.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "/aluno")
public class AlunoController {

    public static final String VIEW_LIST_ALUNO = "aluno_list";
    public static final String VIEW_CREATE_ALUNO = "aluno_create";

    @Autowired
    AlunoService alunoService;
    @Autowired
    CursoService cursoService;

    @RequestMapping(path = {"","/get"}, method = RequestMethod.GET)
    public String get(Model model)
    {
        List<Aluno> list = alunoService.findAll();
        model.addAttribute("LIST", list);
        return VIEW_LIST_ALUNO;
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String create_view(Model model)
    {
        List<Curso> list = cursoService.findAll();
        model.addAttribute("CURSO_LIST", list);
        return VIEW_CREATE_ALUNO;
    }
}
