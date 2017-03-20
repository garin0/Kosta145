package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmpDAO;
import model.EmpVO;

public class DetailEmpController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int idx = Integer.parseInt(request.getParameter("idx"));
		ArrayList<EmpVO> list = EmpDAO.getInstance().getDetailEmpList(idx);
		request.setAttribute("list", list);
		return "detail_emp.jsp";
	}

}
