package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 클라이언트 요청 분석
		 * 모델 연동
		 * 적절한 view로 이동(이동 방식은 redirect 로 한다)
		 */
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String address= request.getParameter("address");
		MockDAO.getInstance().insert(name, address);
		response.sendRedirect("insert_result.jsp");
		// redirect와 forward 이동방식을 비교
//		request.getRequestDispatcher("insert_result.jsp").forward(request, response);
	}

}
