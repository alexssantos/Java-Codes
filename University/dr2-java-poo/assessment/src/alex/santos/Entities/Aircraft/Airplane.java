package alex.santos.Entities.Aircraft;

import alex.santos.Entities.Interfaces.IAircraft;

public class Airplane extends AbstractAircraft {
    private int seatAmount;
    private String companyName;

    // CONSTRUCTORS
        // Empty
    public Airplane(String prefix, String model, String manufacturer) {
        super(prefix, model, manufacturer);
    }

        // Full
    public Airplane(String prefix, String model, String manufacturer, int seatAmount, String companyName) {
        super(prefix, model, manufacturer);
        this.seatAmount = seatAmount;
        this.companyName = companyName;
    }

    // GET SET
    public int getSeatAmount() {
        return seatAmount;
    }

    public void setSeatAmount(int seatAmount) {
        this.seatAmount = seatAmount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
