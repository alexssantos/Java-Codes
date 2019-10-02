package infnet.alexssantos.dr4at.config;

import infnet.alexssantos.dr4at.model.domain.Curso;
import infnet.alexssantos.dr4at.model.domain.Perfil;
import infnet.alexssantos.dr4at.model.enums.TipoPerfilEnum;
import infnet.alexssantos.dr4at.repository.PerfilRepository;
import infnet.alexssantos.dr4at.service.CursoService;
import infnet.alexssantos.dr4at.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Configuration
public class instantiation implements CommandLineRunner {

    @Autowired
    private PerfilService perfilService;
    @Autowired
    private CursoService cursoService;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    @Override
    public void run(String... args) throws Exception
    {
        initConfigs();
        createPerfis();
        createCursos();
    }

    private void initConfigs()
    {
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

    }

    private void createPerfis()
    {
        List<TipoPerfilEnum> enumTipoPerfilList = Arrays.asList(TipoPerfilEnum.values());

        List<Perfil> perfilOnDbList = perfilService.findAll();

        List<TipoPerfilEnum> enumOnDbList = perfilOnDbList
                .stream()
                .map(x -> x.getNome())
                .distinct()
                .collect(Collectors.toList());

        List<Perfil> toSave = null;
        if (!(enumOnDbList.size() == enumTipoPerfilList.size()))
        {
            toSave = enumTipoPerfilList.stream()
                    .filter(x -> !enumOnDbList.contains(x))
                    .map(x -> new Perfil(x))
                    .collect(Collectors.toList());
        }

        PerfilRepository dao = perfilService.getDao();

        boolean haveToSave = (toSave != null) && (toSave.size() > 0);
        if (haveToSave)
        {
            trySave(dao, toSave);
        }

        List<Perfil> perfils = (haveToSave) ? dao.findAll() : perfilOnDbList;
        Perfil.allPerfils.addAll(perfils);
    }

    private void createCursos()
    {
        Curso Engenharia = new Curso("ENGENHARIA");
        Curso Computacap = new Curso("COMPUTACAO");
        Curso Fisica = new Curso("FISICA");

        cursoService.saveMany(Arrays.asList(Engenharia, Computacap, Fisica));
    }



    // ================
    // => GENERICS
    // ================
    public static <E, D extends JpaRepository> boolean trySave(D dao, E entity)
    {
        List<E> list = new ArrayList<>();
        list.add(entity);

        return trySave(dao, list);
    }

    public static <E, D extends JpaRepository<E, Integer>> boolean trySave(D dao, List<E> entityList)
    {
        boolean isOk = true;
        try {
            dao.saveAll(entityList);
            dao.flush();
        }
        catch (Exception e)
        {
            isOk = false;
            e.printStackTrace();
        }

        return isOk;
    }

    public static <E> void printAll(List<?> entityList)
    {
        if (entityList.size() < 1) return;

        for (Object item : entityList)
        {
            System.out.println("-----------------------------------");
            System.out.println(item);
            System.out.println("-----------------------------------");
        }
    }
}
