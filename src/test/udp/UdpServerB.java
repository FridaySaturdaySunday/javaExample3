package test.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServerB { // 받는 서버
	
	public static void main(String[] args) {
		
		int myport = 9008;
		int otherport = 9007;
		DatagramSocket ds = null;
	
		try {
			ds = new DatagramSocket(myport);
			
			while(true) {
				
				byte[] buff = new byte[1024];
				DatagramPacket dp = new DatagramPacket(
						buff, // 데이터 (byte[]의 형태임)
						buff.length); // 데이터 길이
				
				ds.receive(dp);
				// 출력하기
				System.out.println(new String(dp.getData(), 0, dp.getLength())); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ds!=null && !ds.isClosed()) ds.close();
		}
	
	}
	
}
