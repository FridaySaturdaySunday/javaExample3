package test.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
// 수업때 한거
	public static void main(String[] args) {

		Socket s = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			// 서버 연결 시도 - 성공시 소켓생성
			s = new Socket("localhost", 9007); // localhost: 내가 현재 접속하고있는곳
			s = new Socket("127.0.0.1", 9007); // TODO 
			s = new Socket(InetAddress.getLocalHost(), 9007); // getLocalHost: 자기IP
			s = new Socket(InetAddress.getLocalHost().getHostAddress(), 9007); // getHostAddress: String으로 반환
			
//			System.out.println(InetAddress.getLocalHost()); // DESKTOP-VG78N1V/192.168.20.127
			
			// 연결소켓으로부터 입출력 얻어옴
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			
			// 출력스트림을 송신
			out.println("반갑습니다.");
			out.flush(); // 버퍼비우기
			
			String msg = null;
			while((msg = in.readLine()) != null) {
				
				// 입력스트림을 수신
				System.out.println("받은메세지 : " + msg);
			}
			
		} catch (UnknownHostException e) { // 위 주소와 포트로 연결 실패시
			e.printStackTrace();
		} catch (IOException e) { // 연결 실패시
			e.printStackTrace();
		} finally {
			try {
				if(in!=null) in.close();
				if(out!=null) out.close();
				if(s!=null) s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
