package site.teamo.miracle.util.exception;

/**
 * @author haocongshun
 * create on 2018/12/27 15:38
 */
public class DataCollectorCheckException extends Exception {
    private Object data;
    private String msg;
    public DataCollectorCheckException(String msg,Object data){
        this.msg=msg;
        this.data=data;
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}
