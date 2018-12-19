package site.teamo.miracle.photograph.api.request.index;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author haocongshun
 * create on 2018/12/19 10:19
 */
public class IndexRequest {
    @NotBlank(message = "自定义错误信息，Email不能为空")
    @Length(min = 1,max = 2)
    private String page;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
