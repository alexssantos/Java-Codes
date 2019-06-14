// abstract class to airplane

package alex.santos.Entities.Machines;

public abstract class AbstractAircraft {

    /*PREFIX models =
    	PP:	    PP-AAA to PP-ZZZ
        PR:	    PR-AAA to PR-ZZZ (PR-ZAA to PR-ZZZ is reserved to experimental non-LSA aircraft)
        PS[a]:	PS-AAA to PS-ZZZ (proposed by ANAC to be available in 2016)[1]
        PT:	    PT-AAA to PT-ZZZ (PT-ZAA to PT-ZZZ is reserved to experimental non-LSA aircraft)
        PU:	    PU-AAA to PU-ZZZ (Microlights and experimental LSA aircraft)

       / https://en.wikipedia.org/wiki/List_of_aircraft_registration_prefixes
     */
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

    protected String getModel() {
        return model;
    }

    protected String getManufacturer() {
        return manufacturer;
    }


}
