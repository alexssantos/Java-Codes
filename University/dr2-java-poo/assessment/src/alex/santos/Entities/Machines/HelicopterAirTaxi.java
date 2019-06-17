package alex.santos.Entities.Machines;

import alex.santos.Entities.Interfaces.IHelicopter;
import static alex.santos.Shared.SharedEnums.*;

public class HelicopterAirTaxi extends AbstractHelicopter implements IHelicopter {




    // CONSTRUTOR
    public HelicopterAirTaxi(String prefix, String model, String manufacturer) {
        super(prefix, model, manufacturer,  HelicopterTypeEnum.AirTaxi);
    }


    @Override
    public void Flight() {

    }

    @Override
    public String toString() {
        return
            this.getPrefix()
                +this.sep+
            this.getModel()
                +this.sep+
            this.getManufacturer()
                +this.sep+
            this.typeHelicopter;
            //++ more atribults
            //++ more atribults
    }
}
