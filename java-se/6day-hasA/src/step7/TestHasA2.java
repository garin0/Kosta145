package step7;

public class TestHasA2 {

	public static void main(String[] args) {
		Car  c = new Car("�ҳ�Ÿ",new Engine("GDI",2500));
		System.out.println(c.getModel()); //�ҳ�Ÿ
		System.out.println(c.getEngine().getType());
		System.out.println(c.getEngine().getDisplacement());
		c.getEngine().setType("Hybrid");
		System.out.println(c.getEngine().getType()); //Hybrid
	}

}
