package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindMemberByIdAjax implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		MemberVO vo = MemberDAO.getInstance().findMemberById(request.getParameter("id"));
		if(vo==null){
			out.println("회원정보가 존재하지 않습니다.");
		}else{
			out.println(vo.toString());
		}
		out.close();
		return "AjaxView";
	}

}
