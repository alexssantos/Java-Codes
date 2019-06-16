package alex.santos.DataAccess;

import alex.santos.Entities.Interfaces.IAircraft;
import alex.santos.Entities.Machines.AbstractAircraft;
import alex.santos.Entities.Machines.Airplane;

import java.util.ArrayList;
import java.util.List;

public class MachineDao
{
    // List == INTERFACE
    public static List<Airplane> avioesCadastrados;
    public static List<Airplane> helicopterosCadastrados;

    public MachineDao()
    {
        if (avioesCadastrados == null){ avioesCadastrados = new ArrayList<>(); }
        if (helicopterosCadastrados == null){ helicopterosCadastrados = new ArrayList<>(); }

    }
}
