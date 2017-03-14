package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class ShowContentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO vo = BoardDAO.getInstance().findBoardByNo(no);
		request.setAttribute("vo", vo);
		return "/board/show_content.jsp";
	
	}

}
