package step3.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/* EchoServer(�޾Ƹ� ����)
 * Ŭ���̾�Ʈ�� �����Ͽ� �����͸� �����ϸ� �Է¹޾� �ֿܼ� ����ϰ�
 * �ٽ� �� �����͸� Ŭ���̾�Ʈ�� ����ϴ� �޾Ƹ� ����.
 */
/*
 * ServerSocket ��ǥ��ȭ
 * accept(����)
 * ��,��� ��Ʈ�� ����
 * while(){
 * �Է�
 * ���
 * }
 * close
 */
public class EchoServer {

	public void go() throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5432);
			System.out.println("*** �޾Ƹ� ���� ***");
			Socket socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + " �����߽��ϴ�.");
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				String message = br.readLine();
				try {
					if (message == null || message.equals("����")) {
						System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����Ƿ� ������ �����մϴ�.");
						break;
					}
					System.out.println("client �޼���: " + message);
					pw.println(message+" server^^");
				} catch (Exception e) {
					System.out.println(socket.getInetAddress() + " ��� ���� �߻�");
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
