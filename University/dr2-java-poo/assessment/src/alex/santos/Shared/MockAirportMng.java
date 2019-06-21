package alex.santos.Shared;

import alex.santos.Entities.Airport;
import alex.santos.Entities.City;
import alex.santos.Entities.Flight;
import alex.santos.Entities.Machines.Airplane;
import alex.santos.Entities.Machines.HelicopterAirTaxi;
import alex.santos.Entities.Machines.HelicopterCostGuard;
import alex.santos.Entities.Machines.HelicopterRescue;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockAirportMng {


    //Listas
    public static List<Airport> aeroportosList = new ArrayList<>();
    public static List<Flight> voosList = new ArrayList<>();
    public static List<City> cidadesList = new ArrayList<>();
    public static List<Airplane> avioesList = new ArrayList<>();
    public static List<HelicopterAirTaxi> heliAirTaxiListList = new ArrayList<>();
    public static List<HelicopterCostGuard> heliCostGuardList = new ArrayList<>();
    public static List<HelicopterRescue> heliRescueList= new ArrayList<>();

    public MockAirportMng() {
        generateCities();
        generateAirports();
        generateAircrafts();
        generateFlights();
    }


    //1
    public void generateCities(){
        Utils.msg("\nCriando Cidades!");

        List<City> newCidades = new ArrayList<>();
        newCidades.addAll(Arrays.asList(
            new City("Rio de Janeiro",1500000),
            new City("Curitiba", 750000),
            new City("São Paula", 800000)
        ));
        newCidades = Utils.checkRepeaters(cidadesList, newCidades);
        cidadesList.addAll(newCidades);

        int ix = Utils.prtList(cidadesList);
        Utils.msg("Cidades criadas: "+ix);
    }

    //2
    public void generateAirports(){
        Utils.msg("\nCriando Aeroportos!");

        List<Airport> aeroportos = new ArrayList<>();
        aeroportos.addAll(Arrays.asList(
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

    //3
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

    //4
    public void generateFlights(){
        Airplane aviao = avioesList.get(getRandomInt(0,avioesList));
        int aviaoCode = aviao.getAirplaneCode();
        String today = "01/01/19";

        String code1 = aeroportosList.get(0).getAirportCode();  // GIG
        String code2 = aeroportosList.get(1).getAirportCode();  // CWB
        String code3 = aeroportosList.get(2).getAirportCode();  // GRU

        Utils.msg("\nCriando Vôos!");
        //voo - aviao1
        List<Flight> voos = new ArrayList<>();
        voos.addAll(Arrays.asList(
           new Flight(today,"04:00",today,"04:00",code1,code2, aviao,"Azul"),
           new Flight(today,"07:00",today,"08:00",code2,code1, aviao,"Azul"),

           new Flight(today,"14:00",today,"16:00",code1,code3, aviao,"Azul"),
           new Flight(today,"14:00",today,"16:00",code3,code1, aviao,"Azul"),

           new Flight(today,"14:00",today,"16:00",code2,code3, aviao,"Azul"),
           new Flight(today,"14:00",today,"16:00",code3,code2, aviao,"Azul")
        ));
        voos = Utils.checkRepeaters(voosList, voos);
        voosList.addAll(voos);

        aviao = avioesList.get(getRandomInt(0,avioesList));
        while (aviaoCode == aviao.getAirplaneCode()){
            aviao = avioesList.get(getRandomInt(0,avioesList));
        }

        voos.addAll(Arrays.asList(
                new Flight(today,"04:00",today,"04:00",code2,code3, aviao,"LATAM"),
                new Flight(today,"07:00",today,"08:00",code3,code2, aviao,"LATAM"),

                new Flight(today,"14:00",today,"16:00",code2,code1, aviao,"LATAM"),
                new Flight(today,"14:00",today,"16:00",code1,code2, aviao,"LATAM"),

                new Flight(today,"14:00",today,"16:00",code3,code1, aviao,"LATAM"),
                new Flight(today,"14:00",today,"16:00",code1,code3, aviao,"LATAM")
        ));
        voos = Utils.checkRepeaters(voosList, voos);
        voosList.addAll(voos);


        // TESTE - voo REPEDITO   ------------------

        Flight test = new Flight(today,"04:00",today,"04:00",code2,code3, aviao,"LATAM");
        String Id = Integer.toString(test.getFlightNumber());
        Utils.checkRepeated(voosList,test);

        test = new Flight(today,"04:00",today,"04:00",code2,code3, aviao,"GOL");
        Id = Integer.toString(test.getFlightNumber());
        Utils.checkRepeated(voosList,test);

        test = new Flight(today,"11:11",today,"22:22",code2,code3, aviao,"AIRFRANCE");
        Id = Integer.toString(test.getFlightNumber());
        Utils.checkRepeated(voosList,test);
        //test

        int ix = Utils.prtList(voosList);
        Utils.msg("Vôos criados: "+ix);
    }

    private int getRandomInt(int min, List<?> list){
        int max = list.size()-1;
        int numb = (int) (Math.random() * (max - min));
        return numb;
    }


    private <T extends Comparable<T>> void testAddRepeated(List<T> list){
        if (list.isEmpty()){
            return;
        }

        T clone = list.get(getRandomInt(0,list));
        Utils.checkRepeated(list, clone);
    }

}
