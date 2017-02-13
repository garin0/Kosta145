package step3.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import common.IP;
import step2.client.NetClient;

/*
 * ������ �޼����� ����ϰ�
 * �������� ����� �޼����� �Է¹޾� �ڽ��� �ֿܼ� ����ϴ� ������ �Ѵ�.
 * ������ �޼����� ����ڷκ��� �Է¹����� ���α׷��� �����Ѵ�.
 */

/*
 * socketetet ����
 * ����� ��Ʈ�� ����(��ĳ�� ����)
 * Scanner->PrintWriter->BufferedReader
 * while() {
 * scanner�� �Է¹��� �޼����� ������ ���
 * �������� �޼��� �Է�
 * }
 * close
 */
public class EchoClient {
	public void go() throws UnknownHostException, IOException {
		Socket socket = null;
		Scanner sc = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		try {
			socket = new Socket(IP.MY_IP, 5432);
			sc = new Scanner(System.in);
			pw = new PrintWriter(socket.getOutputStream(), true); //������ �Է���
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //�������� �Է¹���
			while (true) {
				String message = sc.nextLine();
				pw.println(message);
				if(message.equals("����")){
					System.out.println("Ŭ���̾�Ʈ ����");
					break;
				}
				message = br.readLine();
				System.out.println(message);
			}
		} finally {
			if (br != null)
				br.close();
			if (pw != null)
				pw.close();
			if (sc != null)
				sc.close();
			if (socket != null)
				socket.close();
		}
	}

	public static void main(String[] args) {
		try {
			new EchoClient().go();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
