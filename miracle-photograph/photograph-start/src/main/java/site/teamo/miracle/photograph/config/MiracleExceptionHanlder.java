package site.teamo.miracle.photograph.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.teamo.miracle.util.dto.response.BaseResponse;
import site.teamo.miracle.util.enums.ExceptionEnum;
import site.teamo.miracle.util.exception.DataCollectorCheckException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author haocongshun
 * create on 2018/12/19 11:45
 */
@RestControllerAdvice
@Component
@Slf4j
public class MiracleExceptionHanlder {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse handleBindException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder errorMsg = new StringBuilder();
        for(FieldError fieldError:fieldErrors){
            errorMsg.append("[");
            errorMsg.append(fieldError.getField());
            errorMsg.append(":");
            errorMsg.append(fieldError.getRejectedValue());
            errorMsg.append("]");
            errorMsg.append("-");
            errorMsg.append(fieldError.getDefaultMessage());
            errorMsg.append(";");
        }
        log.error(ExceptionEnum.MethodArgumentNotValidException.getMsg(),ex);
        return BaseResponse.builder()
                .requestURL(request.getRequestURL().toString())
                .code(ExceptionEnum.MethodArgumentNotValidException.getCode())
                .status(ExceptionEnum.MethodArgumentNotValidException.getStatus())
                .msg(errorMsg.toString())
                .build();
    }

    @ExceptionHandler(DataCollectorCheckException.class)
    public BaseResponse DataCollectorCheckException(DataCollectorCheckException e,HttpServletRequest request){
        Object data = e.getData();
        log.error(JSONObject.toJSONString(data),e);
        return BaseResponse.builder()
                .requestURL(request.getRequestURL().toString())
                .code(ExceptionEnum.DataCollectorCheckException.getCode())
                .status(ExceptionEnum.DataCollectorCheckException.getStatus())
                .msg(ExceptionEnum.DataCollectorCheckException.getMsg())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse handleBindException(Exception e,HttpServletRequest request){
        log.error(ExceptionEnum.UnknownException.getMsg(),e);
        return BaseResponse.builder()
                .requestURL(request.getRequestURL().toString())
                .code(ExceptionEnum.UnknownException.getCode())
                .status(ExceptionEnum.UnknownException.getStatus())
                .msg(ExceptionEnum.UnknownException.getMsg())
                .build();
    }
}
