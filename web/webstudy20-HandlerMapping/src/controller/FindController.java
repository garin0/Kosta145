package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

public class FindController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id =  request.getParameter("id");
		String result = MockDAO.getInstance().findById(id);
		String url = null;
		if(result == null){
			url = "find_fail.jsp";
		}else{
			url = "find_ok.jsp";
			request.setAttribute("result", result);
		}
		return url;
	}

}
