package step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet2
 */
@WebServlet("/SessionServlet2")
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 기존 세션이 없으면 null 반환
		HttpSession session = request.getSession(false);
		if (session != null) {
			// 세션으로부터 이름을 반환받아 출력
			String name = (String) session.getAttribute("personName");
			out.println("<h3> SessionServlet2 session에 이름을 반환: " + name + "<br>");
		} else {
			out.println("<h3> SessionServlet2 기존 세션이 없습니다.<br>");
			out.println("<a href=SessionServlet1>SessionServlet1</a>");
		}
		out.println("<a href=SessionServlet3>SessionServlet3</a>");
		out.println("</h3>");
		out.close();
	}

}
