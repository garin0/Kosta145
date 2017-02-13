package step3;

import java.io.File;

public class FileService {

	/*
	 * 매개변수에 전달된 filePath의 파일과 동일한 위치의 파일(디렉토리 및 자신을 제외) 명을 출력하는 메서드
	 */
	public void printfilePath(String filePath) {

		File file = new File(filePath).getParentFile();
		int pos = filePath.lastIndexOf("\\");
		String sub = filePath.substring(pos + 1);
		File[] list = file.listFiles();

		for (int i = 0; i < list.length; i++) {
			if(list[i].isFile() && filePath.equals(list[i].getPath())== false){
//			if (list[i].isFile() && !list[i].getName().equals(sub)) {
				System.out.println(list[i].getName());
			}

		}
	}

}
