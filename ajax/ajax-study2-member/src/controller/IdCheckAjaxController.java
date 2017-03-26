package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

public class IdCheckAjaxController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		System.out.println("IdCheckAjaxController");
		String message = null;
		boolean flag = MemberDAO.getInstance().idCheck(request.getParameter("id"));
		if(flag==true){
			message = "아이디가 존재합니다";
		}else{
			message ="아이디가 존재하지 않습니다.";
		}
		out.println(message);
		out.close();
		return "AjaxView";
	}

}
