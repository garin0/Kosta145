package controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.CompanyDAO;

public class EmpNoListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		ArrayList<String> list = null;
		PrintWriter out=response.getWriter();
		list = CompanyDAO.getInstance().getEmpNoList();
		JSONObject obj = new JSONObject();
		obj.put("list", list);
		System.out.println(obj.toString());
		out.print(obj.toString());
		return "employee.jsp";
	}

}
