package swingGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnotherFrame extends JFrame {
	
//	<응용프로그램을 종료시키는 방법> => dispose vs exit
//	exit : 응용프로그램에서 실행된 모든 프레임을 닫고 응용프로그램을 종료시킨다. 
//	dispose : 해당 프레임을 닫고,
//							다른 활성화된 프레임 O -> 응용프로그램 종료시키지 않음
//							다른 활성화된 프레임 X -> 응용프로그램까지 종료시킴
	
	public AnotherFrame() {
		
		setTitle("AnotherFrame");
		setSize(430, 110);
		setLocation(0, 120); // 프레임 위치 설정
		setLayout(null); // 기본 배치관리자 무시
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 기본 종료 동작 설정. 프레임종료
		
		// dispose로 종료 동작하는 버튼 --> AnotherFrame만 종료됨
		JButton btnDispose = new JButton("Dispose");
		btnDispose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); // 프레임 닫기
			}
		});
		btnDispose.setBounds(10, 10, 100, 50);
		add(btnDispose);
		
		// exit 로 종료 동작하는 버튼 --> MainFrame까지 종료됨
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // 응용프로그램 종료
			}
		});
		btnExit.setBounds(120, 10, 100, 50);
		add(btnExit);
		setVisible(true);
	}
}