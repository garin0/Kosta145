package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;

public class UpdateCheckPasswordController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");
		String password = request.getParameter("password");
		boolean flag = BoardDAO.getInstance().checkPassword(Integer.parseInt(no), password);
		request.setAttribute("flag", flag);
		request.setAttribute("no",no);
		return "/board/update_checkpass_result.jsp";
	}

}
