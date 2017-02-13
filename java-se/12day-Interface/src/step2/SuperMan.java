package step2;

public class SuperMan extends ET implements Flyer, Fighter {

	@Override
	public void fight() {
		System.out.println("½´ÆÛ¸ÇÀÌ ¾Ç´ç°ú ½Î¿ì´Ù.");
	}

	@Override
	public void fly() {
		System.out.println("½´ÆÛ¸ÇÀÌ ³¯´Ù.");
	}

}
