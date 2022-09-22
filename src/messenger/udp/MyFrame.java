package messenger.udp;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {

	private DatagramSocket socket;
	private DatagramPacket packet;
	private JTextField textField;
	private JTextArea textArea;
	private InetAddress address;
	private int otherPort;

	// 생성자
	public MyFrame(InetAddress address, int otherPort, DatagramSocket socket) throws HeadlessException {
		this.address = address;
		this.otherPort = otherPort;
		this.socket = socket;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textField = new JTextField(30);
		textField.addActionListener(this);

		textArea = new JTextArea(10, 30);
		textArea.setEditable(false);

		this.add(textField, BorderLayout.PAGE_END);
		this.add(textArea, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String str = textField.getText();
		byte[] buffer = str.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, address, otherPort);

		try {
			socket.send(sendPacket);
		} catch (IOException e) {
			e.printStackTrace();
		}
		textArea.append("SENT : " + str + "\n");
		textField.selectAll();
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

	public void process() {
		while (true) {
			byte[] buf = new byte[256];
			packet = new DatagramPacket(buf, buf.length);
			try {
				socket.receive(packet);
				textArea.append("RECIEVE : " + new String(buf) + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
