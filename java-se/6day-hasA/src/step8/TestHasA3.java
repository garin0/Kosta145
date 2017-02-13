package step8;

public class TestHasA3 {

	public static void main(String[] args) {
		Hotel h = new Hotel("제2롯데호텔",new SweetRoom("101호",2000));
		System.out.println(h.getName());
		System.out.println(h.getSweetRoom().getNumber());
		System.out.println(h.getSweetRoom().getPrice());
	}

}
