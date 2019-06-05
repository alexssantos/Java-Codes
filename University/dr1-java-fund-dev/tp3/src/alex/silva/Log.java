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
                LOG[0] = newLOG;
            }
            else
            {
                LOG[nextLogIndex] = newLOG;
            }
            nextLogIndex++;
        }
        else    //LOG Full
        {
            overriteLog(newLOG);
        }

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
        for (int i = 0; i < (LOG.length-1); i++)
        {
            LOG[i] = LOG[i+i];
        }
        int nextIndex = nextLogIndex % MAX_LOG_LENGTH;
        LOG[nextIndex] = newLOG;
    }
}
