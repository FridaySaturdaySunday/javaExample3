package test.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServerA { // 보내는 서버

	public static void main(String[] args) {
		
		int myport = 9007;
		int otherport = 9008;
		DatagramSocket ds = null;
		
		try {
			ds = new DatagramSocket(myport);
			
			byte[] buff = "안녕하세요".getBytes();
			DatagramPacket dp = new DatagramPacket(
					buff, // 데이터 (byte[]의 형태여야함)
					buff.length, // 데이터 길이
					InetAddress.getLocalHost(), // 상대방 주소
					otherport); // 상대방 포트
			
			ds.send(dp);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ds!=null && !ds.isClosed()) ds.close();
		}
		
	}
	
	
}
