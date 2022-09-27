package test.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressEx {

	public void testInetAddress(String domain) {
		// getByName(String host) : 도메인명(host) 통해 IP주소 얻음 // www.oracle.com/104.74.162.89
		// getLocalHost() : 지역호스트의 IP주소 반환 // DESKTOP-VG78N1V/192.168.20.127
		// getHostName() : 호스트의 이름을 반환 // DESKTOP-VG78N1V
		// getHostAddress() : 호스트의 IP주소를 반환 // 192.168.20.127
		// getAddress() : IP주소를 byte'배열'로 반환
		
		InetAddress ip = null;

		try {
			ip = InetAddress.getByName(domain); 

			System.out.println("HostName : " + ip.getHostName()); //www.oracle.com
			System.out.println("HostAddress : " + ip.getHostAddress()); //104.74.162.89
			System.out.println("HostName/HostAddress : \n\t" + ip.toString());

			System.out.println("-----------------------------------");
			
			byte[] ipAddr = ip.getAddress(); // IP주소를 byte '배열'로 반환
			System.out.println("getAddress() : " + Arrays.toString(ipAddr)); //[104, 74, -94, 89] -> 오버플로우

			System.out.print("HostAddress : ");
			for (int i = 0; i < ipAddr.length; i++) {
				if (ipAddr[i] < 0)
					System.out.print(ipAddr[i] + 256); //104.74.162.89.
				else
					System.out.print(ipAddr[i]);
				System.out.print(".");
			}
			System.out.println("");
			
			System.out.println("-----------------------------------");
			
			ip = InetAddress.getLocalHost(); 
			System.out.println("LocalHostName : " + ip.getHostName()); //DESKTOP-VG78N1V
			System.out.println("LocalHostAddress() : " + ip.getHostAddress()); //192.168.20.127
			System.out.println("Local HostName/HostAddress : \n\t" + ip.toString());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
