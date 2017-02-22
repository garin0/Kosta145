package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Context2
 */
public class Context2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Context2() {
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
		// ServletContext에 context1이 setting한 kosta_info 정보와
		// kosta_star 정보를 반환받아 출력한다.
		String kostaInfo = (String) context.getAttribute("kosta_info");
		String kostaStar = (String) context.getAttribute("kosta_star");
		out.print("ServletContext getAttribute() 결과: ");
		out.print(kostaInfo+" "+kostaStar);
		out.println("<br><a href=Context3>Context3에서 Enumeration Test</a>");
		out.print("</h3>");
		out.close();
	}

}
