package infnet.alexssantos.dr4at.service;

import infnet.alexssantos.dr4at.model.domain.Disciplina;
import infnet.alexssantos.dr4at.model.domain.Professor;
import infnet.alexssantos.dr4at.repository.DisciplinaRepository;
import infnet.alexssantos.dr4at.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository dao;

    public DisciplinaRepository getDao()
    {
        return dao;
    }

    public Disciplina save(Disciplina obj)
    {
        if (obj != null){
            return dao.save(obj);
        }
        return null;
    }

    public List<Disciplina> findAll()
    {
        return dao.findAll();
    }

    public Disciplina findById(Integer id)
    {
        Optional<Disciplina> optObj = dao.findById(id);
        return optObj.orElse(null);
    }

    public Disciplina update(Disciplina rawObj, Integer id)
    {
        Disciplina toUpdate = findById(id);
        if (toUpdate == null) return null;

        toUpdate.setCodigo(rawObj.getCodigo());
        toUpdate.setCurso(rawObj.getCurso());
        toUpdate.setNome(rawObj.getNome());

        return save(toUpdate);
    }

    public boolean delete(Integer id)
    {
        Disciplina toDelete = findById(id);
        if (toDelete == null) return false;

        dao.delete(toDelete);
        return true;
    }
}
