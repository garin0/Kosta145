package step3;

import java.io.File;

public class FileService {

	/*
	 * �Ű������� ���޵� filePath�� ���ϰ� ������ ��ġ�� ����(���丮 �� �ڽ��� ����) ���� ����ϴ� �޼���
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
