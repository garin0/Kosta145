package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import model.MemberVO;

public class MemberController extends MultiActionController{
	public ModelAndView insert(HttpServletRequest request,HttpServletResponse response){
		System.out.println("insert 실행");
		return new ModelAndView("insert_result");
	}
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response){
		System.out.println("update 실행");
		return new ModelAndView("update_result");
	}
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response){
		System.out.println("register 실행");
		return new ModelAndView("insert_result");
	}
}
