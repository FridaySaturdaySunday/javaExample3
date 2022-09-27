package swingGUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NullLayoutManagerEx extends JFrame {

	public static void main(String[] args) {
		new NullLayoutManagerEx();
	}

	public NullLayoutManagerEx() {
		
		setTitle("배치관리자 없는 컨테이너 예제");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null); // 배치 관리자 제거
		
		JLabel label = new JLabel("배치관리자 없는 컨테이너");
		label.setLocation(150, 50); // 컴포넌트 위치 설정
		label.setSize(200, 20); // 컴포넌트 크기 설정
		add(label);
		
		for (int i = 1; i <= 10; i++) {
			JButton b = new JButton(Integer.toString(i));
			b.setBounds(i * 10, i * 10, 50, 20); // 컴포넌트의 크기와 위치를 한번에 설정
			add(b);
		}
		setVisible(true);
	}
}
