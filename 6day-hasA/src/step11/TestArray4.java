package step11;

public class TestArray4 {

	public static void main(String[] args) {
		//�迭 ��� �� �ּҰ��� ���ϱ�
		int[] point = {30,50,10,20,100};
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i <point.length;i++){
			if(min > point[i])
				min = point[i];
		}
		System.out.println("�迭 ��� �ּҰ�: "+min);
	}

}
