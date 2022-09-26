package client;

import java.io.*;
import java.net.Socket;

public class ClientReceiver extends Thread {
	
	Socket socket;
	DataInputStream in;

	// 생성자
	public ClientReceiver(Socket socket) {
		this.socket = socket;
		
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (in != null) {
			try {
				System.out.println(in.readUTF());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
