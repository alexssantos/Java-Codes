package alex.santos.DataAccess;

import alex.santos.DataAccess.Repository.PersistenceFile.*;
import alex.santos.DataAccess.Repository.PersistenceFile;
import alex.santos.Entities.Interfaces.IHelicopter;
import alex.santos.Entities.Machines.AbstractAircraft;

import java.util.List;

public class AbstractDao<T extends IEntityDao> {

    public final Class<?> persistentClass;
    public PersistenceFile db;

    public AbstractDao(Class<T> persistentClass, TypeDb typeDb) {
        this.persistentClass = persistentClass;
        db = new PersistenceFile(typeDb);
    }

    public List<String> getAll(){
        if (!db.openReadConn()){
            return  null;
        }
        List<String> retorno = db.readAll();
        db.closeReadConn();
        return  retorno;
    }

    public void saveAll(List<? extends AbstractAircraft> objs )
    {
        if (!db.openWriteConn()){
            return;
        }

        for ( Object obj: objs)
        {
            db.write(obj);
        }
        db.closeWriteConn();
    }
}
