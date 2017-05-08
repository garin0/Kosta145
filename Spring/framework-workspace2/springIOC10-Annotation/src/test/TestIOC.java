package test;

import org.kosta.controller.ProductController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("ioc.xml");
		// 어노테이션이 명시된 클래스를 이용해 스프링 컨테이너가 객체를 생성할 경우에는
		// 소문자로 시작하는 클래스명이 bean id로 설정된다.
		ProductController c = (ProductController)factory.getBean("productController");
		System.out.println(c.findProductById("java"));
		factory.close();
	}

}
