package site.teamo.miracle.photograph.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.teamo.miracle.util.dto.response.BaseResponse;
import site.teamo.miracle.util.enums.ApiEnum;

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
        log.error(ApiEnum.MethodArgumentNotValidException.getMsg(),ex);
        return BaseResponse.builder()
                .requestURL(request.getRequestURL().toString())
                .code(ApiEnum.MethodArgumentNotValidException.getCode())
                .status(ApiEnum.MethodArgumentNotValidException.getStatus())
                .msg(errorMsg.toString())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse handleBindException(Exception e,HttpServletRequest request){
        log.error(ApiEnum.UnknownException.getMsg(),e);
        return BaseResponse.builder()
                .requestURL(request.getRequestURL().toString())
                .code(ApiEnum.UnknownException.getCode())
                .status(ApiEnum.UnknownException.getStatus())
                .msg(ApiEnum.UnknownException.getMsg())
                .build();
    }
}
