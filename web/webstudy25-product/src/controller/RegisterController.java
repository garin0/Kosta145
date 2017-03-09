package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductDAO;
import model.ProductVO;

public class RegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name= request.getParameter("name");
		String maker=request.getParameter("maker");
		int price = Integer.parseInt(request.getParameter("price"));
		ProductVO vo = new ProductVO(name, maker, price);
		ProductDAO.getInstance().registerProduct(vo);
		return "DispatcherServlet?command=list";
	}

}
