package step7.test;

import step7.model.PizzaService;
import step7.model.PotatoPizzaService;
import step7.model.SeaFoodPizzaService;

public class TestTemplateMethodPattern {

	public static void main(String[] args) {
		PizzaService[] service = { new SeaFoodPizzaService(), new PotatoPizzaService() };
		for (int i = 0; i < service.length; i++) {
			 service[i].makePizza();
			
		}
	}

}
