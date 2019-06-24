// abstract class to airplane

package alex.santos.Entities.Machines;

import alex.santos.Entities.Interfaces.IAircraft;

public abstract class AbstractAircraft implements IAircraft, Comparable<AbstractAircraft> {

    String sep = " | ";
    private String prefix;
    private String model;
    private String manufacturer;

    // CONSTRUCTOR
    protected AbstractAircraft(String prefix, String model, String manufacturer) {
        this.prefix = prefix;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    // GET SET      ------------------------------------------------
    public String getPrefix() {
        return prefix;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public int compareTo(AbstractAircraft o) {
        String code = Integer.toString((getPrefix() + getModel() + getManufacturer()).hashCode());
        String code2 = Integer.toString((o.getPrefix() + o.getModel() + o.getManufacturer()).hashCode());
        return code.compareTo(code2);
    }
}
