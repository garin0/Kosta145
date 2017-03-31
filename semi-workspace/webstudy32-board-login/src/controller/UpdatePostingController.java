package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;
import model.MemberVO;

public class UpdatePostingController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no=Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		MemberVO mvo = (MemberVO) request.getSession().getAttribute("mvo");
		String url ="index.jsp";
		if(mvo==null){
			return url;
		}else{
			BoardVO vo=new BoardVO();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			request.setAttribute("flag", "update");
			BoardDAO.getInstance().updatePosting(vo);			
			url="redirect:DispatcherServlet?command=showContent&no="+vo.getNo();
		}
		return url;
	}

}
