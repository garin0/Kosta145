package step2;

import java.io.File;

public class TestFile2 {

	public static void main(String[] args) {
		String dir ="C:\\java-kosta\\util\\eclipse-jee-mars-2-win32-x86_64\\eclipse";
		// �� dir ���丮�� �ִ� ���ϸ��� ����Ѵ� (���丮�� ����)
		File file = new File(dir);
		File[] list = file.listFiles();
		for(int i = 0; i < list.length ; i++){
			if(list[i].isFile()){
				System.out.println(list[i].getName());
			}
			
		}
		
	}

}
