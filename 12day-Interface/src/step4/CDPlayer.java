package step4;

public class CDPlayer implements Player {
	@Override
	public void play() {
		System.out.println("CD플레이어가 CD 재생하다");
	}

	public void insertCD() {
		System.out.println("CD플레이어에 CD를 넣다");
	}
}
