package org.kosta.controller;

import javax.annotation.Resource;

import org.kosta.model.CustomerDAO;
import org.kosta.model.CustomerVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	@Resource
	private CustomerDAO customerDAO;

	@RequestMapping("findCustomerById.do")
	public ModelAndView findCustomerById(String id) {
		CustomerVO vo = customerDAO.findCustomerById(id);
		System.out.println(vo);
		if (vo != null) {
			return new ModelAndView("find_ok", "info", vo);
		} else {
			return new ModelAndView("find_fail", "id", id);
		}

	}
}
