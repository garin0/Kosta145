package org.kosta.springmvc18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("home.do")
	public String home() {
		// System.out.println("tiles view 응답");
		// tilesbase는 tiles-config.xml의 definition name이다.
		// tiles conifg의 definition name을 반환하면 tiles viewResolver 방식으로 응답한다.
		return "tilesbase";
	}

	@RequestMapping("test.do")
	public String test() {
		// tiles config의 definition name이 아니므로 viewResolver order에 따라
		// InternalResourceViewResolver 방식으로 응답된다.
		// /WEB-INF/views/test.jsp 
		return "test";
	}
	
/*	@RequestMapping("home2")
	public String home2(){
		return "home2";
	}
	@RequestMapping("home3")
	public String home3(){
		return "home3";
	}
	@RequestMapping("home4")
	public String home4(){
		return "home4";
	}*/
	
	/*
	 * @PathVariable 어노테이션3
	 * : 요청 url 정보를 변수로 할당받기 위한 어노테이션
	 * 요청 url과 일치하는 url 매핑 메서드가 존재하면 그 메서드가
	 * 우선적으로 실행되고 
	 * 존재하지 않으면 @PathVariable 메서드가 실행된다.
	 */
	@RequestMapping("{viewName}.do") 
	public String showView(@PathVariable String viewName){
		System.out.println("@PathVariable:"+viewName);
		return viewName;
	}
	
	@RequestMapping("{dirName}/{viewName}.do") 
	public String showView(@PathVariable String dirName,@PathVariable String viewName){
		System.out.println("@PathVariable:"+dirName+"/"+viewName);
		return dirName+"/"+viewName;
	}
}
