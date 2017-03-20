package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;

public class DeleteCheckPasswordController implements Controller {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws NumberFormatException,
			SQLException {
		String no = request.getParameter("no");
		String password = request.getParameter("password");
		boolean flag = BoardDAO.getInstance().checkPassword(Integer.parseInt(no), password);
		request.setAttribute("flag", flag);
		return "/board/delete_checkpass_result.jsp";
	}
}





