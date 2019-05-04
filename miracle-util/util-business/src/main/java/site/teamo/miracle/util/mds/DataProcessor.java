package site.teamo.miracle.util.mds;

/**
 * @author haocongshun
 * create on 2018/12/25 20:17
 */
public interface DataProcessor<T> {
    void handle(T o);
}
