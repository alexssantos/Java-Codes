package alex.silva;

public class Log {
    final int MAX_LOG_LENGTH = 5;
    int nextLogIndex = 0;
    public static String LOG[];


    public Log() {
        if ((LOG == null) || (LOG.length == 0))
        {
            LOG = new String[MAX_LOG_LENGTH];
        }
    }

    public void writeLOG(String newLOG)
    {
        if (newLOG.isEmpty()){
            return;
        }

        if (!isLogFull()){
            if (nextLogIndex == 0) //EMPTY
            {
                LOG[0] = "1) " + newLOG;
            }
            else
            {
                LOG[nextLogIndex] = (nextLogIndex+1) + ") " + newLOG;
            }
        }
        else    //LOG Full
        {
            overriteLog(newLOG);
        }
        nextLogIndex ++;
    }

    private boolean isLogFull()
    {
        if (nextLogIndex >= MAX_LOG_LENGTH)
        {
            return true;
        }
        return false;
    }

    private void overriteLog(String newLOG)
    {
        for (int i = 0; i < (MAX_LOG_LENGTH-1); i++)
        {
            LOG[i] = LOG[i+1];
        }

        LOG[MAX_LOG_LENGTH-1] = (nextLogIndex+1)+ ") " + newLOG;
    }
}
