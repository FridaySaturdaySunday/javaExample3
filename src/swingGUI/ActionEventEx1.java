package swingGUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionEventEx1 extends JFrame {

	public static void main(String[] args) {
		new ActionEventEx1();
	}

	public ActionEventEx1() {
		this.setTitle("KH JAVA GUI");
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton("클릭");
		MyActionListener listener = new MyActionListener();
		btn.addActionListener(listener);
		btn.setBackground(Color.WHITE);

		this.add(btn);
		setSize(300, 150);
		setResizable(false);
		setVisible(true);
	}
}

//이벤트 실행 시 자신이 원하는 액션이 일어나도록 별도 클래스로 작성하였다
class MyActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.getText().equals("클릭")) {
			btn.setText("클릭하셨습니다.");
			btn.setBackground(Color.ORANGE);
		} else {
			btn.setText("클릭");
			btn.setBackground(Color.WHITE);
		}
	}
}
