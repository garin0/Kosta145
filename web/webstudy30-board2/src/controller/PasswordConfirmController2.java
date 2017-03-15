package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;

public class PasswordConfirmController2 implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String password = request.getParameter("password");
		int no = (int) request.getSession().getAttribute("no");
		int result = BoardDAO.getInstance().countBoard(no, password);
		String url = null;
		request.getSession().setAttribute("password", password);
		if(result!=0){
			url = "board/pw_ok_delete.jsp";
		}else{
			url = "board/delete_fail.jsp";
		}
		return url;
	}

}
