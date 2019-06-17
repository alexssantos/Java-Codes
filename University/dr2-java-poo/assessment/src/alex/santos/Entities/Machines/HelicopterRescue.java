package alex.santos.Entities.Machines;

import alex.santos.Entities.Interfaces.IHelicopter;
import alex.santos.Shared.SharedEnums.*;

public class HelicopterRescue extends AbstractHelicopter implements IHelicopter {


    // CONSTRUCTOR
    public HelicopterRescue(String prefix, String model, String manufacturer) {
        super(prefix, model, manufacturer, HelicopterTypeEnum.Rescue);
    }

    @Override
    public void Flight() {

    }

    @Override
    public String toString() {
        return this.typeHelicopter+this.sep+
                this.getPrefix()+this.sep+
                this.getModel()+this.sep+
                this.getManufacturer();
        //++ more atribults
        //++ more atribults
    }
}
