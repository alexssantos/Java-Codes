package alex.santos.Entities.Machines;

import alex.santos.Entities.Interfaces.IHelicopter;
import alex.santos.Shared.SharedEnums;

public class HelicopterAirTaxi extends AbstractHelicopter implements IHelicopter {



    // CONSTRUTOR
    public HelicopterAirTaxi(String prefix, String model, String manufacturer, SharedEnums.HelicopterTypeEnum typeHelicopter) {
        super(prefix, model, manufacturer, typeHelicopter.toString());
    }


    @Override
    public void Flight() {

    }

}
