package step2;

import java.io.File;

public class TestFile2 {

	public static void main(String[] args) {
		String dir ="C:\\java-kosta\\util\\eclipse-jee-mars-2-win32-x86_64\\eclipse";
		// 위 dir 디렉토리에 있는 파일명을 출력한다 (디렉토리는 제외)
		File file = new File(dir);
		File[] list = file.listFiles();
		for(int i = 0; i < list.length ; i++){
			if(list[i].isFile()){
				System.out.println(list[i].getName());
			}
			
		}
		
	}

}
