package alex.santos.Entities.Machines;

import alex.santos.Entities.Interfaces.IHelicopter;
import alex.santos.Shared.SharedEnums;

public class HelicopterCostGuard extends AbstractHelicopter implements IHelicopter {


    // CONSTRUTOR
    public HelicopterCostGuard(String prefix, String model, String manufacturer, SharedEnums.HelicopterTypeEnum typeHelicopter) {
        super(prefix, model, manufacturer, typeHelicopter.toString());
    }

    @Override
    public void Flight() {

    }
}
