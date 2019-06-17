package alex.santos;

import alex.santos.DataAccess.AirplaneDao;
import alex.santos.DataAccess.HelicopterDao;
import alex.santos.Entities.Flight;
import alex.santos.Entities.Interfaces.IAircraft;
import alex.santos.Entities.Interfaces.IHelicopter;
import alex.santos.Entities.Machines.*;
import alex.santos.Services.AirportService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        //AirportService airportService = new AirportService();
        generateAircrafts();


        System.out.println("Tudo OK!");


        /*
        CRIAR VOO:
            1. Precisa existir Aeroportos (que precisa existir cidades)
            2. precisa existir Aeronave
         */



    }

    private static void generateAircrafts()
    {
        int ix = 5;
        String PREFIX = "prefix-";
        String MODEL = "model-";
        String MANUFACTOR = "manufactor-";

        List<Airplane> avioes = new ArrayList<>();
        for (int i=0; i < ix; i++) {
            Airplane aviao = new Airplane(PREFIX+i,MODEL+i,MANUFACTOR+i);
            avioes.add(aviao);
        }

        AirplaneDao airplaneDao = new AirplaneDao();
        airplaneDao.saveAllAircrafts(avioes);

        HelicopterAirTaxi airTaxi = new HelicopterAirTaxi(
                PREFIX+ix,MODEL+ix,MANUFACTOR+ix++
        );
        HelicopterRescue rescue = new HelicopterRescue(
                PREFIX+ix,MODEL+ix,MANUFACTOR+ix++
        );
        HelicopterCostGuard costGuard = new HelicopterCostGuard(
                PREFIX+ix,MODEL+ix,MANUFACTOR+ix++
        );

        HelicopterDao helicopterDao = new HelicopterDao();
        helicopterDao.save(airTaxi);
        helicopterDao.save(costGuard);
        helicopterDao.save(rescue);

        for (var item: HelicopterDao.airTaxisList) {
            System.out.println(item);
        }
        for (var item: HelicopterDao.guardCostsList) {
            System.out.println(item);
        }
        for (var item: HelicopterDao.rescuesList) {
            System.out.println(item);
        }
    }

    private static void generateCities()
    {

    }

    private static void generateAirports()
    {

    }

    private static void generateFlights()
    {

    }
}
