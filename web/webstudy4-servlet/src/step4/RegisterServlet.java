package step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = -5415945872396727703L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body bgcolor=yellow>");
		out.print("<h3>회원가입 처리 완료");
		String id = request.getParameter("memId");
		String name = request.getParameter("memName");
		String addr = request.getParameter("memAddress");
		String gender = request.getParameter("gender");
		String blood = request.getParameter("blood");
		out.print("<br>아이디: " + id);
		out.print("<br>이름: " + name);
		out.print("<br>주소: " + addr);
		out.print("<br>성별: " + gender);
		out.print("<br>혈액형: " + blood);
		out.print("</h3></body>");
		out.print("</html>");
		out.close();
	}

}
