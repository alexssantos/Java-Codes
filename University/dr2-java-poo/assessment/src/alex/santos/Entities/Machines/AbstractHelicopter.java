package alex.santos.Entities.Machines;

import alex.santos.Entities.Machines.AbstractAircraft;
import alex.santos.Entities.Interfaces.IHelicopter;

public abstract class AbstractHelicopter extends AbstractAircraft {

    public String typeHelicopter;


    // CONSTRUTORES
    protected AbstractHelicopter(String prefix, String model, String manufacturer) {
        super(prefix, model, manufacturer);
    }

    public AbstractHelicopter(String prefix, String model, String manufacturer, String typeHelicopter) {
        super(prefix, model, manufacturer);
        this.typeHelicopter = typeHelicopter;
    }



    // GET SET
    public String getTypeHelicopter() {
        return typeHelicopter;
    }

    public void setTypeHelicopter(String typeHelicopter) {
        this.typeHelicopter = typeHelicopter;
    }
}
