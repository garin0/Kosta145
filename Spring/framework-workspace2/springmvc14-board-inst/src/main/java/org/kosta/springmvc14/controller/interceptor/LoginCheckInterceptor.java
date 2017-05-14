package org.kosta.springmvc14.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	// 핸들러(컨트롤러 메서드) 실행전에 수행된다
	// 아래 메서드의 리턴값이 true이면
	// 핸들러 메서드 수행되고
	// 리턴값이 false이면 핸들러 메서드 수행되지 않는다
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {		
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("mvo") == null) {// 로그인상태아니면 
			System.out.println("HandlerInterceptor 로그인 상태아님~~");
			response.sendRedirect("list.do");
			return false;
		}
		return true;
	}
}
