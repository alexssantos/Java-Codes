package infnet.alexssantos.dr4at.repository;

import infnet.alexssantos.dr4at.model.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
