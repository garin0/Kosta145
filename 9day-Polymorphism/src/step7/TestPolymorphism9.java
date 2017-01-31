package step7;

public class TestPolymorphism9 {

	public static void main(String[] args) {
		CompanyService service = new CompanyService();
		/*
		 * service.calculateAnualIncome(new Employee("배수지", 200));
		 * service.calculateAnualIncome(new Engineer("강동원", 500, 100));
		 */
		/*
		 * 2400 7200
		 */
		Employee empList[] = new Employee[3];
		empList[0] = new Employee("김태희", 200);
		empList[1] = new Employee("배수지", 400);
		empList[2] = new Engineer("유재석", 500,100);
		service.caculateTotalCost(empList); //14400
	}

}
