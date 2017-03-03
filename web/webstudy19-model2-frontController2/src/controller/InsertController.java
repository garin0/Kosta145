package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

public class InsertController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String address= request.getParameter("address");
		MockDAO.getInstance().insert(name, address);
		return "redirect:insert_result.jsp";
	}
}
