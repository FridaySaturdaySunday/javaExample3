package test.main;

import test.tcp.TCPEchoClient;

public class ClientMain {

	public static void main(String[] args) {
		
//		new TCPEchoClient().clientTCP("localhost", 9007);
		new TCPEchoClient().clientTCP("127.0.0.1", 9007);
	}

}
