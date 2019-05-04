package site.teamo.miracle.web.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebBlogController {
    @RequestMapping("/*")
    public String webBlog(HttpServletRequest request){
        String uri = request.getRequestURI();
        if(uri.endsWith(".html")){
            uri = uri.replace(".html","");
        }
        return uri;
    }
}
