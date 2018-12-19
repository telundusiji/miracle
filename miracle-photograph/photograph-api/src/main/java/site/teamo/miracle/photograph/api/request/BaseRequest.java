package site.teamo.miracle.photograph.api.request;

/**
 * @author haocongshun
 * create on 2018/12/19 10:06
 */
public class BaseRequest<T> {
    private T Photograph;

    public T getPhotograph() {
        return Photograph;
    }

    public void setPhotograph(T photograph) {
        Photograph = photograph;
    }
}
