package test.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestINetAddress {

	public static void main(String[] args) throws UnknownHostException {
		// getLocalHost() : 지역호스트의 IP주소 반환
		// getHostAddress() : 호스트의 IP주소를 반환
		// getHostName() : 호스트의 이름을 반환
		// getByName(String host) : 도메인명(host)을 통해 IP주소 얻음
		// getAllByName(String host) : 도메인명(host)에 지정된 모든 호스트의 IP주소를 '배열'로 반환
		
		InetAddress ip1 = InetAddress.getLocalHost(); 
		System.out.println(ip1.getHostAddress()); //192.168.20.127
		System.out.println(ip1.getHostName()); //DESKTOP-VG78N1V
		
		System.out.println("------------------------");
		
		InetAddress ip2 = InetAddress.getByName("www.naver.com"); 
		InetAddress[] ipes = ip2.getAllByName("www.google.com"); 
		
		System.out.println("naver : " + ip2.getHostAddress()); //223.130.195.95
		
		System.out.println("------------------------");
		
		System.out.println("google 의 서버는 " + ipes.length + "개 있습니다."); // 1
		for(InetAddress ip : ipes) {
			System.out.println(ip.getHostAddress()); //142.251.42.196
		}
		
		System.out.println("------------------------");
		
		InetAddress[] ipes2 = InetAddress.getAllByName("www.naver.com");
		System.out.println("naver 의 서버 ip는" + ipes2.length + "개 있습니다."); // 2
		for(InetAddress ip : ipes2) {
			System.out.println(ip.getHostAddress()); //223.130.195.95
		}											 //223.130.200.104
	}
}
