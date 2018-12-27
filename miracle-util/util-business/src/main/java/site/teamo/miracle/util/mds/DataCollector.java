package site.teamo.miracle.util.mds;

import java.util.Vector;

/**
 * @author haocongshun
 * create on 2018/12/25 20:07
 */
public abstract class DataCollector<T> {
    protected Vector<DataProcessor> dps;

    public DataCollector() {
        dps = new Vector<>();
    }

    public synchronized void addProcessor(DataProcessor dp) {
        if (dp == null)
            throw new NullPointerException();
        if (!dps.contains(dp)) {
            dps.addElement(dp);
        }
    }

    public synchronized void deleteProcessor(DataProcessor dp) {
        dps.removeElement(dp);
    }

    public abstract void notifyProcessor(T arg);

    public synchronized void deleteProcessor() {
        dps.removeAllElements();
    }

    public synchronized int countObservers() {
        return dps.size();
    }
}
