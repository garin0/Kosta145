package step4;

import java.io.File;
import java.io.IOException;

public class FileService {

	public void makeDirAndFile(String movieFilePath) throws IOException {

		File file = new File(movieFilePath);
		file.getParentFile().mkdirs();
		file.createNewFile();
	}

	public void makeDirAndFile(String dir, String info) throws IOException {
		new File(dir).mkdirs();

		String[] list = info.split(",");
		for (int i = 0; i < list.length; i++) {
			new File(dir + File.separator + list[i]).createNewFile();
		}

	}

}
