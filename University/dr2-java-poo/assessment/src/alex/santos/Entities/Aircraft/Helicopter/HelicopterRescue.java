package alex.santos.Entities.Aircraft.Helicopter;

import alex.santos.Entities.Interfaces.IHelicopter;

public class HelicopterRescue extends AbstractHelicopter implements IHelicopter {


    // CONSTRUCTOR (Empty)
    protected HelicopterRescue(String prefix, String model, String manufacturer) {
        super(prefix, model, manufacturer);
    }

    public HelicopterRescue(String prefix, String model, String manufacturer, IHelicopter typeHelicopter) {
        super(prefix, model, manufacturer, typeHelicopter);
    }

    @Override
    public void Flight() {

    }
}
