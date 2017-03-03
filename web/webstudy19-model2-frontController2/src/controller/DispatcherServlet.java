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
		requestProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		requestProcess(request, response);
	}
	/* FrontController인 DispatcherServlet 역할
	 * 1. Client 요청 분석 : 어떤 서비스를 원하는 가
	 * 2. 그 서비스를 담당하는 컨트롤러 객체 생성
	 * 3. 컨트롤러를 실행
	 * 4. 컨트롤러 실행 후 반환하는 값을 이용해 적절한 이동방식으로 View로 forward 또는 redirect
	 * 5. 모든 에러 및 예외는 콘솔에서만 출력되게 하고 사용자에게는 error.jsp로 응답하게 한다.
	 */
	public void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		Controller controller = null;
		String url = "error.jsp";
		
		if(command.equals("find")){
			controller = new FindController();
		}else if(command.equals("findByAddress")){
			controller = new FindByAddressController();
		}else if(command.equals("insert")){
			controller = new InsertController();
		}else if(command.equals("update")){
			controller = new UpdateController();
		}
		
		try {
			url = controller.execute(request, response);
			if(url.trim().startsWith("redirect:"))
				response.sendRedirect(url.trim().substring(9));
			else
				request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(url);
		}
	}
}
