package Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        // 加载资源文件
        String configPath = context.getInitParameter("ContextConfigPath");
        // 获取真实路径
        String realPath = context.getRealPath(configPath);
        // 加载配置文件
        try {
            FileInputStream fileInputStream = new FileInputStream(realPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("the Tomcat Server launch...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        System.out.println("the Tomcat Server close...");
    }
}
