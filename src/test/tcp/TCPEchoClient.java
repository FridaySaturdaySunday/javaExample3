package test.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPEchoClient {
	
	public static void main(String[] args) {
		
		new TCPEchoClient().clientTCP("127.0.0.1", 9007); // "localhost" 도 가능
	}

	public void clientTCP(String ip, int port) {
		
		Socket sock = null;
		
		BufferedReader br = null;
		PrintWriter wr = null;
		BufferedReader stdin = null;
		
		try {
			// 서버로 접속
			sock = new Socket(ip, port); // 3. IP, Port 생성 (접속 실패시 exception) 7. TCP 프로토콜
			System.out.println("접속성공 !!");
			
			// 서버와 통신을 위한 stream 생성
			br = new BufferedReader(new InputStreamReader(sock.getInputStream())); 
			wr = new PrintWriter(new OutputStreamWriter(sock.getOutputStream())); 
			
			// 통신과 상관없이 입력데이터 -> Scanner 사용해도 됨
			stdin = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			String echo = null;
			
			// 서버와 통신
			do {
				System.out.print("\tInsert Msg > ");
				msg = stdin.readLine(); // 1. 내가 쓴 메세지 읽기
				// "exit" 입력으로 접속 끊기
				if (msg.equals("exit")) {
					return; // 리턴걸어도 finally문으로 감
				}
				// 에코 메시지 출력
				wr.println(msg); // 2. msg를 상대방에게 출력스트림으로 보냄
				wr.flush(); 
				
				echo = br.readLine(); // 6. 서버가 보낸 메세지 읽고 echo에 담음
				System.out.println("\tSERVER> " + echo); // 7. 내 창에 echo를 출력
				
			} while (msg != null);
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if(stdin!=null) stdin.close();
				if(br!=null) br.close();
				if(wr!=null) wr.close();
				if(sock!=null && !sock.isClosed()) sock.close();
				System.out.println("종료.");
			} catch (IOException ie) {
				System.out.println(ie);
			}
		}
	}
}
