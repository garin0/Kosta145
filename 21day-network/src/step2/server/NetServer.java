package step2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ������ Ŭ���̾�Ʈ�� ���� �޼����� �޾�
 * �Ʒ��� ���� �޼����� ����� �� ���� Ŭ���̾�Ʈ�� ��ٸ���.
 * 127.0.0.1 ���� �޼��� : �ȳ�
 * 192.168.0.48���� �޼��� : hi
 */
public class NetServer {
	public void go() throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5432);
			System.out.println("*** step2.NetServer ���� ***");
			while (true) {
				Socket socket = serverSocket.accept();
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					System.out.println(socket.getInetAddress() + "���� �޼���: " + br.readLine());
					br.close();
					socket.close();
				} catch (Exception e) {
					System.out.println(socket.getInetAddress() + " ��� ���� �߻�");
				}
			}

		} finally {
			if (serverSocket != null)
				serverSocket.close();
		}
	}

	public static void main(String[] args) {
		try {
			new NetServer().go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
