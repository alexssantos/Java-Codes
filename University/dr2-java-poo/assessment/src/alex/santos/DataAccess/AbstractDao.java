package alex.santos.DataAccess;

import alex.santos.DataAccess.Repository.PersistenceFile.*;
import alex.santos.DataAccess.Repository.PersistenceFile;

public class AbstractDao<T extends IEntityDao> {

    private final Class<T> persistentClass;
    private PersistenceFile db;

    public AbstractDao(Class<T> persistentClass, TypeDb typeDb) {
        this.persistentClass = persistentClass;
        db = new PersistenceFile(typeDb);
    }
}
