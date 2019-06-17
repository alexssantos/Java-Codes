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

    @Override
    public String toString() {
        return
            this.getPrefix()
                +this.sep+
            this.getModel()
                +this.sep+
            this.getManufacturer()
                +this.sep+
            this.typeHelicopter;
        //++ more atribults
        //++ more atribults
    }
}
