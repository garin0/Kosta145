package step5;

import java.io.File;

public class FileMgr {
	/*
	 * path�� �ش��ϴ� ���� ��ο� ������ ���丮�� �ִ� ���ϵ��� �̸�(Ȯ���� ����) �� ����Ѵ�(���丮 ����)
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
