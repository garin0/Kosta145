package step3.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/* EchoServer(메아리 서버)
 * 클라이언트가 접속하여 데이터를 전송하면 입력받아 콘솔에 출력하고
 * 다시 그 데이터를 클라이언트로 출력하는 메아리 서버.
 */
/*
 * ServerSocket 대표전화
 * accept(접수)
 * 입,출력 스트림 생성
 * while(){
 * 입력
 * 출력
 * }
 * close
 */
public class EchoServer {

	public void go() throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5432);
			System.out.println("*** 메아리 서버 ***");
			Socket socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + " 접속했습니다.");
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				String message = br.readLine();
				try {
					if (message == null || message.equals("종료")) {
						System.out.println("클라이언트가 종료되었으므로 서버도 종료합니다.");
						break;
					}
					System.out.println("client 메세지: " + message);
					pw.println(message+" server^^");
				} catch (Exception e) {
					System.out.println(socket.getInetAddress() + " 통신 예외 발생");
				}
			}
			pw.close();
			br.close();
			socket.close();
		} finally {
			if (serverSocket != null)
				serverSocket.close();
		}

	}

	public static void main(String[] args) {
		try {
			new EchoServer().go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
