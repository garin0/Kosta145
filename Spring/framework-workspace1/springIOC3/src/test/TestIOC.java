package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Person;

public class TestIOC {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("di.xml");
		Person person = (Person) factory.getBean("person");
		System.out.println(person.getName() + " " + person.getAge() + " " + person.getBat().getMaker() + " "
				+ person.getBat().getPrice());
		// 김성환 22 미즈노 10
		factory.close();
	}

}
