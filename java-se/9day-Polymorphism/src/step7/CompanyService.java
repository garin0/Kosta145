package step7;

public class CompanyService {

	public void calculateAnualIncome(Employee e) {
		int money = e.getSalary();
		if (e instanceof Engineer) {
			money += ((Engineer) e).getBonus();
		}
		System.out.println(money * 12);
	}

	public void caculateTotalCost(Employee[] empList) {
		int total = 0;
		for (int i = 0; i < empList.length; i++) {
			total += empList[i].getSalary();
			if (empList[i] instanceof Engineer) {
				total += ((Engineer) empList[i]).getBonus();
			}
		}
		System.out.println(total*12);
	}
}
