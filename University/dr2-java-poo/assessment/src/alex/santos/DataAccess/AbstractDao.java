package alex.santos.DataAccess;

import alex.santos.DataAccess.Repository.PersistenceFile.*;
import alex.santos.DataAccess.Repository.PersistenceFile;

import java.util.List;

public class AbstractDao<T> {

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

    public void persisteMany(List<T> list )
    {
        db.writeMany(list);
    }
}
