package swingGUI;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public static void main(String[] args) {
		new MyFrame();
	}

	// 생성자
	public MyFrame() {
		
		JFrame jfr = new JFrame("Swing GUI 프로그램"); // JFrame 객체 생성
		jfr.setSize(300, 300); // JFrame 크기 설정
		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료동작 설정
		jfr.setVisible(true); // JFrame 활성화
	}

}
