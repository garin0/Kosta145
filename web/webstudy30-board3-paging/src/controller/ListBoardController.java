package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;
import model.ListVO;
import model.PagingBean;

public class ListBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		int total = BoardDAO.getInstance().getTotalContent();
		int pageNO = Integer.parseInt(request.getParameter("page"));
		PagingBean pb = null;
		if(pageNO!=0){
			pb = new PagingBean(total,pageNO);
		}else{
			pb = new PagingBean(total);
		}
		ArrayList<BoardVO> list=null;
		list = BoardDAO.getInstance().getAllBoardList(pb);
		ListVO vo  = new ListVO(list, pb);
		request.setAttribute("listVO", vo);
		return "/board/list.jsp";
	}

}
