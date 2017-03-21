package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardVO;
import model.MemberVO;

public class WriteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		BoardVO bvo = new BoardVO(title,content,mvo.getId());
		String url = "index.jsp";
		int no;
		if(bvo!=null){
			no = BoardDAO.getInstance().writeBoard(bvo);
			url = "redirect:DispatcherServlet?command=showContent&no="+no;
			request.setAttribute("flag", "write");
			System.out.println("글쓰기 완료");
		}
		return url;
	}

}
