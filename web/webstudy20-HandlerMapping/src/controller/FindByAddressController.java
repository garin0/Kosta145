package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

public class FindByAddressController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<String> list = MockDAO.getInstance().findByAddress(request.getParameter("address"));
		String url = null;
		if(list.isEmpty()){
			url =  "findbyaddress_fail.jsp";
		}else{
			request.setAttribute("list", list);
			url = "findbyaddress_ok.jsp";
		}
		return url;
	}

}
