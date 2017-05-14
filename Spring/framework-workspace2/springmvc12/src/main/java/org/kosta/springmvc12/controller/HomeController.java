package org.kosta.springmvc12.controller;

import javax.annotation.Resource;

import org.kosta.springmvc12.model.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Resource
	private CarService carService;

	@RequestMapping("home.do")
	public String home(Model model) {
		model.addAttribute("totalCount", carService.getTotalCount());
		return "home";
	}
	@RequestMapping("carList.do")
	public String getCarList(Model model){
		model.addAttribute("carList",carService.getCarList());
		return "carList";
	}

}
