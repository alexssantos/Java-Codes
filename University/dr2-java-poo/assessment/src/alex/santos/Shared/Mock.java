package alex.santos.Shared;

import alex.santos.Entities.Airport;
import alex.santos.Entities.City;
import alex.santos.Entities.Flight;
import alex.santos.Entities.Machines.Airplane;
import alex.santos.Entities.Machines.HelicopterAirTaxi;
import alex.santos.Entities.Machines.HelicopterCostGuard;
import alex.santos.Entities.Machines.HelicopterRescue;
import jdk.jshell.execution.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Mock {


    //Listas
    public static List<Airport> aeroportosList = new ArrayList<>();
    public static List<Flight> voosList = new ArrayList<>();
    public static List<City> cidadesList = new ArrayList<>();
    public static List<Airplane> avioesList = new ArrayList<>();
    public static List<HelicopterAirTaxi> heliAirTaxiListList = new ArrayList<>();
    public static List<HelicopterCostGuard> heliCostGuardList = new ArrayList<>();
    public static List<HelicopterRescue> heliRescueList= new ArrayList<>();

    public Mock(){
        generateCities();
        generateAirports();
        generateAircrafts();

        try {
            generateFlights();  // possiveis erros de Datas.
        }
        catch (ParseException e){
            e.printStackTrace();
        }
    }

    // GENERATE     -----------------------------------

    //1 cidades
    public void generateCities(){
        Utils.msg("\nCriando Cidades!");

        List<City> newCidades = new ArrayList<>();
        newCidades.addAll(Arrays.asList(
            new City("Rio de Janeiro",1500000),
            new City("Curitiba", 750000),
            new City("São Paulo", 800000)
        ));
        newCidades = Utils.checkRepeaters(cidadesList, newCidades);
        cidadesList.addAll(newCidades);

        int ix = Utils.prtList(cidadesList);
        Utils.msg("Cidades criadas: "+ix);
    }

    //2 aeroportos
    public void generateAirports(){
        Utils.msg("\nCriando Aeroportos!");

        List<Airport> aeroportos = new ArrayList<>(Arrays.asList(
                new Airport("GIG", "Aeroporto Internacional Tom Jobin", "Rio de Janeiro"),
                new Airport("CWB", "Aeroporto Internacional Afonso Pena", "Curitiba"),
                new Airport("GRU", "Aeroporto Internacional Governador André Franco Montoro", "São Paulo")
        ));

        //earoportos = Utils.checkRepeateds(cidadesList, earoportos);  TODO: Erro de Type Safity - por isso uso Generics
        aeroportos = Utils.checkRepeaters(aeroportosList, aeroportos);
        aeroportosList.addAll(aeroportos);

        int ix = Utils.prtList(aeroportosList);
        Utils.msg("Aeroportos criados: "+ix);
    }

    //3 aeronaves
    public void generateAircrafts(){
        Utils.msg("\nCriando Aviões!");

        avioesList.addAll(Arrays.asList(
                new Airplane("AAA-BR","A1","Embraer"),
                new Airplane("AAA-BR","A2","Embraer"),
                new Airplane("AAA-BR","A3","Embraer")
        ));

        int ix = Utils.prtList(avioesList);
        Utils.msg("Aviões criados: "+ix);


        Utils.msg("\nCriando Helicopteros!");
        heliAirTaxiListList.addAll(Arrays.asList(
                new HelicopterAirTaxi("HAA-BR","A1","AirBus"),
                new HelicopterAirTaxi("HAA-BR","A2","AirBus"),
                new HelicopterAirTaxi("HAA-BR","A3","AirBus")
        ));
        ix = Utils.prtList(heliAirTaxiListList);

        heliCostGuardList.addAll(Arrays.asList(
                new HelicopterCostGuard("HBB-BR","B1","Boeing"),
                new HelicopterCostGuard("HBB-BR","B2","Boeing"),
                new HelicopterCostGuard("HBB-BR","B3","Boeing")
        ));
        ix += Utils.prtList(heliCostGuardList);

        heliRescueList.addAll(Arrays.asList(
                new HelicopterRescue("HCC-BR","C1","Dassault"),
                new HelicopterRescue("HCC-BR","C2","Dassault"),
                new HelicopterRescue("HCC-BR","C3","Dassault")
        ));
        ix += Utils.prtList(heliRescueList);

        Utils.msg("Helicopteros criados: "+ix);
    }

    //4 voos
    public void generateFlights() throws ParseException {

        String today = Utils.printDate(new Date()).split(" ")[0];   // ex.: "23/06/19"

        Airplane aviao = avioesList.get(getRandomInt(0,avioesList));
        int aviaoCode = aviao.getAirplaneCode();


        String GIG = aeroportosList.get(0).getAirportCode();  // GIG
        String CWB = aeroportosList.get(1).getAirportCode();  // CWB
        String CRU = aeroportosList.get(2).getAirportCode();  // GRU

        Utils.msg("\nCriando Vôos!");

        /* title: HORARIOS DE VOOS
         * "04:00" -> "06:00" IDA
         * "08:00" -> "10:00" VOLTA
         *
         * "12:00" -> "14:00" IDA
         * "15:00" -> "17:00" VOLTA
         *
         * "18:00" -> "20:00" IDA
         * "21:00" -> "23:00" VOLTA
         * */

        //voo - aviao1
        List<Flight> voos = new ArrayList<>();
        voos.addAll(Arrays.asList(
           new Flight(Utils.createDate(today, "04:00"),Utils.createDate(today, "06:00"),GIG,CWB, aviao,"Azul"),
           new Flight(Utils.createDate(today, "08:00"),Utils.createDate(today, "10:00"),CWB,GIG, aviao,"Azul"),

           new Flight(Utils.createDate(today, "12:00"),Utils.createDate(today, "14:00"),GIG,CRU, aviao,"Azul"),
           new Flight(Utils.createDate(today, "15:00"),Utils.createDate(today, "17:00"),CRU,GIG, aviao,"Azul"),

           new Flight(Utils.createDate(today, "18:00"),Utils.createDate(today, "20:00"),CWB,CRU, aviao,"Azul"),
           new Flight(Utils.createDate(today, "21:00"),Utils.createDate(today, "23:00"),CRU,CWB, aviao,"Azul")
        ));
        voos = Utils.checkRepeaters(voosList, voos);
        voosList.addAll(voos);

        int ix = Utils.prtList(voosList);
        Utils.msg("Vôos criados: "+ix);

        Utils.msg("-----------------------   MUDANDO AVIAO DE VOOS   -----------------------");

        aviao = avioesList.get(getRandomInt(0,avioesList));
        while (aviaoCode == aviao.getAirplaneCode()){
            aviao = avioesList.get(getRandomInt(0,avioesList));
        }

        //aviao 2
        List<Flight> voos2 = new ArrayList<>();
        voos2.addAll(Arrays.asList(
                new Flight(Utils.createDate(today, "04:00"),Utils.createDate(today, "06:00"),CWB,CRU, aviao,"LATAM"),
                new Flight(Utils.createDate(today, "08:00"),Utils.createDate(today, "10:00"),CRU,CWB, aviao,"LATAM"),

                new Flight(Utils.createDate(today, "12:00"),Utils.createDate(today, "14:00"),CWB,GIG, aviao,"LATAM"),
                new Flight(Utils.createDate(today, "15:00"),Utils.createDate(today, "17:00"),GIG,CWB, aviao,"LATAM"),

                new Flight(Utils.createDate(today, "18:00"),Utils.createDate(today, "20:00"),CRU,GIG, aviao,"LATAM"),
                new Flight(Utils.createDate(today, "21:00"),Utils.createDate(today, "23:00"),GIG,CRU, aviao,"LATAM")
        ));


        voos2 = Utils.checkRepeaters(voosList, voos2);
        voosList.addAll(voos2);

        ix = Utils.prtList(voosList);
        Utils.msg("Total Vôos criados: "+ix+"   ---------------------");


        Utils.msg("// TESTE: voo REPEDITO   ------------------");
        Flight test = new Flight(Utils.createDate(today, "04:00"),Utils.createDate(today, "06:00"),CWB,CRU, aviao,"LATAM");
        String Id = Integer.toString(test.getFlightNumber());
        Utils.checkRepeated(voosList,test);

        test = new Flight(Utils.createDate(today, "04:00"),Utils.createDate(today, "06:00"),CWB,CRU, aviao,"GOL");
        Id = Integer.toString(test.getFlightNumber());
        Utils.checkRepeated(voosList,test);

        test = new Flight(Utils.createDate(today, "11:11"),Utils.createDate(today, "22:22"),CWB,CRU, aviao,"AIR FRANCE");
        Id = Integer.toString(test.getFlightNumber());
        Utils.checkRepeated(voosList,test);
        //test
    }


    // METHODS      ------------------------------------
    private int getRandomInt(int min, List<?> list){
        int max = list.size()-1;
        int numb = (int) (Math.random() * (max - min));
        return numb;
    }

    private <T extends Comparable<T>> void testAddRepeated(List<T> list){
        if (list.isEmpty()){
            return;
        }

        T clone = list.get(getRandomInt(0,list));   //pega aleatorio
        Utils.checkRepeated(list, clone);
    }
}
