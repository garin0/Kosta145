package org.kosta.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.model.MemberService;
import org.kosta.model.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	@Resource
	private MemberService memberService;
	
	@RequestMapping("findMemberById.do")
	public String findMemberById(String id,Model model){
		MemberVO vo = memberService.findMemberById(id);
		if(vo!=null){
			model.addAttribute("info",vo);
			return  "findMemberById_ok";
		}else{
			return "findMemberById_fail";
		}
	}
	@RequestMapping("getAddressKind.do")
	public String getAddressKind(Model model){
		List<String> list = memberService.getAddressKind();
		model.addAttribute("list", list);
		return "address";
	}
	@RequestMapping("findMemberByAddress.do")
	@ResponseBody
	public List<MemberVO> findMemberByAddress(String address){
		List<MemberVO> list = memberService.findMemberByAddress(address);
		return list;
	}
	@RequestMapping(value="login.do",method = RequestMethod.POST)
	public String login(String id,String password,HttpServletRequest request,Model model){
		MemberVO vo = memberService.login(id, password);
		int count = memberService.countMember();
		model.addAttribute("count", count);
		if(vo!=null){
			request.getSession().setAttribute("info", vo);
		}else{
			return "login_fail";
		}
		return "index";
		
	}
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request,Model model){
		HttpSession session = request.getSession();
		int count = memberService.countMember();
		model.addAttribute("count", count);
		if(session!=null)
			session.invalidate();
		return "index";
	}
	@RequestMapping("index.do")
	public String home(Model model){
		int count = memberService.countMember();
		model.addAttribute("count", count);
		return "index";
	}
	@RequestMapping("enterCafe.do")
	public String enterCafe(){
		return "cafe";
	}
	@RequestMapping("updateView")
	public String updateView(HttpServletRequest request){
		return "update";
	}
	
	@RequestMapping("updateMember.do")
	public String updateMember(MemberVO vo,HttpServletRequest request){
		request.getSession().getAttribute("vo");
		memberService.updateMember(vo);
		request.getSession().setAttribute("info", vo);
		return "update_result";
	}
	@RequestMapping("joinView.do")
	public String joinView(){
		return "join";
	}
	@RequestMapping("idCheck.do")
	@ResponseBody
	public String idCheck(String id){
		if(memberService.idCheck(id)==0){
			return "true";
		}else{
			return "false";
		}
	}
	@RequestMapping("join.do")
	public String join(MemberVO vo,Model model){
		System.out.println(vo);
		memberService.join(vo);
		model.addAttribute("mvo", vo);
		return "join_ok";
	}
}
