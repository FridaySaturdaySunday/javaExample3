package chat.server;

public class ServerRun {

	public static void main(String[] args) {
		
		// 서버를 구동하기 위한 메소드
		try {
			new ServerGUI();
		} catch (Exception e) {
			System.err.println(e.getMessage() + "\n서버 프로그램 실행 실패!!");
		}
	}

}
