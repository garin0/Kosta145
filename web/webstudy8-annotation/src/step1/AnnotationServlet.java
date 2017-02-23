
package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnnotationServlet
 */
// 이노테이션으로 설정되어 있으므로 
// web.xml에서는 별도의 서블릿 설정이 필요없다.
// xml 에서 설정할 경우 server error 발생한다.
// @WebServlet(url-pattern)
@WebServlet("/AnnotationServlet")
public class AnnotationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnotationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = getServletConfig().getServletName();
		out.print(name+" 어노테이션으로 설정되어있다.");
		ServletContext context = getServletConfig().getServletContext();
		out.print("<br>서블릿 컨텍스트에서 관리자 아이디를 받아온다<br>");
		out.println(context.getInitParameter("adminId"));
		out.close();
	}
}
