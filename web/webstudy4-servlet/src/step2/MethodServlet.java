package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MethodServlet extends HttpServlet{

	private static final long serialVersionUID = 5590208362775214515L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doGet()");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body bgcolor=yellow>");
		out.print("<h3>등록 OK");
		String name = request.getParameter("memberName");
		String addr = request.getParameter("memberAddr");
		out.print("<br>이름 "+name);
		out.print("<br>주소 "+addr);
		out.print("</h3></body>");
		out.print("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		// 응답할 정보를 설정
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body bgcolor=yellow>");
		out.print("<h3>등록 OK- post");
		String name = request.getParameter("memberName");
		String addr = request.getParameter("memberAddr");
		out.print("<br>이름 "+name);
		out.print("<br>주소 "+addr);
		out.print("</h3></body>");
		out.print("</html>");
		out.close();
	}


}
