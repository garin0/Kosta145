package listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.MemberVO;

/**
 * Application Lifecycle Listener implementation class MemberLoader
 *
 */
@WebListener
public class MemberLoader implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MemberLoader() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         ServletContext context = event.getServletContext();
         HashMap<String,MemberVO> map = new HashMap<String,MemberVO>();
         MemberVO mvo1 = new MemberVO("java", "abcd", "송중기", "판교");
         MemberVO mvo2 = new MemberVO("spring", "dcba", "김지원", "판교");
         map.put(mvo1.getId(), mvo1);
         map.put(mvo2.getId(), mvo2);
         context.setAttribute("map", map);
         System.out.println("contextInitialized memberMap setting");
    }
	
}
