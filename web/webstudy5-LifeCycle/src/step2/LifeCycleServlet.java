package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
		System.out.println("init() 실행");
	}
	@Override
	public void destroy() {
		System.out.println("destroy() 실행"
				+ "");
	}
    public LifeCycleServlet() {
        super();
        System.out.println("LifeCycleServlet 생성자..객체 생성");
    }
/*	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service");
	}*/
	private int count;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>접속수:");
		out.print(++count);
		out.print("</h2>");
		System.out.println("service 계열 메서드 실행");
		out.close();
		
	}


}
