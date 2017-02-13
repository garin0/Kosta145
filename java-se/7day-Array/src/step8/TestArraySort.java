package step8;

public class TestArraySort {

	public static void main(String[] args) {
		int[] point = { 4, 2, 3, 1, 6, 5 };
		int temp = 0;
		printArray(point);
		System.out.println("**오름차순 정렬**");
		// 배열 오름차순 정렬
		for (int i = 0; i < point.length; i++) {
			for (int j = i + 1; j < point.length; j++) {
				if (point[i] > point[j]) {
					temp = point[i];
					point[i] = point[j];
					point[j] = temp;
					// printArray(point);
				}
			}
		}
		printArray(point);
	}

	public static void printArray(int[] point) {
		for (int i = 0; i < point.length; i++) {
			System.out.print(point[i] + " ");
		}
		System.out.println();
	}

}
