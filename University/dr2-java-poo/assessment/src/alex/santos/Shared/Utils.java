package alex.santos.Shared;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils<T> {

    public static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyy HH:mm");

    public static void msg(String msg){
        System.out.println("\n"+msg+"\n");
    }

    public static void msgERRO(String msg){
        System.out.println("\nERRO:\n\t"+msg+"\n");
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

    public static <T extends Comparable<T>> boolean checkRepeated(List<T> list, T item)
    {
        for (T i: list) {
            if (i.compareTo(item)==0)
            {
                String msg = "Item REPETIDO: "+i;
                msgERRO(msg);
                return false;
            }
        }

        list.add(item);
        return true;
    }

    public static <T extends Comparable<T>> List<T> checkRepeaters(List<? super T> target, List<T> source)
    {
        List<T> list = new ArrayList<>();
        for (T item: source) {
            if (target.contains(item))
            {
                String msg = "Item REPETIDO: "+item;
                msgERRO(msg);
            }
            else {
                list.add(item);
            }
        }
        return list;
    }

    public static String printDate(Date date){
        String dateOut = SDF.format(date);
        return dateOut;
    }

    public static Date createDate(String day, String time) throws ParseException {
        Date dateOut = SDF.parse(day+" "+ time);
        return dateOut;
    }


}
