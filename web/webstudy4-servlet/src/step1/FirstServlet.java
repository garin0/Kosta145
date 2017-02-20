package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	// client가 get방식으로 요청하면 doGet()이 실행된다.
	// request : 클라이언트 요청 정보 (객체)
	// response : 클라이언트에게 응답하기 위한 정보(객체)
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doGet()");
		// 클라이언트에 응답할 정보를 지정 (한글 처리 포함)
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body bgcolor =yellow>");
		out.print("<h3>FirstServlet doGet메서드가 응답</h3>");
		// client가 보낸 userName을 반환받는다.
		String name = request.getParameter("userName");
		out.print("<br><br>클라이언트가 보낸 이름은 " + name);
		out.print("</body></html>");
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" doPost()");
		// post 방식의 요청은 클라이언트 정보가 http body부분에
		// 저장되어 오므로 별도의 한글 처리가 필요하다.
		request.setCharacterEncoding("utf-8");
		// 응답할 정보를 설정
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body bgcolor=orange>");
		out.print("<h3>FirstServlet doPost메서드가 응답</h3>");
		String name = request.getParameter("userName");
		out.print("<br><br>클라이언트가 보낸 이름은 " + name);
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}
