package alex.santos.Entities.Aircraft.Helicopter;

import alex.santos.Entities.Aircraft.AbstractAircraft;
import alex.santos.Entities.Interfaces.IHelicopter;

public abstract class AbstractHelicopter extends AbstractAircraft {
    public IHelicopter typeHelicopter;

    protected AbstractHelicopter(String prefix, String model, String manufacturer) {
        super(prefix, model, manufacturer);
    }

    public AbstractHelicopter(String prefix, String model, String manufacturer, IHelicopter typeHelicopter) {
        super(prefix, model, manufacturer);
        this.typeHelicopter = typeHelicopter;
    }
}
