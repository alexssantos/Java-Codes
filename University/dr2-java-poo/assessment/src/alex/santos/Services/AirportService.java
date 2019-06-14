package alex.santos.Services;

public class AirportService {


    public AirportService() {
    }

    public boolean isInternational()
    {
        return internalStatus;
    }

    public void switchInternalStatus()
    {
        this.internalStatus = !(this.internalStatus);
    }
}
