package alex.santos.Entities.Machines;

import alex.santos.Entities.Interfaces.IHelicopter;
import static alex.santos.Shared.SharedEnums.*;

public class HelicopterAirTaxi extends AbstractHelicopter implements IHelicopter {

    double TaxValue;

    // CONSTRUTOR
    public HelicopterAirTaxi(String prefix, String model, String manufacturer) {
        super(prefix, model, manufacturer,  HelicopterTypeEnum.AirTaxi);
    }

    //GET SETs          -----------------------------------------
    public double getTaxValue() {
        return TaxValue;
    }

    public void setTaxValue(double taxValue) {
        TaxValue = taxValue;
    }

    // OVERRIDES        -----------------------------------------
    @Override
    public void Fly() {

    }

    @Override
    public String toString() {
        return
            this.typeHelicopter
                +this.sep+
            this.getPrefix()
                +this.sep+
            this.getModel()
                +this.sep+
            this.getManufacturer();
            //++ more atribults
            //++ more atribults
    }
}
