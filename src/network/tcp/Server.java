package network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		int port = 8500;
		
		// 서버 소켓 생성
		ServerSocket server = new ServerSocket(port);
		
		while(true) {
			// 클라이언트 접속 대기 - 수락 - 연결소켓 생성
			Socket client = server.accept();
			
			// 연결소켓으로부터 입출력 얻어옴
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter pw = new PrintWriter(client.getOutputStream());
			
			while(true) {
				// 입력스트림을 수신
				String message = br.readLine();
				
				if(!message.equals("exit")) {
					System.out.println(client.getInetAddress().getHostAddress() + "가 보낸 메세지 : " + message);
					// 출력스트림을 송신
					pw.println("메세지 받기 성공");
					pw.flush();
				} else {
					System.out.println("접속 종료");
					break;
				}
			}
			br.close();
			pw.close();
			client.close();
		}
	}

}
