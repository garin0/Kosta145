package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

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
	public void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// client가 어떤 서비스를 원하는 지 분석한다.
		String command = request.getParameter("command");
		String url = null;
		boolean isRedirect = false;
		if(command.equals("find")){
			/* client가 보낸 id를 받는다.
			 * Model(MockDAO)의 findbyid 메서드를 이용해 조회한다.
			 * 조회결과가 null이면 find_fail.jsp로
			 * null이 아니면 find_ok.jsp로 forward되도록 한다.
			 */
			String id = request.getParameter("id");
			String result = MockDAO.getInstance().findById(id);
			if(result == null){
				url ="find_fail.jsp";
			}else{
				request.setAttribute("result", result);
				url ="find_ok.jsp";
			}
		}else if(command.equals("insert")){
			String name = request.getParameter("name");
			String address= request.getParameter("address");
			MockDAO.getInstance().insert(name, address);
			url = "insert_result.jsp";
			isRedirect = true;
		}else if(command.equals("findByAddress")){
			String address = request.getParameter("address");
			ArrayList<String> list = MockDAO.getInstance().findByAddress(address);
			if(!list.isEmpty()){
				url = "findbyaddress_ok.jsp";
				request.setAttribute("list", list);
			}else{
				url = "findbyaddress_fail.jsp";
			}
		}else if(command.equals("update")){
			String nick = request.getParameter("nick");
			MockDAO.getInstance().updateNick(nick);
			url = "update_result.jsp";
			isRedirect = true;
		}
		if(isRedirect){
			response.sendRedirect(url);
		}else{
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
