package infnet.alexssantos.dr4at.repository;

import infnet.alexssantos.dr4at.model.domain.Aluno;
import infnet.alexssantos.dr4at.model.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepo extends JpaRepository<Aluno, Integer> {

    //public Aluno getAlunoByUsuario(Usuario usuario);
}
