package alex.santos.DataAccess;

import alex.santos.DataAccess.Repository.PersistenceFile.*;
import alex.santos.Entities.Interfaces.IHelicopter;
import alex.santos.Entities.Machines.*;
import alex.santos.Shared.SharedEnums.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelicopterDao<T extends AbstractHelicopter> extends AbstractDao {

    private final String SEPARETOR_DEFAULT = " | ";

    //STATIS LISTS
    public static List<HelicopterAirTaxi> airTaxisList = new ArrayList<>();
    public List<HelicopterCostGuard> guardCostsList = new ArrayList<>();
    public List<HelicopterRescue> rescuesList = new ArrayList<>();
    //public List<? extends IHelicopter> genericList;


    public HelicopterDao() {
        super(AbstractHelicopter.class, TypeDb.helicopters_db);
        populateEntities();
    }

    public void persisteAllByType(HelicopterTypeEnum typeEnum)
    {
        if (typeEnum == HelicopterTypeEnum.AirTaxi)
        {
            saveAllAircrafts(airTaxisList);
        }
        if (typeEnum == HelicopterTypeEnum.CostGuard)
        {
            saveAllAircrafts(guardCostsList);
        }
        if (typeEnum == HelicopterTypeEnum.Rescue)
        {
            saveAllAircrafts(rescuesList);
        }
    }

    public void persisteAll(){
        saveAllAircrafts(airTaxisList);
        saveAllAircrafts(guardCostsList);
        saveAllAircrafts(rescuesList);
    }

    public <E extends AbstractHelicopter> void save(E helicopter){
        if (helicopter.typeHelicopter == HelicopterTypeEnum.AirTaxi)
        {
            airTaxisList.add((HelicopterAirTaxi) helicopter);
        }
        if (helicopter.typeHelicopter == HelicopterTypeEnum.CostGuard)
        {
            guardCostsList.add((HelicopterCostGuard) helicopter);
        }
        if (helicopter.typeHelicopter == HelicopterTypeEnum.Rescue)
        {
            rescuesList.add((HelicopterRescue) helicopter);
        }
    }


    public <T extends AbstractHelicopter> void saveMany(List<T> list){
        for (T item: list) {
            save(item);
        }
    }

    //MOCK
    private void populateEntities(){
        List<String> lines = getAll();
        if (lines == null){return;}

        //map Helicopters
        for (String line : lines)
        {
            String[] campos = line.split(SEPARETOR_DEFAULT);

        }

        // MOCK
        airTaxisList.addAll(
                Arrays.asList(
                        new HelicopterAirTaxi("prefix-1", "model-1", "fabricante-1"),
                        new HelicopterAirTaxi("prefix-2", "model-2", "fabricante-2"),
                        new HelicopterAirTaxi("prefix-3", "model-3", "fabricante-3"),
                        new HelicopterAirTaxi("prefix-4", "model-4", "fabricante-4"),
                        new HelicopterAirTaxi("prefix-5", "model-5", "fabricante-5"),
                        new HelicopterAirTaxi("prefix-6", "model-6", "fabricante-6"),
                        new HelicopterAirTaxi("prefix-7", "model-7", "fabricante-7")
        ));

        //genericList = airTaxisList;
        //saveAll(HelicopterTypeEnum.AirTaxi);
    }
}
