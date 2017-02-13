package step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
 * 채팅 서버
 * 다수의 클라이언트와 지속적으로 통신
 * 클라이언트가 보낸 메세지를 입력받아
 * 접속한 모든 클라이언트에게 메세지를 출력한다.
 */
public class ChattingServer {
	private ArrayList<ServerWorker> list = new ArrayList<ServerWorker>();

	public void go() throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5432);
			System.out.println("** ChattingServer **");
			while (true) {
				Socket socket = serverSocket.accept();
				ServerWorker sw = new ServerWorker(socket);
				Thread t = new Thread(sw);
				t.start();
				list.add(sw);
			}
		} finally {
			if (serverSocket != null)
				serverSocket.close();
		}
	}

	public static void main(String[] args) {
		try {
			new ChattingServer().go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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
			System.out.println(user + "님 입장!");
		}

		public void SendToAll(String message) {
			for (ServerWorker work : list) {
					work.getPrintWriter().println(message);
					work.getPrintWriter().flush();
			}
		}

		@Override
		public void run() {
			try {
				echo();
			} catch (IOException e) {
				System.out.println(user + "님 강제종료 ㅠㅠ");
			}
		}

		public void echo() throws IOException {
			BufferedReader br = null;
			pw = null;
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream(), true);
				while (true) {
					String message = br.readLine();
					if (message == null || message.equals("종료")||message.equals("null")) {
						System.out.println(user + "님 퇴장!");
						break;
					}
					SendToAll(user + ": " + message);

				}

			} finally {
				System.out.println(user + " 해제");
				SendToAll(user + " 접속 해제");
				if (br != null)
					br.close();
				if (pw != null)
					pw.close();
				if (socket != null)
					socket.close();
				list.remove(this);
			}
		}

	}

}
