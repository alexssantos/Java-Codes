package alex.santos.Services;

import alex.santos.DataAccess.AirportDao;
import alex.santos.DataAccess.MachineDao;

public class AirportService {

    // DataAccess objs
    AirportDao aeroportosDao;
    MachineDao aeronavesDao;

    public AirportService() {
        aeroportosDao = new AirportDao();
        aeronavesDao = new MachineDao();
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
}
