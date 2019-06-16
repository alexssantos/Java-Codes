package alex.santos.DataAccess;

import alex.santos.DataAccess.Repository.PersistenceFile.*;

public class FlightDao extends AbstractDao
{
    TypeDb TYPE_DB = TypeDb.flights_db;

    public FlightDao(Class persistentClass)
    {
        super(persistentClass, TypeDb.flights_db);
    }
}
