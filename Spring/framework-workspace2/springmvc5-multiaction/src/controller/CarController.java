package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import model.CarDTO;
import model.CarService;

public class CarController extends MultiActionController{
	private CarService carService;
	public CarController(CarService carService) {
		super();
		this.carService = carService;
	}
	public ModelAndView findCar(HttpServletRequest request,HttpServletResponse response){
		CarDTO dto = carService.findCarDTO();
		return new ModelAndView("find_result","carDTO",dto);
	}
}
