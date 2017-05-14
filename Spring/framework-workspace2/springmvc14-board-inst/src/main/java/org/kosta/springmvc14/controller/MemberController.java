package org.kosta.springmvc14.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.springmvc14.model.MemberService;
import org.kosta.springmvc14.model.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@Resource
	private MemberService memberService;	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request, MemberVO vo) {		
		MemberVO rvo = memberService.login(vo);
		if (rvo != null) {
			request.getSession().setAttribute("mvo", rvo);			
		}
		return "member/login_result";
	}	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		return "redirect:list.do";
	}	
}





