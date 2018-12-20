package site.teamo.miracle.photograph.api;

import org.springframework.validation.BindingResult;
import site.teamo.miracle.photograph.api.request.index.IndexRequest;

/**
 * @author haocongshun
 * create on 2018/12/18 18:51
 */
public interface IndexController {
    String index(IndexRequest indexRequest);
}
