package alex.santos.DataAccess;

import alex.santos.DataAccess.Repository.PersistenceFile.*;
import alex.santos.Entities.Machines.*;
import alex.santos.Shared.SharedEnums.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelicopterDao<T extends AbstractHelicopter> extends AbstractDao {

    private final String SEPARETOR_DEFAULT = " \\| ";

    //STATIS LISTS
    public List<HelicopterAirTaxi> airTaxisList;
    public List<HelicopterCostGuard> guardCostsList;
    public List<HelicopterRescue> rescuesList;


    public HelicopterDao() {
        super(AbstractHelicopter.class, TypeDb.helicopters_db);
        if (airTaxisList == null){
            airTaxisList = new ArrayList<>();
            guardCostsList = new ArrayList<>();
            rescuesList = new ArrayList<>();
        }
        pushEntities();
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

    private void pushEntities(){
        List<String> lines = getAll();
        if (lines == null){
            return;
        }

        for (String line : lines)
        {
            String[] filds = line.split(SEPARETOR_DEFAULT);
            String tipo = filds[3];
            if (tipo.equals(HelicopterTypeEnum.AirTaxi.toString())){
                HelicopterAirTaxi item = mapAirTaxi(filds);
                airTaxisList.add(item);
            }
            else if (tipo.equals(HelicopterTypeEnum.CostGuard.toString())){
                HelicopterCostGuard item = mapCostGuard(filds);
                guardCostsList.add(item);
            }
            else if (tipo.equals(HelicopterTypeEnum.Rescue.toString())){
                HelicopterRescue item = mapRescue(filds);
                rescuesList.add(item);
            }
        }
    }

    private HelicopterAirTaxi mapAirTaxi(String[] filds){
        String prefix = filds[1];
        String model = filds[2];
        String manufactor = filds[3];

        HelicopterAirTaxi item = new HelicopterAirTaxi(
            prefix,model,manufactor
        );
        return item;
    }

    private HelicopterCostGuard mapCostGuard(String[] filds){
        String prefix = filds[1];
        String model = filds[2];
        String manufactor = filds[3];

        HelicopterCostGuard item = new HelicopterCostGuard(
                prefix,model,manufactor
        );
        return item;
    }

    private HelicopterRescue mapRescue(String[] filds){
        String prefix = filds[1];
        String model = filds[2];
        String manufactor = filds[3];

        HelicopterRescue item = new HelicopterRescue(
                prefix,model,manufactor
        );
        return item;
    }

    public void mock() {
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
    }


}
