package alex.santos.DataAccess;

import alex.santos.DataAccess.Repository.PersistenceFile.*;
import alex.santos.Entities.Airport;

public class AirportDao extends AbstractDao{


    public AirportDao() {
        super(Airport.class, TypeDb.airports_bd);
    }
}
