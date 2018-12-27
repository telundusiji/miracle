package site.teamo.miracle.util.enums;

/**
 * @author haocongshun
 * create on 2018/12/21 9:40
 */
public enum ExceptionEnum {
    /**
     * 成功. ErrorCode : 0
     */
    SUCCESS("0","SUCCESS","成功"),
    /**
     * 未知异常. ErrorCode : 01
     */
    UnknownException("01","UnknownException","未知异常"),
    /**
     * 系统异常. ErrorCode : 02
     */
    SystemException("02","SystemException","系统异常"),
    /**
     * 业务错误. ErrorCode : 03
     */
    MyException("03","MyException", "业务错误"),
    /**
     * 提示级错误. ErrorCode : 04
     */
    InfoException("04","InfoException","提示级错误"),
    /**
     * 数据库操作异常. ErrorCode : 020001
     */
    DBException("020001","DBException", "数据库操作异常"),
    /**
     * 参数验证错误. ErrorCode : 040001
     */
    MethodArgumentNotValidException("040001","MethodArgumentNotValidException","参数验证错误"),
    /**
     *
     */
    DataCollectorCheckException("040002","DataCollectorCheckException","数据采集校验异常");

    private String code;

    private String status;

    private String msg;

    ExceptionEnum(String code, String status, String msg) {
        this.code = code;
        this.status = status;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
