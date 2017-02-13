package step11;

public class TestArray4 {

	public static void main(String[] args) {
		//배열 요소 중 최소값을 구하기
		int[] point = {30,50,10,20,100};
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i <point.length;i++){
			if(min > point[i])
				min = point[i];
		}
		System.out.println("배열 요소 최소값: "+min);
	}

}
