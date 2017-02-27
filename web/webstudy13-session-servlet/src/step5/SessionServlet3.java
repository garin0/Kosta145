package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet3
 */
@WebServlet("/SessionServlet3")
public class SessionServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session==null){
			out.println("<h3> SessionServlet3 session 없음!<br>");
		}else{
			session.invalidate();
			out.println("<h3> SessionServlet3 session을 무효화<br>");
		}
		out.println("<a href=SessionServlet1>SessionServlet1</a><br>");
		out.println("<a href=SessionServlet2>SessionServlet2</a><br>");
		out.println("</h3>");
		out.close();
	}

}
