package infnet.alexssantos.dr4at.service;

import infnet.alexssantos.dr4at.model.AlunoCadastroForm;
import infnet.alexssantos.dr4at.model.domain.Aluno;
import infnet.alexssantos.dr4at.model.domain.Curso;
import infnet.alexssantos.dr4at.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    CursoRepository dao;

    public void save(Curso obj)
    {
        if (obj != null){
            dao.save(obj);
        }
    }

    public void saveMany(List<Curso> obj)
    {
        if (obj != null){
            dao.saveAll(obj);
        }
    }

    public List<Curso> findAll()
    {
        return dao.findAll();
    }

    public Curso findById(Integer id)
    {
        Optional<Curso> optObj = dao.findById(id);
        return optObj.orElse(null);
    }

    public Curso update(Curso obj, Integer id)
    {
        Curso toUpdate = findById(id);
        if (toUpdate == null) return null;

        toUpdate.setNome(obj.getNome());
        save(toUpdate);

        return toUpdate;
    }

    public void delete(Integer id)
    {
        Curso obj = findById(id);
        if (obj != null) dao.delete(obj);
    }
}
