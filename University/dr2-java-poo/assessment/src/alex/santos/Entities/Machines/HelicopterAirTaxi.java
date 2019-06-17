package alex.santos.Entities.Machines;

import alex.santos.Entities.Interfaces.IHelicopter;
import static alex.santos.Shared.SharedEnums.*;

public class HelicopterAirTaxi extends AbstractHelicopter implements IHelicopter {

    private String sep = " | ";

    // CONSTRUTOR
    public HelicopterAirTaxi(String prefix, String model, String manufacturer) {
        super(prefix, model, manufacturer,  HelicopterTypeEnum.AirTaxi);
    }


    @Override
    public void Flight() {

    }

    @Override
    public String toString() {
        return this.typeHelicopter+sep+
                this.getPrefix()+sep+
                this.getModel()+sep+
                this.getManufacturer();
    }
}
