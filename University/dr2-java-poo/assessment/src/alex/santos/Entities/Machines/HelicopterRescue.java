package alex.santos.Entities.Machines;

import alex.santos.Entities.Interfaces.IHelicopter;
import alex.santos.Shared.SharedEnums;

public class HelicopterRescue extends AbstractHelicopter implements IHelicopter {


    // CONSTRUCTOR
    public HelicopterRescue(String prefix, String model, String manufacturer, SharedEnums.HelicopterTypeEnum typeHelicopter) {
        super(prefix, model, manufacturer, typeHelicopter.toString());
    }

    @Override
    public void Flight() {

    }
}
