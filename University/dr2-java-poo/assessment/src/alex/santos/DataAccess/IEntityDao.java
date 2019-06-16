package alex.santos.DataAccess;

import alex.santos.DataAccess.Repository.PersistenceFile.TypeDb;

import java.util.ArrayList;

public interface IEntityDao<T> {

    public long getId();
    public ArrayList<T> getAll();
    public TypeDb getTypeDb();

}
