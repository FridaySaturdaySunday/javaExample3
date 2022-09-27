package test.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {

	public static void main(String[] args) {

		new UDPEchoServer().serverUDP(9007);
	}

	public void serverUDP(int port) {

		DatagramSocket dSock = null;

		try {
			dSock = new DatagramSocket(port); // 주어진 포트로 UDP 소켓 생성

			while (true) {
				System.out.println("====== 클라이언트 접속 대기 중 (port:" + dSock.getPort() + ")=====");

				// 2. 데이터 수신
				byte[] buffer = new byte[1024];
				DatagramPacket receive = new DatagramPacket(buffer, buffer.length);
				dSock.receive(receive);

				System.out.println("receive.getLength() : " + receive.getLength()); // 클라이언트가 입력한 길이
				System.out.println("receive.getData().length : " + receive.getData().length); // 1024 

				// byte 배열을 문자형태로 만드는 방법
				String msg = new String(receive.getData(), 0, receive.getLength());

				System.out.println("\tCLIENT > " + msg);

				System.out.println("메시지 보낸 곳의 주소: " + receive.getAddress());
				System.out.println("메시지 보낸 곳의 포트: " + receive.getPort());

				
				// 3. 데이터 송신
				DatagramPacket send = new DatagramPacket( // DatagramPacket : 무조건 byte 형태가 담김
						receive.getData(), // 보내는 메시지
						receive.getData().length, // 보내는 메시지 길이
						receive.getAddress(), // 상대방 주소
						receive.getPort()); // 상대방 포트
				dSock.send(send);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dSock.close();
		}
	}
}
