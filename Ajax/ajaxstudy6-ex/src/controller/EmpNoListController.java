package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CompanyDAO;

public class EmpNoListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		ArrayList<String> list = null;
		list = CompanyDAO.getInstance().getEmpNoList();
		request.setAttribute("list", list);
		return "employee.jsp";
	}

}
