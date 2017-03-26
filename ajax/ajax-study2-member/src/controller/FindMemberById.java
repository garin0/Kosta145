package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindMemberById implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		MemberVO result = MemberDAO.getInstance().findMemberById(id);
		String url = null;
		if(result == null){
			url = "findMemberById_fail.jsp";
		}else{
			request.setAttribute("result", result);
			url="findMemberById_ok.jsp";
		}
		return url;
	}

}
