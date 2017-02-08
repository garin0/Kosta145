package step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import common.IP;

/* 채팅 클라이언트 
 * 2개 스레드가 멀티스레딩 되어야 한다.
 * main thread : 콘솔에서 입력받아 서버로 메세지를 출력하는 스레드
 * ClientWorker Thread: 서버에서 오는 채팅메세지를 입력받아 콘솔에 출력하는 스레드
 */
public class ChattingClient {
	public void go() throws IOException, UnknownHostException {
		Socket socket = null;
		BufferedReader br = null;
		try {
			System.out.println("** ChattingClient **");
			socket = new Socket(IP.MY_IP, 5432);
			ClientWorker cw = new ClientWorker(socket);
			Thread t = new Thread(cw);
			t.start();

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				try {
					String str = br.readLine();
					System.out.println(str);
				} catch (SocketException e) {
					System.out.println("..안녕!..");
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			new ChattingClient().go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public class ClientWorker implements Runnable {
		private Socket socket;
		private String user;

		public ClientWorker(Socket socket) {
			this.socket = socket;
			user = "[" + socket.getInetAddress().toString() + "]";
			System.out.println(user + "님 입장!.");
		}

		@Override
		public void run() {
			BufferedReader br = null;
			PrintWriter pw = null;
			Scanner sc= null;
			try {
				pw = new PrintWriter(socket.getOutputStream(), true);
				sc =  new Scanner(System.in);
				while (true) {
					String message = sc.nextLine();
					if (message == null || message.equals("종료") || message.equals("null")) {
						System.out.println("연결 종료합니다.");
						break;
					}
					pw.println(message);
				}
			} catch (IOException e) {
				System.out.println("------종료------");
			} finally {
				if (br != null)
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				if (pw != null)
					pw.close();
				if (socket != null)
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				if(sc!=null)
					sc.close();
			}
		}

	}

}
