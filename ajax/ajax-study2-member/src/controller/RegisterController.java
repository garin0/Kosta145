package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class RegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		String id= request.getParameter("id");
		String password = request.getParameter("password");
		String name =request.getParameter("name");
		String address = request.getParameter("address");
		MemberVO vo = new MemberVO(id, password, name, address);
		MemberDAO.getInstance().register(vo);
		session.setAttribute("memberVO", vo);
		return "register_ok.jsp";
	}

}
