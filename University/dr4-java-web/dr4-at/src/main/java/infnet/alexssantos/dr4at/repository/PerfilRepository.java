package infnet.alexssantos.dr4at.repository;

import infnet.alexssantos.dr4at.model.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
}
