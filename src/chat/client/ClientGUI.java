package chat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 10000000L; // 컴파일 시 인식할 객체 고유 ID
	private JTextArea jta = new JTextArea(40, 25); // 채팅 창
	private JTextField jtf = new JTextField(25); // 글 입력 부분
	private ClientBackground client = new ClientBackground(); // 채팅을 담당할 백그라운드(뒷작업 영역) 선언
	private static String nickName;

	// 생성자
	public ClientGUI(String nickName) {

		ClientGUI.nickName = nickName;

		setBounds(800, 100, 400, 600);
		setTitle("클라이언트부분");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		
		jta.setFont(new Font("맑은고딕", Font.PLAIN, 18)); // 글자 폰트, 크기 변경
		jta.setEditable(false);
		jta.setBackground(new Color(230, 255, 230));

		jtf.addActionListener(this);
		// jtf 컴포넌트에서 enterkey가 눌리면 actionPerformed() 메소드 호출
		// GUI 프로그램의 component에는 event가 발생했을때 호출되는 메소드를 등록해둠
		
		client.setGui(this);
		client.setNickname(nickName);
		client.connect();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 문자 입력 창에 글을 입력 시 구동할 이벤트 설정
		String msg = nickName+":"+jtf.getText()+"\n";
		client.sendMessage(msg);
		jtf.setText(""); // 입력 후 내용 초기화
	}
	
	public void appendMsg(String msg) {
		jta.append(msg);
	}
	
	
	
	
	
	
	
	

}
