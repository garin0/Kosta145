package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet{
	private static final long serialVersionUID = -4355938243374639050L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LinkServlet doGet()");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body bgcolor=yellow>");
		// client가 보낸 userName을 반환받는다.
		String id = request.getParameter("id");
		String nick = request.getParameter("nick");
		if(id!=null)
			out.print(id+" ");
		if(nick!=null)
			out.print(nick);
		out.print("</body></html>");
		out.close();
	}
}
