package alex.santos.Entities.Aircraft.Helicopter;

import alex.santos.Entities.Interfaces.IHelicopter;

public class HelicopterCostGuard extends AbstractHelicopter implements IHelicopter {


    protected HelicopterCostGuard(String prefix, String model, String manufacturer) {
        super(prefix, model, manufacturer);
    }

    public HelicopterCostGuard(String prefix, String model, String manufacturer, IHelicopter typeHelicopter) {
        super(prefix, model, manufacturer, typeHelicopter);
    }

    @Override
    public void Flight() {

    }
}
