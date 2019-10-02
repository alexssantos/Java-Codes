package infnet.alexssantos.dr4at.controller.validate;

import infnet.alexssantos.dr4at.model.AlunoCadastroForm;
import infnet.alexssantos.dr4at.model.LoginForm;

public class ValidateWeb {

    public static boolean loginForm(LoginForm form)
    {
        if ((form == null) || (form.getEmail().isEmpty()) || (form.getSenha().isEmpty())) {
            return false;
        }

        return true;
    }

    public static boolean cadastroForm(AlunoCadastroForm form)
    {
        if ((form != null)
            && (!form.getNome().isEmpty())
            && (!form.getSenha().isEmpty())
            && (!form.getEmail().isEmpty()))
        {
            return true;
        }

        return false;
    }
}
