package test.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestINetAddress2 {

	public static void main(String[] args) throws UnknownHostException {
		
		// 키보드로 호스트명을 입력받아, 해당 호스트가 가진 ip 주소 모두를 출력 처리
		do {
			System.out.println("호스트명 (종료:none):");
			String host = new Scanner(System.in).next();
			
			if(host.equals("none") != true) {
				InetAddress[] ips = InetAddress.getAllByName(host);
				// getAllByName(String host) : 도메인명(host)에 지정된 모든 호스트의 IP주소를 '배열'로 반환
				
				System.out.println(host + "가 가진 ip는 " + ips.length + "개 입니다.");
				
				for(InetAddress ip : ips) {
					System.out.println(ip.getHostAddress());
				}
			} else {
				break;
			}
		} while(true);
		
	}
}
//	www.oracle.com 입력하면 ~~~~~
//	www.oracle.com가 가진 ip는 1개 입니다.
//	104.74.162.89