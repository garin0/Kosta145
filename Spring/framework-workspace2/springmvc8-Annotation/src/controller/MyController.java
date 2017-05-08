package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import model.PersonVO;

@Controller
public class MyController {
	@RequestMapping("hello.do")
	public ModelAndView hello() {
		System.out.println("AnnotationController hello 실행");
		return new ModelAndView("result", "info", "데이터 공유");
	}

	@RequestMapping("bye.do")
	public String bye(Model model) {
		model.addAttribute("info", "데이터 공유~~");
		return "result";
	}

	/*
	 * @RequestMapping("getParam.do") public String getParam(HttpServletRequest
	 * request){ System.out.println(request.getParameter("id")); return
	 * "result"; }
	 */
	// 위와 동일한 표현
	@RequestMapping("getParam.do")
	public String getParam(String id, String name) {
		System.out.println(id + " " + name);
		return "result";
	}

	@RequestMapping("registerPerson.do")
	public String registerPerson(PersonVO vo) {
		System.out.println(vo);
		return "result";
	}

	// post 방식 요청시에만 동작한다.
	@RequestMapping(method = RequestMethod.POST, value = "login.do")
	public String login(String id, String password, HttpSession session) {
		System.out.println(id + " " + password);
		session.setAttribute("test", "세션테스트");
		return "result";
	}

	@RequestMapping("findContent.do")
	public String findContent() {
		return "result";
	}

	@RequestMapping("register.do")
	public String register(PersonVO pvo, HttpServletRequest request) {
		System.out.println(pvo);
		String m[] = request.getParameterValues("menu");
		for (int i = 0; i < m.length; i++)
			System.out.println(m[i]);
		return "result";
	}
	@RequestMapping("register2.do")
	public String register2(PersonVO vo){
		System.out.println(vo.getMenu());
		return "result";
	}
	/*
	 * Ajax JSON 응답하는 메서드 테스트
	 * 리턴하는 VO 객체를 자동으로 JSONObject로 만들어 응답하도록 설정
	 */
	@RequestMapping("testJSONObject.do")
	@ResponseBody
	public PersonVO testJSONObject(){
		PersonVO vo = new PersonVO();
		vo.setId("java");
		vo.setName("김문일");
		return vo;
	}
	@RequestMapping("testJSONArray.do")
	@ResponseBody
	public ArrayList<String> testJSONArray(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("김문일");
		list.add("김고은");
		list.add("공유");
		return list;
	}
}
