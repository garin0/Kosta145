package org.kosta.springmvc14;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.springmvc14.model.BoardService;
import org.kosta.springmvc14.model.MemberService;
import org.kosta.springmvc14.model.MemberVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-*.xml" })
public class TestUnit {

	@Resource
	private MemberService service;
	@Resource
	private BoardService bservice;

	@Test
	public void test() {
		System.out.println(service.login(new MemberVO("java", "1234")));
		System.out.println(bservice.getTotalContent());
		System.out.println(bservice.showContent(5));
	}
}
