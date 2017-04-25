package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import model.MemberService;

public class FindMemberController extends AbstractController{
	private MemberService memberService;
	public FindMemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
		System.out.println(getClass().getName()+" 생성자로 "+memberService+" 주입받음");
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("memberId");
		String info = memberService.findMemberById(id);
		if(info !=null){
			return new ModelAndView("find_ok","info",info);
		}else{
			return new ModelAndView("find_fail");
		}
	}

}
