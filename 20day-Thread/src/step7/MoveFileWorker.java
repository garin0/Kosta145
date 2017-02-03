package step7;

import java.awt.Container;
import java.io.File;

public class MoveFileWorker implements Runnable {
	private int sleep;
	private int cnt;

	public MoveFileWorker(int sleep, int cnt) {
		this.sleep = sleep;
		this.cnt = cnt;
	}

	@Override
	public void run() {
		try {
			File destMusic = new File(CommonInfo.MUSIC_PATH);
			File destMovie = new File(CommonInfo.MOVIE_PATH);
			if (destMovie.isDirectory() == false) {
				destMovie.mkdirs();
			}
			if (destMusic.isDirectory() == false) {
				destMusic.mkdirs();
			}
			while (true) {
				File[] list = new File(CommonInfo.MAKE_PATH).listFiles();
				Thread.sleep(sleep);
				
				System.out.println("현재 남은 갯수 ====" + list.length);
				if (list.length == 0)
					break;
				if (list.length <cnt)
					continue;

				for (int i = 0; i < cnt; i++) {
					if (list[i].isFile() && list[i].getName().endsWith("mp3")) {
						list[i].renameTo(new File(destMusic + File.separator + list[i].getName()));
						System.out.println(list[i].getName() + "이동");

					}
					if (list[i].isFile() && list[i].getName().endsWith("avi")) {
						list[i].renameTo(new File(destMovie + File.separator + list[i].getName()));
						System.out.println(list[i].getName() + "이동");
					}
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
