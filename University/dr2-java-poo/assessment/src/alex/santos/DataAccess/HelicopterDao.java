package alex.santos.DataAccess;

import alex.santos.DataAccess.Repository.PersistenceFile.*;
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
            persisteMany(airTaxisList);
        }
        if (typeEnum == HelicopterTypeEnum.CostGuard)
        {
            persisteMany(guardCostsList);
        }
        if (typeEnum == HelicopterTypeEnum.Rescue)
        {
            persisteMany(rescuesList);
        }
    }

    public int persisteAll(){
        db.cleanFile();
        persisteMany(airTaxisList);
        persisteMany(guardCostsList);
        persisteMany(rescuesList);
        int qtdd = airTaxisList.size() + guardCostsList.size() + rescuesList.size();
        return qtdd;
    }

    public <E extends AbstractHelicopter> int save(E helicopter){
        int qtdd = 0;
        if (helicopter.typeHelicopter == HelicopterTypeEnum.AirTaxi)
        {
            airTaxisList.add((HelicopterAirTaxi) helicopter);
            qtdd += airTaxisList.size();
        }
        if (helicopter.typeHelicopter == HelicopterTypeEnum.CostGuard)
        {
            guardCostsList.add((HelicopterCostGuard) helicopter);
            qtdd += guardCostsList.size();
        }
        if (helicopter.typeHelicopter == HelicopterTypeEnum.Rescue)
        {
            rescuesList.add((HelicopterRescue) helicopter);
            qtdd += rescuesList.size();
        }
        return qtdd;
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
