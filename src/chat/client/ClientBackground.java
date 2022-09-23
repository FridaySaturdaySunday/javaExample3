package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackground {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	
	private String msg;
	private String nickName;
	
	private ClientGUI gui;

	// gui 세터
	public void setGui(ClientGUI gui) {
		this.gui = gui;
	}
	// nickName 세터
	public void setNickname(String nickName) {
		this.nickName = nickName;
	}
	
	// 클라이언트 접속에 대한 메소드
	public void connect() {
		try {
			// 소켓 생성
			socket = new Socket("127.0.0.1", 7777);
			System.out.println("서버에 연결됨");

			// 연결소켓으로부터 입출력 얻어옴
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());

			// 서버에 나의 nickName을 전송
			out.writeUTF(nickName);

			// in은 생성되고 나면 연결이 끊어지기 전까지 null이 될 수 없음. 무한반복.
			while (in != null) {
				// 서버로부터 메세지를 읽어옴
				msg = in.readUTF();
				gui.appendMsg(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String msg) {
		try {
			out.writeUTF(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	
}
