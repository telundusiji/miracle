package site.teamo.miracle.web.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "site.teamo.miracle.web.blog.*")
@ComponentScan("site.teamo.miracle.web.blog")
public class WebBlogApplication {
    public static void main(String[] args){
        SpringApplication.run(WebBlogApplication.class,args);
    }
}
