package infnet.alexssantos.dr4at.service;

import infnet.alexssantos.dr4at.model.domain.Nota;
import infnet.alexssantos.dr4at.model.domain.Turma;
import infnet.alexssantos.dr4at.repository.NotaRepository;
import infnet.alexssantos.dr4at.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    NotaRepository dao;

    public NotaRepository getDao()
    {
        return dao;
    }

    public Nota save(Nota obj)
    {
        if (obj == null) return null;
        return dao.save(obj);
    }

    public List<Nota> findAll()
    {
        return dao.findAll();
    }

    public Nota findById(Integer id)
    {
        Optional<Nota> optObj = dao.findById(id);
        return optObj.orElse(null);
    }

    public Nota update(Nota rawObj, Integer id)
    {
        Nota toUpdate = findById(id);
        if (toUpdate == null) return null;

        toUpdate.setAv1(rawObj.getAv1());
        toUpdate.setAv2(rawObj.getAv2());
        toUpdate.setAluno(rawObj.getAluno());
        toUpdate.setTurma(rawObj.getTurma());

        return save(toUpdate);
    }

    public boolean delete(Integer id)
    {
        Nota toDelete = findById(id);
        if (toDelete == null) return false;

        dao.delete(toDelete);
        return true;
    }
}
