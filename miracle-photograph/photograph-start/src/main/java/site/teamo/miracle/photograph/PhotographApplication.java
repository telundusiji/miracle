package site.teamo.miracle.photograph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author haocongshun
 * create on 2018/12/18 17:06
 */
@SpringBootApplication(scanBasePackages = {"site.teamo.miracle.photograph.*"})
@ComponentScan("site.teamo.miracle.photograph")
public class PhotographApplication {
    public static void main(String[] args) {
        SpringApplication.run(PhotographApplication.class,args);
    }
}
