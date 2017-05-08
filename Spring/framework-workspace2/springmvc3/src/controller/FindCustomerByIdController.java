package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import model.CustomerService;

public class FindCustomerByIdController extends AbstractController{
	private CustomerService customerService;
	
	public FindCustomerByIdController(CustomerService customerService) {
		super();
		this.customerService = customerService;
		System.out.println("FindCustomerByIdController");
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("customerId");
		String result = customerService.findCustomerById(id);
		if(result !=null){
			return new ModelAndView("find_ok","result",result);
		}else{
			return new ModelAndView("find_fail");
		}
	}

}
