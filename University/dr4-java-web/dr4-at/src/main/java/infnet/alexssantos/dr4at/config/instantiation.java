package infnet.alexssantos.dr4at.config;

import infnet.alexssantos.dr4at.Utils.UtilsString;
import infnet.alexssantos.dr4at.model.domain.*;
import infnet.alexssantos.dr4at.model.enums.TipoPerfilEnum;
import infnet.alexssantos.dr4at.model.enums.TitulacaoEnum;
import infnet.alexssantos.dr4at.repository.PerfilRepository;
import infnet.alexssantos.dr4at.service.*;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Configuration
public class instantiation implements CommandLineRunner {

    @Autowired
    private PerfilService perfilService;
    @Autowired
    private CursoService cursoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ProfessorService professorService;
    @Autowired
    private DisciplinaService disciplinaService;
    @Autowired
    private TurmaService turmaService;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private NotaService notaService;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    @Override
    public void run(String... args) throws Exception
    {
        initConfigs();
        cleanDatabase();
        createEntitiesOnDb();
    }

    private void initConfigs()
    {
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    private void createEntitiesOnDb()
    {
        createPerfis();
        createCursos();
        createProfessores();
        createDisciplinas();
        createTurmas();
        createAlunos();
        createNotas();
    }

    public void cleanDatabase()
    {
        //DELETE By FK priority

        //TODO: Nota

        //TODO: Aluno
        alunoService.getDao().deleteAll();
        //Turma
        turmaService.getDao().deleteAll();
        //Disciplina
        disciplinaService.getDao().deleteAll();
        //Curso
        cursoService.getDao().deleteAll();
        //Professor
        professorService.getDao().deleteAll();
        //Usuario
        usuarioService.getDao().deleteAll();
        //Perfil
        perfilService.getDao().deleteAll();
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
        List<Curso> cursosOnDb = cursoService.findAll();
        if (cursosOnDb.size() != 0) return;

        Curso Engenharia = new Curso("ENGENHARIA");
        Curso Computacap = new Curso("COMPUTACAO");
        Curso Fisica = new Curso("FISICA");

        trySave(cursoService.getDao(), Arrays.asList(Engenharia, Computacap, Fisica));
    }

    private void createProfessores()
    {
        List<Professor> objsOnDb = professorService.findAll();
        if (objsOnDb.size() != 0) return;

        Perfil perfilProf = Perfil.allPerfils
                .stream()
                .filter(x -> x.getNome() == TipoPerfilEnum.PROFESSOR)
                .findFirst()
                .get();

        List<Usuario> usuariosToSave = new ArrayList<>();
        List<Professor> profsToSave = new ArrayList<>();

        List<TitulacaoEnum> titulacaoList = Arrays.asList(TitulacaoEnum.values());
        int IX_CREATE = 10;
        for (int i=1; i<=IX_CREATE; i++)
        {
            Usuario usuario = new Usuario(
                    alunoService.generateMatricula(),
                    "123",
                    "Prof "+i,
                    "prof"+i+"@prof",
                    perfilProf);
            usuariosToSave.add(usuario);

            Professor professor = new Professor(
                    getAleatoryFromList(titulacaoList),
                    usuario
            );
            profsToSave.add(professor);
        }

        trySave(usuarioService.getDao(), usuariosToSave);
        trySave(professorService.getDao(), profsToSave);
    }

    private void createDisciplinas()
    {
        List<Disciplina> objsOnDb = disciplinaService.findAll();
        if (objsOnDb.size() != 0) return;

        //Create Cursos.
        createCursos();
        List<Curso> cursoList = cursoService.findAll();

        List<Disciplina> itensToSave = new ArrayList<>();
        int IX_CREATE = 10;
        for (int i=1; i<=IX_CREATE; i++)
        {
            Disciplina newObj = new Disciplina(
                    "COD-DISCIP"+i,
                    "NOME-DISCIP-"+i,
                    getAleatoryFromList(cursoList)
            );
            itensToSave.add(newObj);
        }

        trySave(disciplinaService.getDao(), itensToSave);
    }

    public void createTurmas()
    {
        List<Turma> objsOnDb = turmaService.findAll();
        if (objsOnDb.size() != 0) return;

        createProfessores();
        List<Professor> profList = professorService.findAll();
        createDisciplinas();
        List<Disciplina> discList = disciplinaService.findAll();

        List<Turma> listToSave = new ArrayList<>();

        int IX_CREATE = 10;
        for (int i=1; i<=IX_CREATE; i++)
        {
            Turma turma = new Turma(
                    "COD-TURMA-"+i,
                    "SALA-"+i,
                    getAleatoryFromList(profList),
                    getAleatoryFromList(discList)
            );
            listToSave.add(turma);
        }
        trySave(turmaService.getDao(), listToSave);
    }

    public void createAlunos()
    {
        List<Aluno> objsOnDb = alunoService.findAll();
        if (objsOnDb.size() != 0) return;

        Perfil perfilAluno = Perfil.allPerfils
                .stream()
                .filter(x -> x.getNome() == TipoPerfilEnum.ALUNO)
                .findFirst()
                .get();

        createCursos();
        List<Curso> cursoList = cursoService.findAll();
        List<Usuario> usuariosToSave = new ArrayList<>();
        List<Aluno> alunosToSave = new ArrayList<>();

        List<TitulacaoEnum> titulacaoList = Arrays.asList(TitulacaoEnum.values());
        int IX_CREATE = 30;
        for (int i=1; i<=IX_CREATE; i++)
        {
            Usuario usuario = new Usuario(
                    alunoService.generateMatricula(),
                    "123",
                    "Aluno "+i,
                    "aluno"+i+"@aluno",
                    perfilAluno);
            usuariosToSave.add(usuario);

            String dateNasc = sdf.format(UtilsString.getAleatoryDateString());
            Aluno aluno = new Aluno(
                    dateNasc,
                    usuario,
                    getAleatoryFromList(cursoList));
            alunosToSave.add(aluno);
        }

        trySave(usuarioService.getDao(), usuariosToSave);
        trySave(alunoService.getDao(), alunosToSave);
    }

    public void createNotas()
    {
        List<Nota> objsOnDb = notaService.findAll();
        if (objsOnDb.size() != 0) return;

        createTurmas();
        List<Turma> turmaList = turmaService.findAll();
        createAlunos();
        List<Aluno> alunoList = alunoService.findAll();
    }

    // ================
    // => AUX
    // ================
    public static <T> T getAleatoryFromList(List<T> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
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
