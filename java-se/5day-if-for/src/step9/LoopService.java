package step9;

public class LoopService {

	public void printInfo(String name, int count) {
		for(int i = 1 ; i <= count ; i++){
			System.out.println(name + " " +i+"��");
		}
	}

	public void printInfoLimit(String item, int count, int limit) {
		for(int i = 1 ; i <= count ; i++){
			System.out.println(item +" "+ i + "��");
			if(limit == i){
			 break;
			}
		}
	}

}
