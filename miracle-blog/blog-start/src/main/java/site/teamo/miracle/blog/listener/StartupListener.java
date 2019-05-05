package site.teamo.miracle.blog.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;
import site.teamo.miracle.blog.core.BlogContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class StartupListener implements ServletContextListener {

    @Autowired
    private BlogContext blogContext;

    @Value("${miracle.blog.articlePath}")
    private String articlePath;

    public void contextInitialized(ServletContextEvent sce) {
        blogContext.init(articlePath);
    }

}
