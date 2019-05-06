package site.teamo.miracle.blog.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import site.teamo.miracle.blog.dao.core.BlogContext;

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
