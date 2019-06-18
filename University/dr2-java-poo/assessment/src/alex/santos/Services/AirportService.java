package alex.santos.Services;

import alex.santos.DataAccess.AirplaneDao;
import alex.santos.DataAccess.AirportDao;
import alex.santos.DataAccess.HelicopterDao;
import java.util.List;

public class AirportService {

    // DataAccess objs
    AirportDao aeroportosDao;
    AirplaneDao aviaoDao;
    HelicopterDao helicopteroDao;

    public AirportService() {
        aeroportosDao = new AirportDao();
        startEntities();
        aviaoDao = new AirplaneDao();
        helicopteroDao = new HelicopterDao();
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
        //List<String> aeroportos = aeroportosDao.getAll();

        System.out.println("startEntities");

    }
}
