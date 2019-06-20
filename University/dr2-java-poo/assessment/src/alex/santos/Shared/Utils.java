package alex.santos.Shared;

import java.util.List;

public class Utils {

    public static void msg(String msg){
        System.out.println(msg);
    }

    public static <T> int prtList(List<T> list){

        if (list.isEmpty()){
            return 0;
        }

        int ix = 0;
        for (T item: list) {
            ix++;
            System.out.println(ix+" - "+ item.toString());
        }
        return ix;
    }
}
