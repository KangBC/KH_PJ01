package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UserDetailView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton button;
	// private Socket socket;//새로운 socket방 선언

	public UserDetailView() { // 또하나의 socket방 선언
		// public UserDetailView(Socket socket) { // 또하나의 socket방 선언
		// this.socket = socket;

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("고객아이디:");
		lblNewLabel.setBounds(111, 23, 86, 37);
		panel.add(lblNewLabel);

		JLabel lblDldjsl = new JLabel("dldjsl2");
		lblDldjsl.setBounds(199, 23, 134, 37);
		panel.add(lblDldjsl);

		JLabel label = new JLabel("피씨번호:");
		label.setBounds(111, 61, 62, 37);
		panel.add(label);

		JLabel label_1 = new JLabel("5");
		label_1.setBounds(205, 61, 62, 37);
		panel.add(label_1);

		JLabel label_2 = new JLabel("이용시간:");
		label_2.setBounds(111, 107, 62, 37);
		panel.add(label_2);

		JLabel label_3 = new JLabel("이용요금");
		label_3.setBounds(111, 156, 62, 37);
		panel.add(label_3);

		JLabel label_4 = new JLabel("0");
		label_4.setBounds(199, 107, 62, 37);
		panel.add(label_4);

		JLabel label_5 = new JLabel("0");
		label_5.setBounds(199, 156, 62, 37);
		panel.add(label_5);

		btnNewButton = new JButton("채팅");
		btnNewButton.setBounds(14, 214, 105, 43);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(this);

		button = new JButton("완료");
		button.setBounds(265, 214, 105, 43);
		panel.add(button);
		button.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 326);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 채팅
		Object obj = e.getSource();
		if (obj == btnNewButton) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					// ChatView frame = new ChatView(socket);
					ChatView frame = new ChatView();
					dispose(); // 현재 창을 닫음
					frame.setVisible(true);
				}

			});

			// 완료 기능을 삭제 하고 툴바를 삭제한다.
		} else if (obj == button) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					dispose(); // 현재 창을 닫음
				}
			});

		}
	}
}
