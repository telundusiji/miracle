package site.teamo.miracle.photograph.config;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.teamo.miracle.photograph.api.response.BaseResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haocongshun
 * create on 2018/12/19 11:45
 */
@RestControllerAdvice
@Component
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
        return BaseResponse.builder()
                .requestURL(request.getRequestURL().toString())
                .errorMsg(errorMsg.toString())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public Map handleBindException(Exception e){
        e.printStackTrace();
        return null;
    }
}
