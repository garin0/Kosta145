package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductDAO;
import model.ProductVO;

public class DetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		ProductVO vo = ProductDAO.getInstance().findProductByNo(no);
		if(vo!=null){
			request.setAttribute("vo", vo);
		}
		return "detail_product.jsp";
	}

}
