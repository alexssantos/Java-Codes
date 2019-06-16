package alex.santos.DataAccess;

import alex.santos.DataAccess.Repository.PersistenceFile.*;
import alex.santos.Entities.Interfaces.IAircraft;
import alex.santos.Entities.Machines.AbstractAircraft;
import alex.santos.Entities.Machines.Airplane;

import java.util.ArrayList;
import java.util.List;

public class MachineDao extends AbstractDao
{
    // List == INTERFACE
    public static List<Airplane> avioesCadastrados;
    public static List<Airplane> helicopterosCadastrados;

    public MachineDao(IAircraft machine)
    {
        super(machine.getClass(), TypeDb.machines_db);
        if (avioesCadastrados == null){ avioesCadastrados = new ArrayList<>(); }
        if (helicopterosCadastrados == null){ helicopterosCadastrados = new ArrayList<>(); }

    }
}
