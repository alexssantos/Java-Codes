package alex.santos.Services;

import alex.santos.DataAccess.AirportDao;
import alex.santos.DataAccess.MachineDao;
import alex.santos.Entities.Machines.AbstractHelicopter;
import alex.santos.Entities.Machines.Airplane;

import java.util.List;

public class AirportService {

    // DataAccess objs
    AirportDao aeroportosDao;
    MachineDao aviaoDao;
    MachineDao helicopteroDao;

    public AirportService() {
        aeroportosDao = new AirportDao();
        startEntities();
        aviaoDao = new MachineDao(Airplane.class);
        helicopteroDao = new MachineDao(AbstractHelicopter.class);
    }

    public boolean isInternational()
    {
        boolean internalStatus = true;

        return internalStatus;
    }

    public boolean switchInternalStatus()
    {
        boolean internalStatus = true;

        internalStatus = !(internalStatus);
        return internalStatus;
    }

    private void startEntities(){
        List<String> aeroportos = aeroportosDao.getAll();

        System.out.println("startEntities");

    }
}
