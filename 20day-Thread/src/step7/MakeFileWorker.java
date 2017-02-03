package step7;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MakeFileWorker implements Runnable {
	private int sleep;
	private int cnt;
	public MakeFileWorker(int sleep, int cnt) {
		this.sleep = sleep;
		this.cnt = cnt;
	}
	public String createFileName(int name){
		Random r= new Random();
		if(r.nextBoolean())
			return name + ".mp3";
		else
			return name + ".avi";
	}

	@Override
	public void run() {
		new File(CommonInfo.MAKE_PATH).getParentFile().mkdirs();
		for(int i = 0 ; i <cnt;i++){
			String fileName = createFileName(i);
			try {
				File dest = new File(CommonInfo.MAKE_PATH);
				if(!dest.exists())
					dest.mkdirs();
				new File(dest + File.separator + fileName).createNewFile();
				System.out.println(fileName+" »ý¼º");
				Thread.sleep(sleep);
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
