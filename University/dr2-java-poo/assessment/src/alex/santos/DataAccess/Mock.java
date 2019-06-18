package alex.santos.DataAccess;

import alex.santos.Entities.Airport;
import alex.santos.Entities.City;
import alex.santos.Entities.Flight;
import alex.santos.Entities.Machines.Airplane;
import alex.santos.Entities.Machines.HelicopterAirTaxi;
import alex.santos.Entities.Machines.HelicopterCostGuard;
import alex.santos.Entities.Machines.HelicopterRescue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mock {

    public static List<Airport> aeroportosList = new ArrayList<>();
    public static List<Flight> flightList = new ArrayList<>();
    public static List<City> cidadesList = new ArrayList<>();

    public static List<Airplane> avioesList = new ArrayList<>();
    public static List<HelicopterAirTaxi> heliAirTaxiListList = new ArrayList<>();
    public static List<HelicopterCostGuard> heliCostGuardList = new ArrayList<>();
    public static List<HelicopterRescue> heliRescueList= new ArrayList<>();

    public Mock() {

    }


    //1
    public void generateCities(){
        cidadesList.addAll(Arrays.asList(
            new City("Rio de Janeiro",1500000),
            new City("Cirutiba", 750000),
            new City("Pairaiba", 800000)
        ));
    }

    //2
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

    //3
    public void generateAirports(){
        aeroportosList.addAll(Arrays.asList(
           new Airport("GIG", "Aeroporto Internacional Tom Jobin", "Rio de Janeiro")
        ));

    }

    //4
    public void generateFlights(){

    }


}
