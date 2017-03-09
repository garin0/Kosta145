package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductDAO;
import model.ProductVO;

public class ListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ProductVO> list = ProductDAO.getInstance().getAllProductList();
		String url = null;
		if(!list.isEmpty()){
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			url = "redirect:list_product.jsp";
		}else{
			url = "error.jsp";
		}
		return url;
	}

}
