package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import model.CustomerDAO;
import model.CustomerVO;

public class CustomerController extends MultiActionController{
	private CustomerDAO customerDAO;

	public CustomerController(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}
	/*
	 * findCustomerById()
	 * ->views/find_ok.jsp 검색결과
	 * ->views/find_fail.jsp 고객이 존재하지 않습니다.
	 */
	public ModelAndView findCustomerById(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		
		CustomerVO vo = customerDAO.findCustomerById(id);
		if(vo==null){
			return new ModelAndView("find_fail");
		}else{
			return new ModelAndView("find_ok","vo",vo);
		}
		
	}
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response,CustomerVO vo){
		customerDAO.register(vo);
		return new ModelAndView("register_result");
		
	}
	public ModelAndView getAllCutomerList(HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("list","culist",customerDAO.getAllCutomerList());
	}
}
