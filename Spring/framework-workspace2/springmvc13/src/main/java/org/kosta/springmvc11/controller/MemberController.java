package org.kosta.springmvc11.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.springmvc11.model.MemberService;
import org.kosta.springmvc11.model.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Resource
	private MemberService memberService;
	@RequestMapping("findMemberById.do")
	public String findMemberById(String id,Model model){
		MemberVO vo=memberService.findMemberById(id);
		if(vo==null)
			return "findMemberById_fail";
		else{
			model.addAttribute("vo", vo);
			return "findMemberById_ok";
		}			
	}
	@RequestMapping("getAddressKind.do")
	public ModelAndView getAddressKind(){
		return new ModelAndView("address",
				"addrList",memberService.getAddressKind());
	}
	@RequestMapping("findMemberListByAddress.do")
	@ResponseBody
	public List<MemberVO> findMemberListByAddress(String address){
		return memberService.findMemberListByAddress(address);
	}
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public String login(MemberVO memberVO,HttpServletRequest request){
		MemberVO vo=memberService.login(memberVO);
		if(vo==null){
			return "login_fail";
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
	@RequestMapping("index.do")
	public String home(Model model){
		System.out.println("home 실행");
		model.addAttribute("memberCount", memberService.getMemberCount());
		return "index";
	}
	// 카페에는 로그인한 사용자만 서비스 받을 수 있다.
	// HandlerInterceptor에서 공통으로 처리한다.
	@RequestMapping("member_enterCafe.do")
	public String enterCafe(HttpServletRequest request){
		//HttpSession session = request.getSession(false);
		// 인증받은 사람만 들어올 수 있게 수정.
		//if(session!=null&&session.getAttribute("mvo")!=null){
			return "cafe";
		//}else{
		//	return "redirect:index.do";
		//}
	}
	// 회원정보 수정 폼 페이지 서비스는 로그인한 사용자만 진입이 가능해야 한다.
	// HandlerInterceptor에서 공통으로 처리한다.
	@RequestMapping("member_updateView.do")
	public String updateView(HttpServletRequest request){		
			/*HttpSession session=request.getSession(false);
			if(session!=null&&session.getAttribute("mvo")!=null){	*/			
				return "update";
			/*}else{
				return "redirect:index.do";
			}	*/
	}
	// 회원정보 수정은 로그인한 사용자만 가능하다.
	// HandlerInterceptor에서 공통으로 처리한다.
	@RequestMapping(value="member_updateMember.do",method=RequestMethod.POST)
	public String updateMember(HttpServletRequest request,MemberVO memberVO){		
			HttpSession session=request.getSession(false);
			//if(session!=null&&session.getAttribute("mvo")!=null){	
				session.setAttribute("mvo", memberVO);
				memberService.updateMember(memberVO);
				return "update_result";
			//}else{
			//	return "redirect:index.do";
			//}	
	}
	@RequestMapping("registerForm.do")
	public String registerForm(){
		return "register";
	}
	@RequestMapping(value="registerMember.do", method = RequestMethod.POST)
	public String register(MemberVO vo) {
		memberService.registerMember(vo);		
		return "redirect:registerResultView.do?id=" + vo.getId();
	}
	@RequestMapping("registerResultView.do")
	public ModelAndView registerResultView(String id) {		
		MemberVO vo = memberService.findMemberById(id);
		return new ModelAndView("register_result", "memberVO", vo);
	}
	@RequestMapping("idcheckAjax.do")
	@ResponseBody
	public String idcheckAjax(String id) {		
		int count=memberService.idcheck(id);
		return (count==0) ? "ok":"fail"; 		
	}

}
















