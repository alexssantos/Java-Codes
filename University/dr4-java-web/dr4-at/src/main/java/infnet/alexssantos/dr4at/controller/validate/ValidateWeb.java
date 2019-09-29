package infnet.alexssantos.dr4at.controller.validate;

import infnet.alexssantos.dr4at.model.AlunoCadastroForm;
import infnet.alexssantos.dr4at.model.LoginForm;

public class ValidateWeb {

    public static boolean isLoginForm(LoginForm form)
    {
        if ((form == null) || (form.getNome().isEmpty()) || (form.getSenha().isEmpty())) {
            return false;
        }

        return true;
    }

    public static boolean isCadastroForm(AlunoCadastroForm form)
    {
        if ((form == null) || (form.getNome().isEmpty()) || (form.getSenha().isEmpty()) || form.getEmail().isEmpty()) {
            return false;
        }

        return true;
    }
}
