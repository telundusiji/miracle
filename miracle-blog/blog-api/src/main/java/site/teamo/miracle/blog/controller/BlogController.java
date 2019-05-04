package site.teamo.miracle.blog.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @GetMapping("/category")
    public JSONObject categories(){
        return new JSONObject();
    }

    @GetMapping("/category/{categoryName}")
    public JSONObject category(){
        return new JSONObject();
    }

    @GetMapping("/category/{categoryName}/article")
    public JSONObject articles(){
        return new JSONObject();
    }

    @GetMapping("/category/{categoryName}/article/{articleName}")
    public JSONObject article(){
        return new JSONObject();
    }
}
