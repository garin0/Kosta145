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
 * 서버에 메세지를 출력하고
 * 서버에서 출력한 메세지를 입력받아 자신의 콘솔에 출력하는 역할을 한다.
 * 종료라는 메세지를 사용자로부터 입력받으면 프로그램을 종료한다.
 */

/*
 * socketetet 생성
 * 입출력 스트림 생성(스캐너 포함)
 * Scanner->PrintWriter->BufferedReader
 * while() {
 * scanner로 입력받은 메세지를 서버로 출력
 * 서버에서 메세지 입력
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
			pw = new PrintWriter(socket.getOutputStream(), true); //서버에 입력할
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //서버에서 입력받을
			while (true) {
				String message = sc.nextLine();
				pw.println(message);
				if(message.equals("종료")){
					System.out.println("클라이언트 종료");
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
