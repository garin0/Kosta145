package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		requestProcess(request,response);
	}
	/**
	 * 1. client 요청 분석
	 * 2. HandlerMapping(Factory)를 이용해 컨트롤러 구현체 생성을
	 * 의뢰하여 Controller Interface type으로 반환받는다.
	 * 3. 개별 컨트롤러 구현체의 컨트롤러 메서드(execute)를 실행한다.
	 * 4. 예외처리 try catch를 작성하고 예외발생시 
	 * 서버상에서 메세지 출력하고 error.jsp로 응답한다.(redirect)
	 * 5. 컨트롤러 메서드 실행 후 반호나되는 url에 의거
	 *    forward 또는 redirect 방식으로 이동
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		Controller controller = HandlerMapping.getInstance().create(command);
		try{
			String url = controller.execute(request, response);
			if(url.trim().startsWith("redirect:"))
				response.sendRedirect(url.trim().substring(9));
			else
				request.getRequestDispatcher(url).forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

}
