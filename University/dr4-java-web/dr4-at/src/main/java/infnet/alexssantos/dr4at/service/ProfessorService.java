package infnet.alexssantos.dr4at.service;

import infnet.alexssantos.dr4at.model.AlunoCadastroForm;
import infnet.alexssantos.dr4at.model.domain.Aluno;
import infnet.alexssantos.dr4at.model.domain.Professor;
import infnet.alexssantos.dr4at.repository.AlunoRepository;
import infnet.alexssantos.dr4at.repository.ProfessorRepository;
import infnet.alexssantos.dr4at.repository.UsuarioReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository dao;
    @Autowired
    UsuarioReposotory usuarioRepo;

    public ProfessorRepository getDao()
    {
        return dao;
    }

    public Professor save(Professor obj)
    {
        if (obj != null){
            return dao.save(obj);
        }
        return null;
    }

    public List<Professor> findAll()
    {
        return dao.findAll();
    }

    public Professor findById(Integer id)
    {
        Optional<Professor> optObj = dao.findById(id);
        return optObj.orElse(null);
    }

    public Professor update(Professor rawObj, Integer id)
    {
        Professor toUpdate = findById(id);
        if (toUpdate == null) return null;

        toUpdate.setTitulacao(rawObj.getTitulacao());
        toUpdate.setUsuario(rawObj.getUsuario());
        return save(toUpdate);
    }

    public boolean delete(Integer id)
    {
        Professor toDelete = findById(id);
        if (toDelete == null) return false;

        dao.delete(toDelete);
        return true;
    }
}
