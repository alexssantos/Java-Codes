package alex.santos.Entities.Machines;

import alex.santos.Entities.Interfaces.IHelicopter;
import static alex.santos.Shared.SharedEnums.*;

public class HelicopterCostGuard extends AbstractHelicopter implements IHelicopter {



    // CONSTRUTOR
    public HelicopterCostGuard(String prefix, String model, String manufacturer) {
        super(prefix, model, manufacturer, HelicopterTypeEnum.CostGuard);
    }

    @Override
    public void Fly() {

    }

    @Override
    public String toString() {
        return
            this.typeHelicopter
            +this.sep+
            this.getPrefix()
            +this.sep+
            this.getModel()
            +this.sep+
            this.getManufacturer();
        //++ more atribults
        //++ more atribults
    }
}
