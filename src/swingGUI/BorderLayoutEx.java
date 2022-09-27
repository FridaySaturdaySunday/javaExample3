package swingGUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx extends JFrame {

// 배치 관리자 (LayoutManager) 
//	FlowLayout : 왼쪽부터 차례대로 하나씩
//	BorderLayout : 동, 서, 남, 북, 중앙으로 다섯 개의 영역
//	GridLayout : 같은 크기의 격자 (행렬로 나눔)
//	CardLayout : 여러장의 카드를 겹쳐 놓은 방식으로 컴포넌트를 배치

	public static void main(String[] args) {
		new BorderLayoutEx();
	}

	// 버튼 생성
	JButton btnAdd = new JButton("Add");
	JButton btnSub = new JButton("Sub");
	JButton btnMul = new JButton("Mul");
	JButton btnDiv = new JButton("Div");
	JButton btnCalc = new JButton("Calculate");

	public BorderLayoutEx() {
		
		setTitle("BorderLayout 예제");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); // BorderLayout 형태로 배치 관리자 설정
		
		// 버튼 추가
		add(btnSub, "East");
		add(btnAdd, "West");
		add(btnDiv, "South");
		add(btnMul, "North");
		add(btnCalc, "Center");
		setVisible(true);
	}

}
