package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;


public class DeleteDataController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String password = (String) request.getSession().getAttribute("password");
		int no = (int) request.getSession().getAttribute("no");
		int result = BoardDAO.getInstance().countBoard(no, password);
		String url = null;
		if(result!=0){
			BoardDAO.getInstance().deleteData(no, password);
			url = "board/delete_ok.jsp";
		}else{
			url = "board/delete_fail.jsp";
		}
		return url;
	}

}
