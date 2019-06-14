package alex.santos.Entities.Machines;

import alex.santos.Entities.Interfaces.IHelicopter;
import static alex.santos.Shared.SharedEnums.*;

public class HelicopterCostGuard extends AbstractHelicopter implements IHelicopter {



    // CONSTRUTOR
    public HelicopterCostGuard(String prefix, String model, String manufacturer) {
        super(prefix, model, manufacturer, HelicopterTypeEnum.CostGuard);
    }

    @Override
    public void Flight() {

    }
}
