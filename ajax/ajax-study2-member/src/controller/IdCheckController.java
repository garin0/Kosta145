package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

public class IdCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		boolean flag = MemberDAO.getInstance().idCheck(id);
		if(flag==false){
			return "idcheck_ok.jsp";
		}else{
			return "idcheck_fail.jsp";
		}
	}

}
