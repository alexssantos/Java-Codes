package infnet.alexssantos.dr4at.controller;

import infnet.alexssantos.dr4at.model.domain.Nota;
import infnet.alexssantos.dr4at.model.domain.Turma;
import infnet.alexssantos.dr4at.repository.NotaRepository;
import infnet.alexssantos.dr4at.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "/nota")
public class NotaController {

    public static final String VIEW_LIST_NOTA = "nota_list";

    @Autowired
    NotaRepository notaRepository;

    @RequestMapping(path = {"","/get"}, method = RequestMethod.GET)
    public String get(Model model)
    {
        List<Nota> list = notaRepository.findAll();
        model.addAttribute("LIST", list);
        return VIEW_LIST_NOTA;
    }
}
