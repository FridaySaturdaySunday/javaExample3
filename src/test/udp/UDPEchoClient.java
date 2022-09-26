package test.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPEchoClient {
	
	public static void main(String[] args) {
		
		new UDPEchoClient().clientUDP("localhost");
	}

	public void clientUDP(String ip) {

		// 주소 설정 - localhost
		InetAddress inetaddr = null;
		
		try {
			inetaddr = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
		
		DatagramSocket dSock = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			dSock = new DatagramSocket(); // 주어진 포트로 UDP 소켓 생성 (포트번호 지정하지 않으면 Windows에서 자동 지정)
			dSock = new DatagramSocket(9090); // 포트번호 9090으로 UDP 소켓 생성
			String str = null;
			do {
				// 데이터그램 송신
				System.out.print("\tInsert Msg > ");
				str = br.readLine();
				DatagramPacket send = new DatagramPacket( // DatagramPacket : 무조건 byte 형태가 담김
						str.getBytes(), // 보내는 메시지
						str.getBytes().length, // 보내는 메시지 길이 
						inetaddr, // 상대방 주소
						9007); // 상대방 포트
				dSock.send(send);
				
				if (str.equals("exit"))
					break;
				
				System.out.println("str.getBytes().length : " + str.getBytes().length); // 클라이언트가 입력한 길이
				
				// 데이터그램 수신
				byte[] buffer = new byte[1024];
				DatagramPacket receive = new DatagramPacket(buffer, buffer.length);
				dSock.receive(receive);
				System.out.println("receive.getLength() : " + receive.getLength()); // 1024
				
				// byte 배열을 문자열 형태로 만들어줌
//				String echo = new String(receive.getData(), 0, receive.getData().length);
				String echo = new String(receive.getData(), 0, receive.getLength());
				System.out.println("\tSERVER> " + echo);
			} while (str != null);
			
			System.out.println("UDPEchoClient를 종료합니다.");
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			if(dSock!=null && !dSock.isClosed())
				dSock.close();
		}
	}
}
