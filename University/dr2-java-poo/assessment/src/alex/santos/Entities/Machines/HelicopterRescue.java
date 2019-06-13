package alex.santos.Entities.Machines;

import alex.santos.Entities.Interfaces.IHelicopter;
import alex.santos.Shared.HelicopterTypesEnum;

public class HelicopterRescue extends AbstractHelicopter implements IHelicopter {


    // CONSTRUCTOR
    public HelicopterRescue(String prefix, String model, String manufacturer, HelicopterTypesEnum typeHelicopter) {
        super(prefix, model, manufacturer, typeHelicopter.toString());
    }

    @Override
    public void Flight() {

    }
}
