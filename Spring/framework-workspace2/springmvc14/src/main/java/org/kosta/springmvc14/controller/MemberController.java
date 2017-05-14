package org.kosta.springmvc14.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.springmvc14.model.MemberService;
import org.kosta.springmvc14.model.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@Resource
	private MemberService memberService;
	
	@RequestMapping("login.do")
	public String login(MemberVO memberVO,HttpServletRequest request){
		MemberVO vo=memberService.login(memberVO);
		if(vo==null){
			return "member/login_result";
		}else{
			request.getSession().setAttribute("mvo", vo);
			return "redirect:index.do";
		}	
	}
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request){
		HttpSession session=request.getSession(false);
		if(session!=null)
			session.invalidate();
		return "redirect:index.do";		
	}
}
