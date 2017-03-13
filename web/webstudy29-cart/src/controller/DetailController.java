package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemDAO;
import model.ItemVO;

public class DetailController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");
		ItemVO vo = ItemDAO.getInstance().findItemByNo(no);
		if(vo!=null){
			request.setAttribute("vo", vo);
		}
		return "item_detail.jsp";
	}

}
