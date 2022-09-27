package swingGUI;

import java.awt.event.InputEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class MenuEx extends JFrame {

	public static void main(String[] args) {
		new MenuEx();
	}

	JTextArea textArea = new JTextArea("안녕하세요!", 5, 10); // 스크롤 바 없는 텍스트영역
	JScrollPane jp = new JScrollPane(textArea); // textArea에 스크롤바 생성
	
	// 메뉴 컴포넌트 생성
	JMenuBar menuBar = new JMenuBar(); // JMenuBar 위에 JMenu 컴포넌트들이 올라감
	JMenu fileMenu = new JMenu("파일");
	JMenu viewMenu = new JMenu("보기");
	JMenu helpMenu = new JMenu("Help");

	public MenuEx() {
		
		setTitle("메뉴 만들기");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 파일 메뉴(fileMenu) 생성
		fileMenu.add(new JMenuItem("새 파일"));
		
		// 단축키 설정
		fileMenu.getItem(0).setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
		fileMenu.add(new JMenuItem("열기"));
		fileMenu.add(new JMenuItem("저장"));
		fileMenu.addSeparator(); // 구분선 추가
		fileMenu.add(new JMenuItem("종료"));
		
		// 메뉴를 메뉴바에 등록
		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		menuBar.add(helpMenu);
		// 메뉴바 등록
		setJMenuBar(menuBar);
		// textArea 등록
		add(jp, "Center");
		setVisible(true);
	}

}
