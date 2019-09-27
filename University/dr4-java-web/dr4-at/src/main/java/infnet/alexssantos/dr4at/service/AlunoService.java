//package infnet.alexssantos.dr4at.service;
//
//import infnet.alexssantos.dr4at.Utils.UtilsString;
//import infnet.alexssantos.dr4at.model.AlunoCadastroForm;
//import infnet.alexssantos.dr4at.model.domain.Aluno;
//import infnet.alexssantos.dr4at.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AlunoService {
//
//    //@Autowired
//    AlunoRepository dao;
//
////    @Autowired
////    UsuarioReposotory usuarioRepo;
//
//    public void save(Aluno obj)
//    {
//        if (obj != null){
//            dao.save(obj);
//        }
//    }
//
//    public List<Aluno> findAll()
//    {
//        return dao.findAll();
//    }
//
//    public Aluno findById(Integer id)
//    {
//        Optional<Aluno> optObj = dao.findById(id);
//        return optObj.orElse(new Aluno());
//    }
//
//    public Aluno update(AlunoCadastroForm form, Integer id)
//    {
//        // TODO: VALIDATE FORM.
//        Aluno toUpdate = findById(id);
//        Aluno nowObj = updateByForm(form, toUpdate);
//        save(nowObj);
//
//        return nowObj;
//    }
//
//    public void delete(Integer id)
//    {
//        Aluno toDelete = findById(id);
//        dao.delete(toDelete);
//    }
//
////    public Aluno save(AlunoCadastroForm form)
////    {
////        if (form == null){
////            return null;
////        }
////
////        Aluno obj = getByForm(form);
////        save(obj);
////        return obj;
////    }
////
////    public Aluno getByForm(AlunoCadastroForm email)
////    {
////
////        dao.getAlunoByUsuario();
////        Aluno obj = new Aluno(
////                form.getNome(),
////                form.getCrm(),
////                usuario);
////
////        return obj;
////    }
//
//    public Aluno updateByForm(AlunoCadastroForm form, Aluno toUpdate)
//    {
//        if (!UtilsString.isEmptyOrBlanck(form.getNome())){
//            toUpdate.getUsuario().setNome(form.getNome());
//        }
//
//        if (!UtilsString.isEmptyOrBlanck(form.getEmail())){
//            toUpdate.getUsuario().setEmail(form.getEmail());
//        }
//
//        if (!UtilsString.isEmptyOrBlanck(form.getSenha())){
//            toUpdate.getUsuario().setSenha(form.getSenha());
//        }
//
//        return toUpdate;
//    }
//
//
//}
