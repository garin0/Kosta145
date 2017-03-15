package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class WriteBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		BoardVO vo = new BoardVO(title,writer,password,content);
		String url = "index.jsp";
		int no;
		if(vo!=null){
			no = BoardDAO.getInstance().writeBoard(vo);
			url = "DispatcherServlet?command=showContent&no="+no;
			String flag = "write";
			request.setAttribute("flag", flag);
		}
		return url;
	}

}
