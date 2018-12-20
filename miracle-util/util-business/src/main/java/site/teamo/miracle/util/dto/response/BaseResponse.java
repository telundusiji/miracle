package site.teamo.miracle.util.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer statusCode;

    /**状态描述*/
    private String statusString;

    /**请求URL*/
    private String requestURL;

    /**当statusCode不为1时，必填。错误码,与subStatusCode对应*/
    private Integer errorCode;

    /**当statusCode不为1时，必填,错误详细信息,能具体到某一个参数的错误*/
    private String errorMsg;

    /**查询状态字符串描述: OK-查询结束, MORE-还有数据等待查询, NO MATCH-没有匹配数据*/
    private String responseStatusString;

    public static BaseResponse getErrorResponse(String requestURL, int errorCode, String errorMsg){
        return BaseResponse.builder()
                .requestURL(requestURL)

                .errorCode(errorCode)
                .errorMsg(errorMsg)
                .build();
    }
}
