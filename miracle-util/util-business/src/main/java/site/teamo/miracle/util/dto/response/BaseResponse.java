package site.teamo.miracle.util.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.teamo.miracle.util.enums.ExceptionEnum;

/**
 * @author haocongshun
 * create on 2018/12/19 10:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse {
    /**状态码*/
    private String code;

    /**
     * 状态描述
     */
    private String status;

    /**
     * 请求信息
     */
    private String msg;

    /**
     * 请求URL
     */
    private String requestURL;

    /**
     * 查询状态字符串描述: OK-查询结束, MORE-还有数据等待查询, NO MATCH-没有匹配数据
     */
    private String responseStatusString;

    private Object data;

    public static BaseResponse getErrorResponse(String requestURL, String code, String msg){
        return BaseResponse.builder()
                .requestURL(requestURL)
                .code(code)
                .msg(msg)
                .build();
    }

    public static BaseResponse getSuccessResponse(String requestURL,Object data){
        return BaseResponse.builder()
                .requestURL(requestURL)
                .code(ExceptionEnum.SUCCESS.getCode())
                .msg(ExceptionEnum.SUCCESS.getStatus())
                .data(data)
                .build();
    }

    public static BaseResponse getSuccessResponse(String requestURL){
        return BaseResponse.builder()
                .requestURL(requestURL)
                .code(ExceptionEnum.SUCCESS.getCode())
                .msg(ExceptionEnum.SUCCESS.getStatus())
                .build();
    }
}
