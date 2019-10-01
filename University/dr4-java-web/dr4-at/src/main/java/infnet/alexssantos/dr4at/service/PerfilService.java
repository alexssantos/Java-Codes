package infnet.alexssantos.dr4at.service;

import infnet.alexssantos.dr4at.model.domain.Perfil;
import infnet.alexssantos.dr4at.model.enums.TipoPerfilEnum;
import infnet.alexssantos.dr4at.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PerfilService {

    @Autowired
    PerfilRepository dao;

    public PerfilRepository getDao()
    {
        return dao;
    }

    public PerfilService() {
    }

    public void save(Perfil obj){
        dao.save(obj);
    }

    public void saveMany(List<Perfil> list)
    {
        dao.saveAll(list);
    }

    public List<Perfil>  findAll(){
        return dao.findAll();
    }

    public Perfil getByTipoPerfil(TipoPerfilEnum tipo)
    {
        Perfil perfil = Perfil.allPerfils.stream()
                .filter(x -> x.getNome() == tipo)
                .findFirst()
                .get();

        if (perfil != null)
        {
            return perfil;
        }

        perfil = new Perfil(tipo);
        dao.save(perfil);

        return perfil;
    }


    // =======================
    // STATICS
    // =======================

    public static Map<String, TipoPerfilEnum> perfilTipoEnumMap = Stream.of(new Object[][]
            {
                    {"ALUNO", TipoPerfilEnum.ALUNO},
                    {"PROFESSOR",TipoPerfilEnum.PROFESSOR},
                    {"DESCONHECIDO",TipoPerfilEnum.DESCONHECIDO },
            })
            .collect(Collectors.toMap(
                    key -> (String) key[0],
                    value -> (TipoPerfilEnum) value[1]
                    )
            );
}
