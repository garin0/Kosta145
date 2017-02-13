package step4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileService {

	public void copyAndPasteFile(String orgPath, String destPath) throws IOException{
		new File(destPath).getParentFile().mkdirs();
		PrintWriter pw = new PrintWriter(new FileWriter(destPath));
		BufferedReader br = new BufferedReader(new FileReader(orgPath));
		String str = br.readLine();
		while(str!=null){
			pw.println(str);
			str = br.readLine();
		}
		br.close();
		pw.close();
	}

}
