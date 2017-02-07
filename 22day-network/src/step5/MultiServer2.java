package step5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import step4.ServerWorker;
/*
 * Echo(�޾Ƹ�) ���񽺸� �ټ��� Ŭ���̾�Ʈ��
 * �����ϴ� ������ �����ϴ� ���� ����
 * 
 * �ټ��� Ŭ���̾�Ʈ�� ���������� �޾Ƹ� ���񽺸� �ϱ� ���ؼ���
 * Ŭ���̾�Ʈ ���� ����ϴ� �������� �����尡 �ʿ��ϴ�.
 * 
 * MultiServer : �����
 * : Ŭ���̾�Ʈ ������ ����ϴٰ� (ServerSocket)
 * 	 �����ϸ� �Ϲ� ����(Ŭ���̾�Ʈ�� �����)�� ��ȯ�޾� ������ ���� ��
 *   �Ҵ��� �� start ��Ų��.
 *   ---------------------------------
 *   class MultiServer{
 *   	public void go(){
 *   		ServerSocket
 *   		while{
 *   			accept() : Socket
 *   			ServerWorker Thread ����(������ Socket �Ҵ�)
 *   			Thread start() -> ���� ���� ���·� ������.
 *   		}
 *   	}
 *   }
 *   ---------------------------------
 *   class ServerWorker implements Runnable{
 *   	private Socket socket;
 *   	ServerWorker(Socket socket){
 *   		
 *   	}
 *   	public void run(){
 *      	�Է�
 *      	���
 *   	}
 *   }
 *   
 * ServerWorker: ���� (Thread)
 * ��������κ��� �Ҵ���� �������� (run()) 
 * Ŭ���̾�Ʈ�� ���������� �޾Ƹ� ���� �Ѵ�.
 */
public class MultiServer2 {
	/*
	 * �ټ��� Ŭ���̾�Ʈ���� ���������� �޾Ƹ� ���񽺸� �����ϴ� step4.server.MultiServer
	 * 
	 */
	public void go() throws IOException {

		ServerSocket serverSocket = null;
		try {
			System.out.println("**MultiServer**");
			serverSocket = new ServerSocket(5432);
			System.out.println("**Ŭ���̾�Ʈ ���� ������Դϴ�**");
			while (true) {
				Socket socket = serverSocket.accept();
				ServerWorker sw = new ServerWorker(socket);
				Thread thread = new Thread(sw);
				thread.start();
				}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(serverSocket!=null)
				serverSocket.close();
		}
	}

	public static void main(String[] args) {
		try {
			new MultiServer2().go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
