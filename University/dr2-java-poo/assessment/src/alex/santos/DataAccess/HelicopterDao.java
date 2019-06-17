package alex.santos.DataAccess;

import alex.santos.DataAccess.Repository.PersistenceFile.*;
import alex.santos.Entities.Machines.*;
import alex.santos.Shared.SharedEnums.*;

import java.util.ArrayList;
import java.util.List;

public class HelicopterDao<T> extends AbstractDao {

    private final String SEPARETOR_DEFAULT = " \\| ";
    public static List<HelicopterAirTaxi> airTaxisList;
    public static List<HelicopterCostGuard> guardCostsList;
    public static List<HelicopterRescue> rescuesList;


    public HelicopterDao() {
        super(AbstractHelicopter.class, TypeDb.helicopters_db);

        airTaxisList = new ArrayList<>();
        guardCostsList = new ArrayList<>();
        rescuesList = new ArrayList<>();

        populateEntities();
    }

    private void populateEntities(){
        List<String> lines = getAll();
        if (lines == null){return;}

        //map Helicopters
        for (String line : lines)
        {
            String[] campos = line.split(SEPARETOR_DEFAULT);

        }

        // MOCK
        HelicopterAirTaxi airTaxi1 = new HelicopterAirTaxi("prefix-1", "model-1", "fabricante-1");
        airTaxisList.add(airTaxi1);
        HelicopterAirTaxi airTaxi2 = new HelicopterAirTaxi("prefix-2", "model-2", "fabricante-2");
        airTaxisList.add(airTaxi2);
        HelicopterAirTaxi airTaxi3 = new HelicopterAirTaxi("prefix-3", "model-3", "fabricante-3");
        airTaxisList.add(airTaxi3);

        saveAll(HelicopterTypeEnum.AirTaxi);
    }

    public void saveAll(HelicopterTypeEnum typeEnum)
    {
        if (typeEnum == HelicopterTypeEnum.AirTaxi)
        {
            saveAll(airTaxisList);
        }
        if (typeEnum == HelicopterTypeEnum.CostGuard)
        {
            saveAll(guardCostsList);
        }
        if (typeEnum == HelicopterTypeEnum.Rescue)
        {
            saveAll(rescuesList);
        }


    }
}
