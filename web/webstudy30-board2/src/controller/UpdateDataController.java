package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class UpdateDataController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		int no = Integer.parseInt(request.getParameter("no"));
		String writer =request.getParameter("writer");
		String content = request.getParameter("content");
		BoardVO vo = new BoardVO(title,writer,content);
		BoardDAO.getInstance().updateData(vo,no);
		request.setAttribute("flag", "update");
		return "DispatcherServlet?command=showContent&no="+no;
	}

}
