package site.teamo.miracle.photograph.api.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.teamo.miracle.photograph.api.IndexController;

/**
 * @author haocongshun
 * create on 2018/12/18 19:25
 */
@RestController
public class IndexControllerImpl implements IndexController {
    @Override
    @RequestMapping("/")
    public String index() {
        return null;
    }
}
