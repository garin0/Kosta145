package test;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.ExDAO;

//dbcp DI Test 예제
public class TestIOC {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("ioc.xml");
		ExDAO dao = (ExDAO)factory.getBean("exDAO");
		try {
			dao.find();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		factory.close();
	}

}
