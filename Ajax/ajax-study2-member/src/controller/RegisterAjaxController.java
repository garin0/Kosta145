package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

public class RegisterAjaxController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String id = request.getParameter("id");
		boolean flag = MemberDAO.getInstance().idCheck(id);
		out.print(flag);
		out.close();
		return "AjaxView";
	}

}
