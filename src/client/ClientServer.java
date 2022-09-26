package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientServer {
	
	// 생성자
	public ClientServer() {
		
		String serverIp = "127.0.0.1";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("대화명을 입력하세요 : ");
		String name = sc.nextLine();
		
		try {
			Socket socket = new Socket(serverIp, 8888);
			System.out.println("서버에 연결 되었습니다.");
			
			Thread sender = new Thread(new ClientSender(socket, name));
			Thread receiver = new Thread(new ClientReceiver(socket));
			
			sender.start(); 
			receiver.start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}