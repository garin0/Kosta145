package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.BoardService;

public class TestController {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("ioc.xml");
		BoardService boardService = (BoardService) factory.getBean("boardService");
		String result = boardService.getContentByNo("1");
		System.out.println(result);
		factory.close();
	}

}
