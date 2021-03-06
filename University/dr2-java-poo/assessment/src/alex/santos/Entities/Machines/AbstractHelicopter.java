package alex.santos.Entities.Machines;


import static alex.santos.Shared.SharedEnums.*;

public abstract class AbstractHelicopter extends AbstractAircraft {

    public HelicopterTypeEnum typeHelicopter;


    // CONSTRUTORES
    public AbstractHelicopter(String prefix, String model, String manufacturer, HelicopterTypeEnum typeHelicopter) {
        super(prefix, model, manufacturer);
        this.typeHelicopter = typeHelicopter;
    }

    // GET SET
    public String getTypeHelicopter() {
        return typeHelicopter.toString();
    }

    public void setTypeHelicopter(HelicopterTypeEnum typeHelicopter) {
        this.typeHelicopter = typeHelicopter;
    }
}
