package alex.santos.Shared;

import alex.santos.Entities.Airport;
import alex.santos.Entities.City;
import alex.santos.Entities.Flight;
import alex.santos.Entities.Interfaces.IAircraft;
import alex.santos.Entities.Machines.Airplane;
import alex.santos.Entities.Machines.HelicopterAirTaxi;
import alex.santos.Entities.Machines.HelicopterCostGuard;
import alex.santos.Entities.Machines.HelicopterRescue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Mock {

    public static List<Airport> aeroportosList = new ArrayList<>();
    public static List<Flight> voosList = new ArrayList<>();
    public static List<City> cidadesList = new ArrayList<>();

    public static List<Airplane> avioesList = new ArrayList<>();
    public static List<HelicopterAirTaxi> heliAirTaxiListList = new ArrayList<>();
    public static List<HelicopterCostGuard> heliCostGuardList = new ArrayList<>();
    public static List<HelicopterRescue> heliRescueList= new ArrayList<>();

    public Mock() {
        generateCities();
        generateAirports();
        generateAircrafts();
        generateFlights();
    }


    //1
    public void generateCities(){
        cidadesList.addAll(Arrays.asList(
            new City("Rio de Janeiro",1500000),
            new City("Curitiba", 750000),
            new City("São Paula", 800000)
        ));
    }

    //2
    public void generateAirports(){
        aeroportosList.addAll(Arrays.asList(
           new Airport("GIG", "Aeroporto Internacional Tom Jobin", "Rio de Janeiro"),
           new Airport("CWB", "Aeroporto Internacional Afonso Pena", "Curitiba"),
           new Airport("GRU", "Aeroporto Internacional Governador André Franco Montoro", "São Paulo")
        ));

    }

    //3
    public void generateAircrafts(){
        avioesList.addAll(Arrays.asList(
                new Airplane("AAA-BR","A1","Embraer"),
                new Airplane("AAA-BR","A2","Embraer"),
                new Airplane("AAA-BR","A3","Embraer")
        ));

        heliAirTaxiListList.addAll(Arrays.asList(
                new HelicopterAirTaxi("HAA-BR","A1","AirBus"),
                new HelicopterAirTaxi("HAA-BR","A2","AirBus"),
                new HelicopterAirTaxi("HAA-BR","A3","AirBus")
        ));

        heliCostGuardList.addAll(Arrays.asList(
                new HelicopterCostGuard("HBB-BR","B1","Boeing"),
                new HelicopterCostGuard("HBB-BR","B2","Boeing"),
                new HelicopterCostGuard("HBB-BR","B3","Boeing")
        ));

        heliRescueList.addAll(Arrays.asList(
                new HelicopterRescue("HCC-BR","C1","Dassault"),
                new HelicopterRescue("HCC-BR","C2","Dassault"),
                new HelicopterRescue("HCC-BR","C3","Dassault")
        ));
    }

    //4
    public void generateFlights(){
        Airplane aviao = avioesList.get(getRandomInt(0,avioesList));
        int aviaoCode = aviao.getAirplaneCode();
        String today = "01/01/19";

        String code1 = aeroportosList.get(0).getAirportCode();  // GIG
        String code2 = aeroportosList.get(1).getAirportCode();  // CWB
        String code3 = aeroportosList.get(2).getAirportCode();  // GRU

        //voo - aviao1
        voosList.addAll(Arrays.asList(
           new Flight(today,"04:00",today,"04:00",code1,code2, aviao),
           new Flight(today,"07:00",today,"08:00",code2,code1, aviao),

           new Flight(today,"14:00",today,"16:00",code1,code3, aviao),
           new Flight(today,"14:00",today,"16:00",code3,code1, aviao),

           new Flight(today,"14:00",today,"16:00",code2,code3, aviao),
           new Flight(today,"14:00",today,"16:00",code3,code2, aviao)
        ));

        aviao = avioesList.get(getRandomInt(0,avioesList));
        while (aviaoCode == aviao.getAirplaneCode()){
            aviao = avioesList.get(getRandomInt(0,avioesList));
        }

        voosList.addAll(Arrays.asList(
                new Flight(today,"04:00",today,"04:00",code2,code3, aviao),
                new Flight(today,"07:00",today,"08:00",code3,code2, aviao),

                new Flight(today,"14:00",today,"16:00",code2,code1, aviao),
                new Flight(today,"14:00",today,"16:00",code1,code2, aviao),

                new Flight(today,"14:00",today,"16:00",code3,code1, aviao),
                new Flight(today,"14:00",today,"16:00",code1,code3, aviao)
        ));

    }

    private int getRandomInt(int min, List<?> list){
        //Random rd = new Random();
        int max = list.size()-1;
        int numb = (int) (Math.random() * (max - min));
        return numb;
    }


}
