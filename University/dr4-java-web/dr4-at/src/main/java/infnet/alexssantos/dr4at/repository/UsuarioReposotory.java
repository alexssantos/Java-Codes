package infnet.alexssantos.dr4at.repository;

import infnet.alexssantos.dr4at.model.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioReposotory extends JpaRepository<Usuario, Integer> {


    public Usuario getByEmail(String email);


    public Usuario getByEmailAndSenha(String email, String senha);
}
