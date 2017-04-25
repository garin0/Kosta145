package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("HelloController 실행");
		// view name을 할당
		// dispatcher-sevlet에서 설정한 ViewResolver에 의해
		// /view/ok.jsp 로 응답한다.
		// return new ModelAndView("ok");
		/*ModelAndView mv = new ModelAndView(); 
		mv.setViewName("ok");//응답할 view 정보를 할당
		// 아래 코드는 request.setAttribute("info","그대라는 사치");를 의미
		mv.addObject("info", "그대라는 사치");
		return mv;*/
		return new ModelAndView("ok","info","그대라는 사치");
	}
}
