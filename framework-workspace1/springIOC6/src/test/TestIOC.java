package test;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Bus;
import model.School;

public class TestIOC {

	public static void main(String[] args) {
		//spring Container를 생성
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("ioc.xml");
		School s = (School) factory.getBean("school");
		ArrayList<String> list = s.getStudentNameList();
		for(String name:list)
			System.out.println(name);
		ArrayList<Bus> busList = s.getBusList();
		for(Bus b:busList)
			System.out.println(b);
		HashMap<String, Bus> map = s.getBusMap();
		System.out.println(map.get("busOne"));
		System.out.println(map.get("busTwo"));
		factory.close();
	}

}
