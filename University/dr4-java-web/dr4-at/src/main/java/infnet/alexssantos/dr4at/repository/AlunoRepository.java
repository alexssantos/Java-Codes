package infnet.alexssantos.dr4at.repository;

import infnet.alexssantos.dr4at.model.domain.Aluno;
import infnet.alexssantos.dr4at.model.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
