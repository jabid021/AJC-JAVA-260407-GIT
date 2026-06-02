package quest.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import quest.context.Singleton;


@WebListener
public class StartTomcatListener implements ServletContextListener {

   
    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("Start tomcat, on lance JPA dans le back");
        Singleton.getInstance();
    }

  
}
