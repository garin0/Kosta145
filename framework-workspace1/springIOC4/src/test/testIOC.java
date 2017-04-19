package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Customer;

public class testIOC {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("ioc.xml");
		Customer c  =(Customer) factory.getBean("customer");
		System.out.println(c.getName()); //김성환
		System.out.println(c.getCar().getModel());//봉고
		System.out.println(c.getCar().getPrice()); //100
		factory.close();
	}

}
