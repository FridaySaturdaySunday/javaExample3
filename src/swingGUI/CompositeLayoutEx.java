package swingGUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CompositeLayoutEx extends JFrame {

	public static void main(String[] args) {
		new CompositeLayoutEx();
	}

	JButton b1 = new JButton("West");
	JButton b2 = new JButton("Center");
	
	// JPanel에 버튼 2개를 추가하여 구성할 예정
	JPanel jp = new JPanel();
	JButton b3 = new JButton("확인");
	JButton b4 = new JButton("취소");

	public CompositeLayoutEx() {
		
		setTitle("복합 배치 관리자 예제");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JPanel에 b3, b4 버튼 추가
		jp.add(b3);
		jp.add(b4);
		
		// JPanel로 묶인 b3, b4와 b1, b2 버튼을 추가
		// JPanel의 기본 배치 관리자 : FlowLayout
		// JFrame의 기본 배치 관리자 : BorderLayout
		add(jp, "North");
		add(b1, "West");
		add(b2, "Center");
		
		setVisible(true);
	}
}
