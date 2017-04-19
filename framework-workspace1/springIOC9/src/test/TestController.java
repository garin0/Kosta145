package test;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.ItemService;

public class TestController {

	public static void main(String[] args) {
		/*
		 * ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("ioc.xml");
		 * ItemService service = (ItemServlce)factory.getBean("itemService");
		 * Map map = service.getListAndAvgPriceInfo("삼성");
		 * System.out.println(map.get("list");//삼성 제품 리스트
		 * System.out.println(map.get("avgPriceInfo"); //200
		 */
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("ioc.xml");
		ItemService service = (ItemService) factory.getBean("itemService");
		try {
			Map<String, Object> map = service.getListAndAvgPriceInfo("삼성");
			System.out.println(map.get("list"));
			System.out.println(map.get("avgPriceInfo"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		factory.close();
	}

}
