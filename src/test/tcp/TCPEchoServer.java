package test.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {
	
	public static void main(String[] args) {
		
		new TCPEchoServer().tcpServer(9007);
	}

	public void tcpServer(int port) {

		// 서버 소켓 관련 객체
		ServerSocket serverSock = null;
		Socket sock = null;
		// 입출력 객체
		BufferedReader br = null;
		PrintWriter wr = null;

		try {
			// 서버 소켓 생성
			serverSock = new ServerSocket(port); // 1. 포트 생성

			while (true) {
				// 클라이언트의 접속 대기
				sock = serverSock.accept(); // 2. 청취 5. 생성 6. 소켓 리턴

				// 클라이언트와 통신을 위한 stream 생성
				br = new BufferedReader(new InputStreamReader(sock.getInputStream())); 
				wr = new PrintWriter(new OutputStreamWriter(sock.getOutputStream())); 
				
				// 클라이언트와 통신
				String msg = null;
				while ((msg = br.readLine()) != null) { // 3. 클라이언트가 보낸 메세지를 읽고 msg에 담음
					System.out.println("\tCLIENT> " + msg); // 4. 내 창에 msg 출력 
					
					wr.println(msg); // 5. msg를 다시 상대방에게 출력스트림으로 보냄
					wr.flush(); 
				}
			}
		} catch (IOException ie) {
			System.out.println(ie);
		} finally {
			try {
				br.close(); // new로 생성되는거의 반대순서로 닫아주기
				wr.close();
				sock.close();
				serverSock.close();
				System.out.println("종료.");
			} catch (IOException ie) {
				System.out.println(ie);
			}
		}
	}
}
