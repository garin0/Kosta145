package step2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class TestListener
 *
 */
@WebListener //ServletContextListener라고 어노테이션 방식으로 웹컨테이너에 알린다.
public class TestListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         System.out.println("contextDestroyed");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         System.out.println("contextInitialized");
    }
	
}
