package step5;

import java.io.File;

public class FileMgr {
	/*
	 * path에 해당하는 파일 경로와 동일한 디렉토리에 있는 파일들의 이름(확장자 제외) 을 출력한다(디렉토리 제외)
	 */
	public void printFileNameNoExt(String path) {

		// System.out.println(new File(path).exists());
		File[] fileList = new File(path).getParentFile().listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isFile()) {
				System.out.println(fileList[i].getName().substring(0, fileList[i].getName().lastIndexOf(".")));
			}
		}
	}

}
