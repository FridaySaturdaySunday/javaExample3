package messenger.udp;

import javax.swing.JOptionPane;

public class Run {

	public static void main(String[] args) {

//		System.out.println(JOptionPane.showInputDialog("aaaa")); // cancel 누르면 null뜸
		
		int myPort = 0;
		int otherPort = 0;
		
		try {
			myPort = Integer.parseInt(JOptionPane.showInputDialog("당신의 포트번호를 입력하세요"));
			otherPort = Integer.parseInt(JOptionPane.showInputDialog("상대방 포트번호를 입력하세요"));
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Messenger a = new Messenger(myPort, otherPort);
		MyFrame f = a.getMyFrame();
		f.process();

		// 나: 9007 상대방: 8888
	}

}
