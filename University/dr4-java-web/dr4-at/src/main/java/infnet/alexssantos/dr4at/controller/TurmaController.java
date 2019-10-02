package infnet.alexssantos.dr4at.controller;

import infnet.alexssantos.dr4at.model.domain.Turma;
import infnet.alexssantos.dr4at.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "/turma")
public class TurmaController {

    public static final String VIEW_LIST_TURMA = "turma_list";

    @Autowired
    TurmaService turmaService;

    @RequestMapping(path = {"","/get"}, method = RequestMethod.GET)
    public String get(Model model)
    {
        List<Turma> list = turmaService.findAll();
        model.addAttribute("LIST", list);
        return VIEW_LIST_TURMA;
    }
}
