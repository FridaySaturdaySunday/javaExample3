package network.tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkTest {

	public static void main(String[] args) throws UnknownHostException {

		InetAddress localIP = InetAddress.getLocalHost();
		
		System.out.println(localIP.getHostAddress()); //192.168.20.127
		System.out.println(localIP.getHostName()); //DESKTOP-VG78N1V
		
		InetAddress naverIP = InetAddress.getByName("www.naver.com");
		InetAddress[] googleIPs = InetAddress.getAllByName("www.google.com");
		
		System.out.println("네이버 서버 ip : " + naverIP.getHostAddress()); //223.130.200.104
		System.out.println("구글 서버 ip 갯수 : " + googleIPs.length); //1
		for(InetAddress ip : googleIPs) {
			System.out.println(ip.getHostAddress()); //142.250.199.100
		}
	}

}
