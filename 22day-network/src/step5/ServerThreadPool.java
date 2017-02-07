package step5;

import java.util.ArrayList;


public class ServerThreadPool {
	static ArrayList<ServerWorker> list = new ArrayList<ServerWorker>();

	public static void add(ServerWorker sw) {
		list.add(sw);
	}

	public static void println(String message) {
		for (ServerWorker work : list) {
			work.getPrintWriter().println(message);
		}
	}

	public static void remove(ServerWorker work) {
		list.remove(work);
	}
}
