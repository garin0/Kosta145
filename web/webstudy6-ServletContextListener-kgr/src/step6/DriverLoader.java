package step6;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class DriverLoader
 *
 */
public class DriverLoader implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DriverLoader() {
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
     * 웹 어플리케이션 최초 시작시점
     * -> ServletContext 객체를 생성
     * 		-> 생성 직후에 아래 메서드가 호출된다.
     * 			-> 단 한번 실행되므로 데이터베이스 드라이버로딩 작업을 한다. 
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	String driver = event.getServletContext().getInitParameter("db_driver");
    	try {
			Class.forName(driver);
			 System.out.println("contextInitialized 실행 시 driver loading");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
    }
	
}
