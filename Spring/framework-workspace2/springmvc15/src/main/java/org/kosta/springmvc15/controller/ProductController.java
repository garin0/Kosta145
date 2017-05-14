package org.kosta.springmvc15.controller;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.springmvc15.model.ProductService;
import org.kosta.springmvc15.model.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	@Resource
	private ProductService productService;
	
	@RequestMapping("home.do")
	public String home(){
		return "home";
	}
	@RequestMapping(value="registerProduct.do",method=RequestMethod.POST)
	public ModelAndView registerProduct(ProductVO vo){
		productService.registerProduct(vo);
		return new ModelAndView("redirect:findProductById.do?id="+vo.getId());
	}
	@RequestMapping("findProductById.do")
	public ModelAndView findProductById(String id){
		ProductVO productVO = productService.findProductById(id);
		return new ModelAndView("register_product_result", "productVO", productVO);
	}
	@RequestMapping("findProductListByName.do")
	public ModelAndView findProductListByName(String keyword){
		List<ProductVO> list = productService.findProductListByName(keyword);
		return new ModelAndView("product_list","list",list);
	}
	@RequestMapping("findProductListByMaker.do")
	public ModelAndView findProductListByMaker(String keyword){
		List<ProductVO> list = productService.findProductListByMaker(keyword);
		return new ModelAndView("product_list","list",list);
	}
	
}
