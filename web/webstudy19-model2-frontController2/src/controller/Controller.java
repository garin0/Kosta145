package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 모든 컨트롤러 업무를 처리하는 클래스들이
 * 구현해야 하는 인터페이스
 * -> DispatcherServlet과 모든 컨트롤러들이
 * 	단일한 메세지 방식으로 소통하기 위해 표준화하는 인터페이스
 */
public interface Controller {
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
