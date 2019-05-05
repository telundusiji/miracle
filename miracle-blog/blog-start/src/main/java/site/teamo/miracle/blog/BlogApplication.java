package site.teamo.miracle.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author haocongshun
 * create on 2018/12/18 18:58
 */
@SpringBootApplication(scanBasePackages = "site.teamo.miracle.blog.*")
@ComponentScan("site.teamo.miracle.blog")
@ServletComponentScan(basePackages = "site.teamo.miracle.blog.*")
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class,args);
    }
}
