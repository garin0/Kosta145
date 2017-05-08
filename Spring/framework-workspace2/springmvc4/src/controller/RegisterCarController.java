package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import model.CarDTO;
import model.CarService;

public class RegisterCarController extends AbstractController{
	private CarService carService;
	
	public RegisterCarController(CarService carService) {
		super();
		this.carService = carService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String model = request.getParameter("model");
		String price= request.getParameter("price");
		CarDTO dto = new CarDTO(model, Integer.parseInt(price));
		carService.register(dto);
		return new ModelAndView("register_result","carDTO",dto);
	}

}
