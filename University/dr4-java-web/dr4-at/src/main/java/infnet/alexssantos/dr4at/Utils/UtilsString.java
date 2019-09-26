package infnet.alexssantos.dr4at.Utils;

import java.text.MessageFormat;

public class UtilsString {

    public static boolean isEmptyOrBlanck(String value)
    {
        if (value.isBlank() || value.isEmpty())
        {
            return true;
        }
        return false;
    }

    public static String msgFormat(String s, Object... args) {
        return new MessageFormat(s).format(args);
    }
}
