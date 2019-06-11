package alex.santos.Entities.Aircraft.Helicopter;

import alex.santos.Entities.Interfaces.IHelicopter;

public class HelicopterAirTaxi extends AbstractHelicopter implements IHelicopter {


    protected HelicopterAirTaxi(String prefix, String model, String manufacturer) {
        super(prefix, model, manufacturer);
    }

    @Override
    public void Flight() {

    }
}
