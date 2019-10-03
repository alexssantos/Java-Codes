package infnet.alexssantos.dr4at.Utils;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

    //https://stackoverflow.com/a/3985467
    public static Date getAleatoryDateString()
    {
        // Get a new random instance, seeded from the clock
        Random rnd = new Random();

        // Get an Epoch value roughly between 1940 and 2010        // -946771200000L = January 1, 1940        // Add up to 70 years to it (using modulus on the next long)
        Long ms = -946771200000L + (Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
        return new Date(ms);
    }
}
