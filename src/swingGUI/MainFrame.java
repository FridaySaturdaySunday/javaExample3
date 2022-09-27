package swingGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

//	<응용프로그램을 종료시키는 방법> => dispose vs exit
//	exit : 응용프로그램에서 실행된 모든 프레임을 닫고 응용프로그램을 종료시킨다. 
//	dispose : 해당 프레임을 닫고,
//							다른 활성화된 프레임 O -> 응용프로그램 종료시키지 않음
//							다른 활성화된 프레임 X -> 응용프로그램까지 종료시킴

	public static void main(String[] args) {
		new MainFrame();
	}

	public MainFrame() {
		
		setTitle("MainFrame");
		setSize(400, 110);
		setLayout(null); // 기본 배치관리자 무시
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 기본 종료 동작 설정. 전체종료
		
		// dispose로 종료 동작하는 버튼
		JButton btnDispose = new JButton("Dispose");
		btnDispose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); // 프레임 닫기
			}
		});
		btnDispose.setBounds(10, 10, 100, 50); // 위치와 크기 설정
		add(btnDispose); // 프레임에 버튼 추가
		
		// exit 로 종료 동작하는 버튼
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // 응용프로그램 종료
			}
		});
		btnExit.setBounds(120, 10, 100, 50); // 위치와 크기 설정
		add(btnExit); // 프레임에 버튼 추가
		
		// 다른 프레임 활성화 버튼
		JButton btnShow = new JButton("Another Frame");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AnotherFrame();
			}
		});
		btnShow.setBounds(230, 10, 140, 50); // 위치와 크기 설정
		add(btnShow); // 프레임에 버튼 추가
		setVisible(true); // 프레임 활성화
	}

}
