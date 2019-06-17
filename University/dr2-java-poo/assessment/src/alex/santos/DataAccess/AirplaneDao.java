package alex.santos.DataAccess;

import alex.santos.DataAccess.Repository.PersistenceFile.*;
import alex.santos.Entities.Interfaces.IAircraft;
import alex.santos.Entities.Interfaces.IHelicopter;
import alex.santos.Entities.Machines.Airplane;

import java.util.ArrayList;
import java.util.List;

public class AirplaneDao extends AbstractDao
{
    // List == INTERFACE
    public List<Airplane> avioesCadastrados;

    public AirplaneDao()
    {
        super(Airplane.class, TypeDb.airplanes_db);

        if (avioesCadastrados == null)
        {
            avioesCadastrados = new ArrayList<>();
        }
    }
}
