package step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerWorker implements Runnable {
	private Socket socket;
	private String user;

	public ServerWorker(Socket socket) {
		this.socket = socket;
		user = "[" + socket.getInetAddress().toString() + "]";
		System.out.println(user + "¥‘ ¿‘¿Â«œºÃΩ¿¥œ¥Ÿ.");
	}

	@Override
	public void run() {
		try {
			echo();
		} catch (IOException e) {
			System.out.println(user + "¥‘ ∞≠¡¶¡æ∑· §–§–");
		}
	}

	public void echo() throws IOException {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				String message = br.readLine();
				if (message == null || message.equals("¡æ∑·") || message.equals("null")) {
					System.out.println(user + "¥‘ ≥™∞°ºÃΩ¿¥œ¥Ÿ!");
					break;
				}
					System.out.println(user + "¥‘ ∏ﬁºº¡ˆ: " + message);
					pw.println("[server]" + message);
				} 

		}  finally {
			if (br != null)
				br.close();
			if (pw != null)
				pw.close();
			if (socket != null)
				socket.close();

		}
	}

}
