package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8774027827645082944L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int age = Integer.parseInt(request.getParameter("userAge"));
		String name = request.getParameter("userName");
		String color ="";
		String message ="";
		if(age>=19){  
			color ="red";
			message = name+"님 "+age+"세 성인입니다. 성인사이트 입장";
		}else{
			color ="yellow";
			message =name +"님 " +age+"세 미성년입니다. 다음에 나이먹고 오세요.";
		}
		out.print("<html>");
		out.print("<body bgcolor="+color+">");
		out.print("<h3>"+message +"</h3>");
		out.print("</body></html>");
		out.close();
	}

}
