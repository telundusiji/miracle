package site.teamo.miracle.util.mds;

import java.util.Vector;

/**
 * @author haocongshun
 * create on 2018/12/25 20:07
 */
public abstract class DataCollector {
    private boolean changed = false;
    private Vector<DataProcessor> dps;

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

    public void notifyProcessor(Object arg) {
        /*
         * a temporary array buffer, used as a snapshot of the state of
         * current Observers.
         */
        Object[] arrLocal;

        synchronized (this) {
            arrLocal = dps.toArray();
        }

        for (int i = arrLocal.length - 1; i >= 0; i--)
            ((DataProcessor) arrLocal[i]).handle(arg);
    }

    public synchronized void deleteProcessor() {
        dps.removeAllElements();
    }

    public synchronized int countObservers() {
        return dps.size();
    }
}
