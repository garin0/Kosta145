package step1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import common.IP;

public class NetClient {
	public void go() throws IOException {
		Socket socket = null;
		BufferedReader br = null;
		try {
			socket = new Socket(IP.MY_IP, 5432);
			System.out.println("**클라이언트 실행**");
			/*
			 * socket.getInputStream() 이 ByteStream이므로 BufferedReader를 이용하기 위해서는
			 * CharacterStream(2byte 단위)으로 변경해야 한다. InputStreamReader는 1byte 단위
			 * ByteStream을 2byte 단위 CharacterStream으로 변경하는 Processing Stream이다.
			 */
			InputStreamReader ir = new InputStreamReader(socket.getInputStream());
			br = new BufferedReader(ir);
			System.out.println("서버에서 보낸 메세지: " + br.readLine());
		} finally {
			if (br != null)
				br.close();
			if (socket != null)
				socket.close();
		}
	}

	public static void main(String[] args) {
		try {
			new NetClient().go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
