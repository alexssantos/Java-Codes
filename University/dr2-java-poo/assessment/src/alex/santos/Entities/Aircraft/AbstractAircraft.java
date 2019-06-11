// abstract class to airplane

package alex.santos.Entities.Aircraft;

import alex.santos.Entities.Interfaces.IAircraft;

public abstract class AbstractAircraft {
    private String prefix;
    private String model;
    private String manufacturer;

    // CONSTRUCTOR
    protected AbstractAircraft(String prefix, String model, String manufacturer) {
        this.prefix = prefix;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    // GET SET
    protected String getPrefix() {
        return prefix;
    }

    protected void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    protected String getModel() {
        return model;
    }

    protected void setModel(String model) {
        this.model = model;
    }

    protected String getManufacturer() {
        return manufacturer;
    }

    void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
