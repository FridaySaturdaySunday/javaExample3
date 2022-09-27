package test.dialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class MainFrame extends JFrame {

	private JTextArea tarea;
	private LoginDialog loginDlg;

	public MainFrame() {
		this.setTitle("test Dialog");
		this.setBounds(0, 0, 800, 600);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setJMenuBar(makeMenuBar());
		makeComponents();
		loginDlg = new LoginDialog(this);
		loginDlg.setVisible(true);
		this.setVisible(true);
	}

	private void makeComponents() {
		// 컴포넌트 객체 생성하고, 이벤트 연결 처리 메소드
		tarea = new JTextArea(10, 100);
		tarea.setText("텍스트 에리어 영역입니다.");
		this.add(tarea, BorderLayout.CENTER);
		// 익명클래스 작성 방식으로 이벤트 연결, 동작처리
		tarea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				// 적용 컴포넌트를 클릭했을 때
				if (event.getButton() == MouseEvent.BUTTON3) {
					// 텍스트에리어에서 마우스 오른쪽버튼을 눌렀을 때
					showPopup(event.getX(), event.getY());
				}
			}
		});
	}

	private void showPopup(int x, int y) {
		// popup menu 만들기
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.add(new JMenuItem("복사하기"));
		popupMenu.add(new JMenuItem("붙여넣기"));
		popupMenu.show(tarea, x, y);
	}

	private JMenuBar makeMenuBar() {
		
		// 메인프레임에 셋팅할 메뉴바 만드는 메소드
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu, editMenu, viewMenu, helpMenu;
		fileMenu = new JMenu("파일(F)");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		editMenu = new JMenu("편집(E)");
		editMenu.setMnemonic(KeyEvent.VK_E);
		viewMenu = new JMenu("보기(V)");
		viewMenu.setMnemonic(KeyEvent.VK_V);
		helpMenu = new JMenu("도움말");
		
		// 메뉴 아이템 만들기
		JMenuItem fileNew = new JMenuItem("새로 만들기");
		JMenuItem fileOpen = new JMenuItem("열기...");
		JMenuItem fileSave = new JMenuItem("저장");
		JMenuItem fileSaveAs = new JMenuItem("다른 이름으로 저장...");
		JMenuItem fileExit = new JMenuItem("끝내기(X)");
		fileExit.setMnemonic(KeyEvent.VK_X);
		fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		fileExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 끝내기 메뉴아이템 선택시 작동할 코드 구현
				int result = JOptionPane.showConfirmDialog(getParent(), "프로그램을 종료하시겠습니까?", "프로그램 종료",
						JOptionPane.YES_NO_OPTION);
				if (result == 0)
					System.exit(0);
			}
		});
		fileMenu.add(fileNew);
		fileMenu.add(fileOpen);
		fileMenu.addSeparator();
		fileMenu.add(fileSave);
		fileMenu.add(fileSaveAs);
		fileMenu.addSeparator();
		fileMenu.add(fileExit);
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem statusShow = new JRadioButtonMenuItem("상태바 표시");
		JRadioButtonMenuItem statusHide = new JRadioButtonMenuItem("상태바 숨기기");
		statusHide.setSelected(true);
		group.add(statusShow);
		group.add(statusHide);
		
		// checkBox 메뉴 만들기
		JCheckBoxMenuItem toolbarToggle = new JCheckBoxMenuItem("툴바 보기/숨기기");
		toolbarToggle.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				// 메뉴아이템의 상태가 변경되었을 때 작동되는 이벤트임
				JOptionPane.showMessageDialog(getParent(), event.getStateChange());
			}
		});
		viewMenu.add(statusShow);
		viewMenu.add(statusHide);
		viewMenu.addSeparator();
		viewMenu.add(toolbarToggle);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(viewMenu);
		menuBar.add(helpMenu);
		return menuBar;
	}

	public void showUser(String userId, String userPwd) {
		// 로그인 성공시 아이디, 암호 처리용
		tarea.setText("로그인 사용자 정보 : " + userId + ", " + userPwd);
	}

	public void errorDisplay(String message) {
		// 로그인 실패시 에러메시지 처리용
		JOptionPane.showMessageDialog(this, message);
	}

}
