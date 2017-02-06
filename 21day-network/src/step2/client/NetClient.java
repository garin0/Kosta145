package step2.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import common.IP;

/*
 * ������ �����Ͽ� �޼����� �����ϰ� ������ �����Ѵ�.
 */
public class NetClient {
	public void go() throws UnknownHostException, IOException {
		Socket socket = null;
		PrintWriter pw = null;
		Scanner sc = null;
		try {
			socket = new Socket(IP.MY_IP, 5432);
			sc = new Scanner(System.in);
			pw = new PrintWriter(socket.getOutputStream(),true); //autoflush
			System.out.println("** client�� Server�� �޼��� ���� **");
			pw.println(sc.nextLine());
		} finally {
			if (sc != null)
				sc.close();
			if (pw != null)
				pw.close();
			if (socket != null)
				socket.close();
			
		}
	}

	public static void main(String[] args) {
		try {
			new NetClient().go();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
