package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Dao.serverBackGround;

public class ChatView extends JFrame implements ActionListener {

	private JButton bt_exit, bt_send;
	private Socket socket;
	private JTextField tf_msg;
	public static JTextArea contentArea;

	public ChatView(Socket socket) {
		this.socket = socket;
		ImageIcon icon = new ImageIcon("black.png");
		JPanel contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		bt_exit = new JButton(new ImageIcon("exit.png"));
		bt_exit.setBounds(413, 1, 60, 46);
		bt_exit.setOpaque(false);
		bt_exit.setContentAreaFilled(false);
		bt_exit.setBorder(null);
		contentPane.add(bt_exit);

		JLabel title = new JLabel();
		title.setText("Chat SYSTEM");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Arial Black", Font.PLAIN, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(114, 0, 246, 52);
		contentPane.add(title);

		contentArea = new JTextArea();
		contentArea.setText("[알림] 필요한 용무가 있으시면 언제든 연락해주세요!" + "\n");
		contentArea.setFont(new Font("Georgia", Font.BOLD, 18));
		contentArea.setEditable(false);
		contentArea.setLineWrap(true);

		JScrollPane scrPane = new JScrollPane(contentArea);
		scrPane.setPreferredSize(new Dimension(200, 120));
		scrPane.setBounds(0, 49, 474, 473);
		contentPane.add(scrPane);

		JLabel label = new JLabel("Msg");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Georgia", Font.BOLD, 15));
		label.setBounds(10, 545, 73, 30);
		contentPane.add(label);

		tf_msg = new JTextField();
		tf_msg.setColumns(10);
		tf_msg.setBounds(83, 547, 288, 27);
		contentPane.add(tf_msg);

		bt_send = new JButton("Send");
		bt_send.setFont(new Font("Georgia", Font.BOLD, 13));
		bt_send.setBounds(385, 547, 71, 27);
		contentPane.add(bt_send);

		setContentPane(contentPane);
		setBounds(720, 220, 480, 640);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		bt_exit.addActionListener(this);
		bt_send.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		serverBackGround serBack = new serverBackGround(socket);
		if (obj == bt_exit) {
			this.setVisible(false);
		} else if (obj == bt_send) {
			serBack.commandSign(socket);
			serBack.sendMsg(socket, tf_msg.getText());
			contentArea.append(tf_msg.getText() + "\n");
			tf_msg.setText("");
		}
	}
}