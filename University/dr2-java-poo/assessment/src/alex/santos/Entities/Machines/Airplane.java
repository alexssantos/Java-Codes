package alex.santos.Entities.Machines;

import alex.santos.Entities.Interfaces.IAircraft;

public class Airplane extends AbstractAircraft implements IAircraft{

    private int seatAmount;
    private String companyName;


    // CONSTRUCTORS
    public Airplane(String prefix, String model, String manufacturer) {
        super(prefix, model, manufacturer);
        this.seatAmount = 0;
        this.companyName = "NO COMPANY";
    }

    public Airplane(String prefix, String model, String manufacturer, int seatAmount, String companyName) {
        super(prefix, model, manufacturer);
        this.seatAmount = seatAmount;
        this.companyName = companyName;
    }

    // GET SETs     --------------------------------------------------------------
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


    // METHODS      --------------------------------------------------------------
    public int getAirplaneCode(){
        int code = (getPrefix()+getModel()+getCompanyName()).hashCode();
        return code;
    }

    // OVERRIDE     --------------------------------------------------------------
    @Override
    public String toString() {
        return this.getPrefix()
                +this.sep+
                this.getModel()
                +this.sep+
                this.getManufacturer()
                +this.sep+
                companyName
                +this.sep+
                seatAmount;
        //++ more atribults
        //++ more atribults
    }
}
