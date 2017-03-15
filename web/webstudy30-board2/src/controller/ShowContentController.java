package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class ShowContentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO vo = null;
		String flag = (String) request.getAttribute("flag");
		if(flag == null){
			BoardDAO.getInstance().updateHit(no);
			vo = BoardDAO.getInstance().findBoardByNo(no);
		}else{
			System.out.println(flag);
			vo = BoardDAO.getInstance().findBoardByNo(no);
		}
		request.setAttribute("vo", vo);
		request.setAttribute("no", no);
		return "/board/show_content.jsp";
	
	}

}
