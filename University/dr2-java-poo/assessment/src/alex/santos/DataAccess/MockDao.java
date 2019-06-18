package alex.santos.DataAccess;

import alex.santos.Entities.Machines.Airplane;
import alex.santos.Entities.Machines.HelicopterAirTaxi;
import alex.santos.Entities.Machines.HelicopterCostGuard;
import alex.santos.Entities.Machines.HelicopterRescue;

import java.util.ArrayList;
import java.util.List;

public class MockDao {

    public MockDao() {
    }

    private static void generateAircrafts()
    {
        //  pre-Atributos  ------------------------------
        int ix = 5;
        String PREFIX = "prefix-";
        String MODEL = "model-";
        String MANUFACTOR = "manufactor-";


        // Avioes ----------------------------------------
        List<Airplane> avioes = new ArrayList<>();
        for (int i=0; i < ix; i++) {
            Airplane aviao = new Airplane(PREFIX+i,MODEL+i,MANUFACTOR+i);
            avioes.add(aviao);
        }
        AirplaneDao airplaneDao = new AirplaneDao();
        airplaneDao.persisteMany(avioes);


        // Helicopteros     ---------------------------------------

        HelicopterAirTaxi airTaxi = new HelicopterAirTaxi(
                PREFIX+ix,MODEL+ix,MANUFACTOR+ix
        );
        ix++;
        HelicopterRescue rescue = new HelicopterRescue(
                PREFIX+ix,MODEL+ix,MANUFACTOR+ix
        );
        ix++;
        HelicopterCostGuard costGuard = new HelicopterCostGuard(
                PREFIX+ix,MODEL+ix,MANUFACTOR+ix
        );


        HelicopterDao helicopterDao = new HelicopterDao();
        // lendo helicopteros do arquivo    ------------

        System.out.println("\nLendo dos Arquivo helicopters_db.txt\n");
        for (Object item: helicopterDao.airTaxisList) {
            System.out.println(item);
        }
        helicopterDao.save(costGuard);
        for (Object item: helicopterDao.guardCostsList) {
            System.out.println(item);
        }
        helicopterDao.save(rescue);
        for (Object item: helicopterDao.rescuesList) {
            System.out.println(item);
        }

        // ------------------------------
        helicopterDao.save(airTaxi);
        System.out.println("\nGranvando Helicopteros no Arquivo.\n");
        int qtdd = helicopterDao.persisteAll();
        System.out.println(qtdd+" Helicopteros salvos em Arquivo.");
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
