package infnet.alexssantos.dr4at.service;

import infnet.alexssantos.dr4at.model.domain.Disciplina;
import infnet.alexssantos.dr4at.model.domain.Turma;
import infnet.alexssantos.dr4at.repository.DisciplinaRepository;
import infnet.alexssantos.dr4at.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository dao;

    public TurmaRepository getDao()
    {
        return dao;
    }

    public Turma save(Turma obj)
    {
        if (obj != null){
            return dao.save(obj);
        }
        return null;
    }

    public List<Turma> findAll()
    {
        return dao.findAll();
    }

    public Turma findById(Integer id)
    {
        Optional<Turma> optObj = dao.findById(id);
        return optObj.orElse(null);
    }

    public Turma update(Turma rawObj, Integer id)
    {
        Turma toUpdate = findById(id);
        if (toUpdate == null) return null;

        toUpdate.setCodigo(rawObj.getCodigo());
        toUpdate.setDisciplina(rawObj.getDisciplina());
        toUpdate.setSala(rawObj.getSala());
        toUpdate.setProfessor(rawObj.getProfessor());

        return save(toUpdate);
    }

    public boolean delete(Integer id)
    {
        Turma toDelete = findById(id);
        if (toDelete == null) return false;

        dao.delete(toDelete);
        return true;
    }
}
