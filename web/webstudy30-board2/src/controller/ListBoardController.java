package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class ListBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<BoardVO> list = BoardDAO.getInstance().getAllBoardList();
		request.setAttribute("list", list);
		return "/board/list.jsp";
	}

}
