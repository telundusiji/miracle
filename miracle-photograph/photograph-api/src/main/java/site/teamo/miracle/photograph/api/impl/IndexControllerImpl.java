package site.teamo.miracle.photograph.api.impl;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.teamo.miracle.photograph.api.IndexController;
import site.teamo.miracle.photograph.api.request.index.IndexRequest;

import javax.validation.Valid;

/**
 * @author haocongshun
 * create on 2018/12/18 19:25
 */
@RestController
public class IndexControllerImpl implements IndexController {
    @Override
    @RequestMapping("/")
    public String index(@RequestBody @Validated IndexRequest baseRequest) {
        //System.out.println(bindingResult.getFieldError().getDefaultMessage());
        System.out.println(baseRequest.toString());
        return null;
    }
}
