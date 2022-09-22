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
		
//		new TCPEchoClient().clientTCP("localhost", 9007);
		new TCPEchoClient().clientTCP("127.0.0.1", 9007);
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
			br = new BufferedReader(new InputStreamReader(sock.getInputStream())); // 8. 입출력 스트림을 얻음
			wr = new PrintWriter(new OutputStreamWriter(sock.getOutputStream())); // 8. 입출력 스트림을 얻음
			
			// 통신과 상관없이 입력데이터 -> Scanner 사용해도 됨
			stdin = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			String echo = null;
			
			// 서버와 통신
			do {
				System.out.print("\tInsert Msg > ");
				msg = stdin.readLine();
				// "exit" 입력으로 접속 끊기
				if (msg.equals("exit")) {
					return; // 리턴걸어도 finally문으로 감
				}
				// 에코 메시지 출력
				wr.println(msg);
				wr.flush(); // 10.
				
				echo = br.readLine(); // 11.
				System.out.println("\tSERVER> " + echo);
				
			} while (msg != null);
		} catch (IOException ie) {
			ie.printStackTrace();
//			System.out.println(ie);
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
