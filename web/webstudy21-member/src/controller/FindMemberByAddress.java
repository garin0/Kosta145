package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindMemberByAddress implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String address = request.getParameter("address");
		ArrayList<MemberVO> list = MemberDAO.getInstance().findMemberByAddress(address);
		String url = null;
		if(list.isEmpty()){
			url ="findMemberByAddress_fail.jsp";
		}else{
			request.setAttribute("list", list);
			url = "findMemberByAddress_ok.jsp";
		}
		return url;
	}

}
