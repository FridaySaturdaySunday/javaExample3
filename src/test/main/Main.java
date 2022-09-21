package test.main;

import test.inet.InetAddressEx;
import test.url.URLEx;

public class Main {

	public static void main(String[] args) {

		new InetAddressEx().testInetAddress("www.oracle.com");
		
		new URLEx().testURLExample("https://www.oracle.com/downloads/index.html");
	}

}
