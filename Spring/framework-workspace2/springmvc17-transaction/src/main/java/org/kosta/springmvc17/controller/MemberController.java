package org.kosta.springmvc17.controller;

import javax.annotation.Resource;

import org.kosta.springmvc17.model.service.MemberService;
import org.kosta.springmvc17.model.vo.MemberVO;
import org.kosta.springmvc17.model.vo.PointVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Resource
	private MemberService service;
	
	@RequestMapping("home.do")
	public ModelAndView home(){
		return new ModelAndView("home");
	}
	@RequestMapping("findMemberById.do")
	public ModelAndView findMemberById(String id){
		return new ModelAndView("find_member_result","memberVO",service.findMemberById(id));
	}
	@RequestMapping("findPointById.do")
	public ModelAndView findPointById(String id){
		return new ModelAndView("find_point_result","pointVO",service.findPointById(id));
	}
	@RequestMapping(value="register.do",method=RequestMethod.POST)
	public ModelAndView register(MemberVO mvo,PointVO pvo){
		service.registerPoint(mvo, pvo);
		return new ModelAndView("register_result");
	}
}
