package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;

public class DeletePostingController implements Controller {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String no=request.getParameter("no");
		BoardDAO.getInstance().deletePosting(Integer.parseInt(no));
		// 게시물 목록을 보여주기 위해
		// path를 DispatcherServlet?command=list setting하고
		// 리다이렉트 방식으로 이동시킨다. 
		return "redirect:index.jsp";
	}

}






