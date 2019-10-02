package infnet.alexssantos.dr4at.controller;

import infnet.alexssantos.dr4at.model.domain.Curso;
import infnet.alexssantos.dr4at.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @RequestMapping(path = {"","/get"}, method = RequestMethod.GET)
    public String getCursos(Model model)
    {
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("CURSOS", cursos);

        return "curso_list";
    }
}
