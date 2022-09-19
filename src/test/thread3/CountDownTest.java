package test.thread3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CountDownTest extends JFrame /*implements Runnable 대신 내부클래스 사용*/ {
	
//	<스레드 그룹 일괄 interrupt()>
//	스레드 그룹에서 제공하는 interrupt() 메소드를 이용하여 그룹 내의 모든 스레드에 일괄 interrupt을 발생시킬 수 있다.
//	개별 스레드에 interrupt()를 수행할 뿐 InterruptedException에 대한 예외 처리를 하지는 않는다.
	
	// 방법 1:
	private boolean flag = false;
	// 방법 2:
	private CountThread cth;
	
	// 필드
	private JLabel label;
	private JButton startBtn;
	private JButton stopBtn;
	private JTextField numberTF;
	
	
	// 내부클래스 : 클래스 안에 작성된 클래스 (Inner class / Nested class 라고 함)
	// 내부클래스는 외부클래스의 멤버 개념이 적용이 됨
	// 내부클래스에는 static, private, protected 사용 가능
	private class CountThread extends Thread {
		
		@Override
		public void run() {
			
			int startNumber = Integer.parseInt(numberTF.getText());
			
			for(int count = startNumber; count >= 0; count--) {
				// 방법 1:
				if(flag) {
					label.setText("멈춤");
					return; // 메소드 종료 -> 스레드 종료
				}
				try {
					Thread.sleep(1000); // 1초 기다리기
				} catch (InterruptedException e) {
					e.printStackTrace();
					// 방법 2:
					label.setText("멈춤");
					return;
				}
				label.setText(String.valueOf(count));
			}
			
		}
	}
	
	// 생성자
	public CountDownTest() {
		this.setTitle("카운트다운 프로그램");
		this.setSize(500,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// <numberTF> ===================================================
		numberTF = new JTextField("시작값을 입력하세요");
		this.add(numberTF, BorderLayout.NORTH);
		
		// <label> ======================================================
		label = new JLabel("시작");
		label.setFont(new Font("Serif", Font.BOLD, 100));
		label.setAlignmentX(CENTER_ALIGNMENT);
		this.add(label, BorderLayout.CENTER);
		
		// <startBtn> ===================================================
		startBtn = new JButton("카운트시작하기");
		this.add(startBtn, BorderLayout.WEST);
		
		// 버튼에 이벤트 설정함 : 익명(Anonymous) 클래스 이용
		
		// 방법 1:
//		startBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// 버튼을 클릭하면 스레드(내부클래스)가 스타트되게 함 
//				new CountThread().start(); // start(): 멀티스레드 동작O / run(): 멀티스레드 동작X -> 사용X
//			}
//		});
		
		// 방법 2:
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cth == null || !cth.isAlive()) { // 스레드 실행중일때 새로운 스레드 생성되지 않게
					cth = new CountThread();
					cth.start();
				}
			}
		});
		
		// <stopBtn> ====================================================
		stopBtn = new JButton("멈추기");
		this.add(stopBtn, BorderLayout.EAST);
		
		stopBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 멈추기 interrupt 발생
				
				// 방법 1:
//				flag = true;
				
				// 방법 2:	
				cth.interrupt(); // -> InterruptedException 발생함
			}
		});
		
		
		this.setVisible(true);
		
	}
	

	
	public static void main(String[] args) {
		// 스레드를 이용한 카운트다운 테스트
		new CountDownTest();
		System.out.println("끝");
	}

}
