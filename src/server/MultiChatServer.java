package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MultiChatServer {
	
	public static void main(String[] args) {
		new MultiChatServer().start(); // Thread 상속과 무관한, MultiChatServer 클래스의 메소드
	}

	private HashMap<String, DataOutputStream> clients;

	// 생성자
	public MultiChatServer() {
		clients = new HashMap<String, DataOutputStream>();
		Collections.synchronizedMap(clients);
	}

	// Thread 상속과 무관한, MultiChatServer 클래스의 메소드. 그냥 클래스 이름이 start()임.
	public void start() {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("서버가 시작 되었습니다.");
			
			while (true) {
				socket = serverSocket.accept();
				System.out.println("새로운 유저가 로그인 하였습니다.");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start(); // Thread 상속한 ServerReceiver클래스의 메소드.
								// Thread start()로 run() 호출 예정
			}
		} catch (IOException e) {
			e.printStackTrace();
		} // finally { socket.close(); ~ }  쓰는게 의미가 없음. 무한반복돼서 close될 일이 없어서
	}
	
	
	
	
	// 내부클래스 (ServerReceiver)
	class ServerReceiver extends Thread {

		private Socket socket;
		private DataInputStream in;
		private DataOutputStream out;

		// 내부클래스 (ServerReceiver)의 생성자
		public ServerReceiver(Socket socket) {
			this.socket = socket;

			try {
				this.in = new DataInputStream(socket.getInputStream());
				this.out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 내부클래스 (ServerReceiver)의 메소드
		public void run() {
			String name = null;

			try {
				name = in.readUTF();
				sendToAll("#" + name + "님이 들어오셨습니다.");
				clients.put(name, out);
				System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");

				while (in != null) {
					sendToAll(in.readUTF());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				sendToAll("#" + name + "님이 나가셨습니다.");
				clients.remove(name);
				System.out.println("현재 접속자 수는 " + clients.size() + "입니다.");
			}
		}
	} // 내부클래스 (ServerReceiver) 끝

	
	
	public void sendToAll(String msg) { // 모든 클라이언트에게 보내는 메소드
		
		// 방법1 : iterator
		Iterator it = clients.keySet().iterator(); //keySet() : (Map을) Set로 만들어서 리턴
		while (it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream) clients.get(it.next());
				out.writeUTF(msg);
			} catch (Exception e) {
			}
		}
		
		// 방법2 : enhanced for
//		for(String key : clients.keySet()) {
//			try {
//				DataOutputStream out = clients.get(key);
//				out.writeUTF(msg);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
