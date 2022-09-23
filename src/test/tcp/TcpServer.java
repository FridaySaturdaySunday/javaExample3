package test.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {
// 수업때 한거
	public static void main(String[] args) {
		
		ServerSocket ss = null;
		Socket s = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			// 서버 소켓 생성
			ss = new ServerSocket(9007); // 포트번호 지정 안하면 자동지정됨(그러면 안됨. 클라이언트가 알아야하니까)
			
			// 클라이언트 접속 대기 - 수락 - 연결소켓 생성
			s = ss.accept();
			
			// 연결소켓으로부터 입출력 얻어옴 
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			
			String msg = null;
			while((msg = in.readLine()) != null) {
				
				// 입력스트림을 수신
				System.out.println("받은메세지 : " + msg);
				
				// 출력스트림을 송신
				out.println("sendMsg");
				out.flush(); // 버퍼비우기
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in!=null) in.close();
				if(out!=null) out.close();
				if(s!=null) s.close();
				if(ss!=null) ss.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
