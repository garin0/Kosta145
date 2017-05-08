package controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import model.ProductDAO;
import model.ProductVO;

public class ProductController extends MultiActionController{
	private ProductDAO productDAO;
	public ProductController(ProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response,ProductVO vo){
		if(vo == null){
			return new ModelAndView("register_fail");
		}else{
			productDAO.register(vo);
			System.out.println(vo.getId());
			return new ModelAndView("redirect:product.do?command=find&id="+vo.getId(),"vo",vo);
		}
	}
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response){
		String input = request.getParameter("input");
		String select =request.getParameter("select");
		
		if(select.equals("maker")){
			List<ProductVO> list  = productDAO.searchByMaker(input);
			return new ModelAndView("search_result","list",list);
		}else{
			List<ProductVO> list  = productDAO.searchByName(input);
			return new ModelAndView("search_result","list",list);
		}
	}
	public ModelAndView find(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		System.out.println(id);
		ProductVO vo= productDAO.searchById(id);
		return new ModelAndView("register_result","vo",vo);
	}
}
