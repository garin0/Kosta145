package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String url = null;
		MemberVO vo = MemberDAO.getInstance().loginMember(id, password);
		if(vo!=null){
			HttpSession session = request.getSession();
			session.setAttribute("mvo", vo);
			url="redirect:index.jsp";
		}else{
			url="redirect:member/login_result.jsp";
		}
		return url;
	}

}
