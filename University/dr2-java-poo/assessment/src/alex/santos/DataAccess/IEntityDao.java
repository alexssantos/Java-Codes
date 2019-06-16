package alex.santos.DataAccess;

import java.util.ArrayList;

public interface IEntityDao<T> {

    public long getId();
    public ArrayList<T> getAll();

}
