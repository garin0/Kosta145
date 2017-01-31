package step3;

import step2.Fighter;
import step2.Flyer;

public class FlyerService {
	private int index = 0;
	Flyer[] fList;

	public FlyerService(int size) {
		fList = new Flyer[size];
	}

	public void addFlyer(Flyer f) {
		fList[index++] = f;
	}

	public void executeFlyerAll() {
		for (int i = 0; i < index; i++) {
			fList[i].fly();
		}
	}

	public void executeFighterAll() {
		for (int i = 0; i < index; i++) {
			if(fList[i] instanceof Fighter){
				((Fighter) fList[i]).fight();
			}
		}
		
	}

}
