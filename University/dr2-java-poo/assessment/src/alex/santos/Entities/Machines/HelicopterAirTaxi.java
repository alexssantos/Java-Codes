package alex.santos.Entities.Machines;

import alex.santos.Entities.Interfaces.IHelicopter;
import alex.santos.Shared.HelicopterTypesEnum;

public class HelicopterAirTaxi extends AbstractHelicopter implements IHelicopter {



    // CONSTRUTOR
    public HelicopterAirTaxi(String prefix, String model, String manufacturer, HelicopterTypesEnum typeHelicopter) {
        super(prefix, model, manufacturer, typeHelicopter.toString());
    }


    @Override
    public void Flight() {

    }

}
