package controller;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.CompanyDAO;

public class EmpAndDeptController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String empNo = request.getParameter("empno");
		HashMap<String, String> map  = CompanyDAO.getInstance().getEmpAndDeptInfo(empNo);
		JSONObject json = new JSONObject(map);
		System.out.println(json.toString());
		out.print(json.toString());
		return "AjaxView";
	}

}
