package infnet.alexssantos.dr4at.service;

import infnet.alexssantos.dr4at.model.AlunoCadastroForm;
import infnet.alexssantos.dr4at.model.domain.Perfil;
import infnet.alexssantos.dr4at.model.domain.Usuario;
import infnet.alexssantos.dr4at.model.enums.TipoPerfilEnum;
import infnet.alexssantos.dr4at.repository.UsuarioReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioReposotory dao;

    @Autowired
    AlunoService alunoService;


    public UsuarioReposotory getDao()
    {
        return dao;
    }

    public List<Usuario> getAll()
    {
        return  dao.findAll();
    }

    public Usuario getByEmail(String email)
    {
        Usuario usuario = dao.getByEmail(email);
        return usuario;
    }

    public Usuario save(Usuario usuario)
    {
        return dao.save(usuario);
    }

    public Usuario saveByForm(AlunoCadastroForm form)
    {
        Usuario obj = getByEmail(form.getEmail());
        if (obj != null)
        {
            return null;
        }

        Perfil perfilAluno = Perfil.allPerfils
                .stream()
                .filter(x -> x.getNome() == TipoPerfilEnum.ALUNO)
                .findFirst()
                .get();

        Usuario usuario = new Usuario(
                alunoService.generateMatricula(),
                form.getSenha(),
                form.getNome(),
                form.getEmail(),
                perfilAluno);

        return save(usuario);
    }

}
