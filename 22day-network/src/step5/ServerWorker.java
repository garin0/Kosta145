package step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerWorker implements Runnable {
	private Socket socket;
	private String user;
	private PrintWriter pw;

	public PrintWriter getPrintWriter() {
		return pw;
	}

	public ServerWorker(Socket socket) {
		this.socket = socket;
		user = "[" + socket.getInetAddress().toString() + "]";
		System.out.println(user + "�� �����ϼ̽��ϴ�.");
	}

	@Override
	public void run() {
		try {
			echo();
		} catch (IOException e) {
			System.out.println(user + "�� �������� �Ф�");
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
				if (message == null || message.equals("����") || message.equals("null")) {
					System.out.println(user + "�� �����̽��ϴ�!");
					break;
				}

				System.out.println(user + "�� �޼���: " + message);
				pw.println("[server]" + message);
				ServerThreadPool.println(message);
				
			}

		} finally {
			if (br != null)
				br.close();
			if (pw != null)
				pw.close();
			if (socket != null)
				socket.close();
			ServerThreadPool.remove(this);

		}
	}

}
