package swingGUI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutEx extends JFrame {

// 배치 관리자 (LayoutManager) 
//	FlowLayout : 왼쪽부터 차례대로 하나씩
//	BorderLayout : 동, 서, 남, 북, 중앙으로 다섯 개의 영역
//	GridLayout : 같은 크기의 격자 (행렬로 나눔)
//	CardLayout : 여러장의 카드를 겹쳐 놓은 방식으로 컴포넌트를 배치

	public static void main(String[] args) {
		new FlowLayoutEx();
	}

	// 버튼 생성
	JButton b1 = new JButton("버튼1");
	JButton b2 = new JButton("버튼2");
	JButton b3 = new JButton("버튼3");

	public FlowLayoutEx() {
		
		setTitle("FlowLayout 예제");
		setSize(250, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30)); // FlowLayout 형태로 배치 관리자 변경
		
		// 버튼 추가
		add(b1);
		add(b2);
		add(b3);
		setVisible(true);
	}

}
