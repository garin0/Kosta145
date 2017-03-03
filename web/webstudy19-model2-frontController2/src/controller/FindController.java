package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

public class FindController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String result = MockDAO.getInstance().findById(request.getParameter("id"));
		if(result == null){
			return "find_fail.jsp";
		}else{
			request.setAttribute("result", result);
			return "find_ok.jsp";
		}
	}

}
