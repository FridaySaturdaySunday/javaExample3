package test.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLEx {
	
	public void testURLExample(String urlStr) {
		
	// URL 형식 -> 프로토콜://호스트[:포트번호][/디렉토리[/파일이름]][?쿼리스트링]
		
		System.out.println(urlStr); // https://www.oracle.com/downloads/index.html
		URL url;
		try {
			url = new URL(urlStr);
			System.out.println("프로토콜 : " + url.getProtocol()); // https
			System.out.println("포트번호 : " + url.getPort()); // -1
			System.out.println("호스트 : " + url.getHost()); // www.oracle.com
			System.out.println("파일경로 : " + url.getFile()); // /downloads/index.html
			System.out.println("URL 전체 : " + url.toExternalForm()); // https://www.oracle.com/downloads/index.html
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
