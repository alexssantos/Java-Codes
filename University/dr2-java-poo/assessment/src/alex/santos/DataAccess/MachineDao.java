package alex.santos.DataAccess;

import alex.santos.DataAccess.Repository.PersistenceFile.*;
import alex.santos.Entities.Interfaces.IAircraft;
import alex.santos.Entities.Interfaces.IHelicopter;
import alex.santos.Entities.Machines.Airplane;

import java.util.ArrayList;
import java.util.List;

public class MachineDao<T> extends AbstractDao
{
    // List == INTERFACE
    public List<Airplane> avioesCadastrados;
    public List<IHelicopter> helicopterosCadastrados;
    public Class typeClass;

    public MachineDao(T machine)
    {
        super(machine.getClass(), TypeDb.machines_db);
        typeClass = machine.getClass();

        if (machine.getClass() == null)
        {
            avioesCadastrados = new ArrayList<>();
        }
        if (helicopterosCadastrados == null)
        {
            helicopterosCadastrados = new ArrayList<>();
        }

    }
}
