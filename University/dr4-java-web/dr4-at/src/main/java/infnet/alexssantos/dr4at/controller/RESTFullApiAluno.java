package infnet.alexssantos.dr4at.controller;

import infnet.alexssantos.dr4at.model.AlunoCadastroForm;
import infnet.alexssantos.dr4at.model.domain.Aluno;
import infnet.alexssantos.dr4at.model.domain.Curso;
import infnet.alexssantos.dr4at.model.domain.Usuario;
import infnet.alexssantos.dr4at.service.AlunoService;
import infnet.alexssantos.dr4at.service.CursoService;
import infnet.alexssantos.dr4at.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/aluno")
public class RESTFullApiAluno {

    @Autowired
    AlunoService alunoService;
    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Aluno>> get(Model model)
    {
        List<Aluno> list = alunoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Usuario> create(@RequestBody AlunoCadastroForm form)
    {
        Usuario usuario = usuarioService.saveByForm(form);
        return ResponseEntity.ok().body(usuario);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Aluno> update(@RequestBody AlunoCadastroForm form, @RequestParam Integer id)
    {
        Aluno aluno = alunoService.update(form, id);
        return ResponseEntity.ok().body(aluno);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<List<Aluno>> delete(@RequestParam Integer id)
    {
        alunoService.delete(id);
        return ResponseEntity.ok().build();
    }


}
