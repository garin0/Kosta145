package step6;

import java.io.File;

public class Moveservice {

	public void excute(String orgDir, String destDir, String ext) {
		File[] orgFile = new File(orgDir).listFiles();
		File dest = new File(destDir);

		if (!dest.exists()) {
			dest.mkdirs();
		}

		for (int i = 0; i < orgFile.length; i++) {
			if (orgFile[i].isFile() && orgFile[i].getName().endsWith(ext)) {
				orgFile[i].renameTo(new File(destDir + File.separator + orgFile[i].getName()));
			}
			/*
			 * String subExt =
			 * orgFile[i].getName().substring(orgFile[i].getName().lastIndexOf(
			 * ".")+1); if(subExt.equals(ext)){ File move = new File(orgDir +
			 * File.separator + orgFile[i].getName()); File destination = new
			 * File(destDir + File.separator + orgFile[i].getName());
			 * move.renameTo(destination); }
			 */

		}

	}

}
