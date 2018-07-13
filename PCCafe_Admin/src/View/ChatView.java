package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ChatView extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JLabel lblNewLabel_1;
	public JTextField textField;
	private JButton btnNewButton;

	// public Socket socket;
	// public boolean isFirst = true; // 맨 처음으로 서버로 전송하는 경우
	// wc;

	public ChatView() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(118, 527, 286, 24);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("사용자에게:");
		lblNewLabel.setBounds(36, 530, 90, 18);
		panel.add(lblNewLabel);

		// enter
		btnNewButton = new JButton("전송");
		btnNewButton.setBounds(418, 526, 105, 27);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(this);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(0, 0, 568, 488);
		panel.add(lblNewLabel_1);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 700);// 전체틀

		/*
		 * //서버 this.socket = socket; wc = new WriteClass(this); //new Id(wc, this); //
		 * ????????????????아이디 입력란 뜨고 그후 다시 취소후 헤야 이름이 부여됨 wc.sendMsg(); // 서버로 처음 접속
		 * isFirst = false;
		 */

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnNewButton) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					// ChatView frame = new ChatView(socket);
					dispose(); // 현재 창을 닫음
				}

			});
		}
	}
}