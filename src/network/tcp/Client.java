package network.tcp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		int port = 8500;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			String serverIP = InetAddress.getLocalHost().getHostAddress(); // getHostAddress()가 String형으로 변환해주기때문에 쓴거임(학습용)
			System.out.println(serverIP); // 192.168.20.127 (내 IP)
			
			// 소켓 생성 : new Socket(내 IP, 상대 port)
			Socket socket = new Socket(InetAddress.getLocalHost(), port); 
//			Socket socket = new Socket(serverIP, port);	// 이렇게해도됨
			
			if(socket != null) {
				
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream());
				
				Scanner sc = new Scanner(System.in);
				
				do {
					System.out.println("대화 입력 : ");
					String message = sc.nextLine();
					
					pw.println(message);
					pw.flush();
					
					if(message.equals("exit")) {
						break;
					}
					
					String receiveMessage = br.readLine();
					System.out.println(receiveMessage);
					
				} while(true);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
