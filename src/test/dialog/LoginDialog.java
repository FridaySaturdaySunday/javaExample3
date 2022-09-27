package test.dialog;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginDialog extends JDialog implements ActionListener {
	
	private JTextField idTF;
	private JPasswordField pwdTF;
	private JButton loginBtn, closeBtn;
	private JPanel centerPan, southPan;
	private MainFrame owner;

	public LoginDialog(MainFrame owner) {
		
		super(owner);
		this.owner = owner;
		this.setModal(true);
		this.setBounds(100, 100, 300, 200);
		this.setLayout(new BorderLayout());
		
		centerPan = new JPanel();
		idTF = new JTextField(20);
		pwdTF = new JPasswordField(20);
		centerPan.setLayout(new GridLayout(2, 2));
		centerPan.add(new JLabel("아이디 : "));
		centerPan.add(idTF);
		centerPan.add(new JLabel("암 호 : "));
		centerPan.add(pwdTF);
		southPan = new JPanel();
		loginBtn = new JButton("로그인");
		closeBtn = new JButton("닫기");
		southPan.add(loginBtn);
		southPan.add(closeBtn);
		loginBtn.addActionListener(this);
		closeBtn.addActionListener(this);
		
		this.add(centerPan, BorderLayout.CENTER);
		this.add(southPan, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// 버튼 클릭시 동작 처리
		switch (event.getActionCommand()) {
		case "닫기":
			this.setVisible(false);
			break;
		case "로그인":
			String userId = idTF.getText();
			String userPwd = new String(pwdTF.getPassword());
			System.out.println("아이디 : " + userId + ", 암호 : " + userPwd);
			if (userId.equals("u1234") == true && userPwd.equals("p1234") == true) {
				JOptionPane.showMessageDialog(this, "로그인 성공!");
				this.setVisible(false);
				owner.showUser(userId, userPwd);
			} else {
				this.setVisible(false);
				owner.errorDisplay("아이디나 암호가 일치하지 않습니다.");
			}
		}
	}
}
