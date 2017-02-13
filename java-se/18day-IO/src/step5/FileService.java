package step5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileService {

	public void copyAndPasteDir(String orgDir, String destDir) throws IOException {
		
		new File(destDir).mkdirs();
		File[] list = new File(orgDir).listFiles();
		for(int i = 0 ; i < list.length ; i++){
			BufferedReader br = new BufferedReader(new FileReader(list[i]));
			PrintWriter pw = new PrintWriter(new FileWriter(destDir + File.separator + list[i].getName()));
			String data = br.readLine();
			while(data!=null){
				pw.println(data);
				data = br.readLine();
			}
			br.close();
			pw.close();
		}//for
		
	}

}
