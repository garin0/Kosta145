package step4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
public class MultiServer {
	/*
	 * �ټ��� Ŭ���̾�Ʈ���� ���������� �޾Ƹ� ���񽺸� �����ϴ� step4.server.MultiServer
	 * 
	 */
	public void go() throws IOException {

		ServerSocket serverSocket = null;
		try {
			
			serverSocket = new ServerSocket(5432);
			System.out.println("**MultiServer**");
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
			new MultiServer().go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
