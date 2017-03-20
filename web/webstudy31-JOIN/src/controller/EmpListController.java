package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmpDAO;
import model.EmpVO;

public class EmpListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<EmpVO> list=null;
		list = EmpDAO.getInstance().getAllEmpList();
		request.setAttribute("list", list);
		return "list.jsp";
	}

}
