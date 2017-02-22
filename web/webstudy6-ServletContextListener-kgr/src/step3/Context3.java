package step3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Context3
 */
public class Context3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Context3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ServletConfig로 부터 서블릿 이름을 반환받는다.
		String name = this.getServletConfig().getServletName();
		// ServletConfig로 부터 ServletContext 객체를 반환받는다.
		ServletContext context = this.getServletConfig().getServletContext();
		//  ServletConfig로 부터 웹 어플리케이션명을 반환받는다.
		String webAppName = context.getContextPath();
		out.print("<h3>");
		out.print(name+"<br>");
		out.print("<a href=index.html>"+webAppName+"</a><br><br>");
		out.println(context.getInitParameter("db_driver")+"<br>");
		// ServletContext에 저장되어있는 모든 attribute를 출력해본다.
		Enumeration<String> en = context.getAttributeNames();
		while(en.hasMoreElements()){
			String attName = en.nextElement();
			out.print("name: "+attName+"<br>");
			Object value =context.getAttribute(attName);
			out.print("value: "+value+"<hr>");
		}
		out.close();
	}

}
