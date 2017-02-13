package step5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import step4.ServerWorker;
/*
 * Echo(메아리) 서비스를 다수의 클라이언트에
 * 서비스하는 서버를 구현하는 것이 목적
 * 
 * 다수의 클라이언트와 지속적으로 메아리 서비스를 하귀 위해서는
 * 클라이언트 수에 비례하는 서버측의 스레드가 필요하다.
 * 
 * MultiServer : 사장님
 * : 클라이언트 접속을 대기하다가 (ServerSocket)
 * 	 접속하면 일반 소켓(클라이언트와 통신할)을 반환받아 스레드 생성 시
 *   할당한 후 start 시킨다.
 *   ---------------------------------
 *   class MultiServer{
 *   	public void go(){
 *   		ServerSocket
 *   		while{
 *   			accept() : Socket
 *   			ServerWorker Thread 생성(생성시 Socket 할당)
 *   			Thread start() -> 실행 가능 상태로 보낸다.
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
 *      	입력
 *      	출력
 *   	}
 *   }
 *   
 * ServerWorker: 직원 (Thread)
 * 사장님으로부터 할당받은 소켓으로 (run()) 
 * 클라이언트와 지속적으로 메아리 서비스 한다.
 */
public class MultiServer2 {
	/*
	 * 다수의 클라이언트에게 지속적으로 메아리 서비스를 제공하는 step4.server.MultiServer
	 * 
	 */
	public void go() throws IOException {

		ServerSocket serverSocket = null;
		try {
			System.out.println("**MultiServer**");
			serverSocket = new ServerSocket(5432);
			System.out.println("**클라이언트 접속 대기중입니다**");
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
