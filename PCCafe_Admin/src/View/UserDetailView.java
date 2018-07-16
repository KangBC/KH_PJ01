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

import Singleton.Singleton;

public class UserDetailView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton but_chat;
	private JButton success;

	public UserDetailView() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel JuserNum = new JLabel("고객아이디:");
		JuserNum.setBounds(111, 23, 86, 37);
		panel.add(JuserNum);

		JLabel JuserNum1 = new JLabel("dldjsl2");
		JuserNum1.setBounds(199, 23, 134, 37);
		panel.add(JuserNum1);

		JLabel pcnum = new JLabel("피씨번호:");
		pcnum.setBounds(111, 61, 62, 37);
		panel.add(pcnum);

		JLabel pcnumber = new JLabel("5");
		pcnumber.setBounds(205, 61, 62, 37);
		panel.add(pcnumber);

		JLabel Hoursuse = new JLabel("이용시간:");
		Hoursuse.setBounds(111, 107, 62, 37);
		panel.add(Hoursuse);

		JLabel Hoursusenum = new JLabel("0");
		Hoursusenum.setBounds(111, 156, 62, 37);
		panel.add(Hoursusenum);

		JLabel Charge = new JLabel("이용요금");
		Charge.setBounds(199, 107, 62, 37);
		panel.add(Charge);

		JLabel Chargenum = new JLabel("0");
		Chargenum.setBounds(199, 156, 62, 37);
		panel.add(Chargenum);

		but_chat = new JButton("채팅");
		but_chat.setBounds(14, 214, 105, 43);
		panel.add(but_chat);
		but_chat.addActionListener(this);

		success = new JButton("완료");
		success.setBounds(265, 214, 105, 43);
		panel.add(success);
		success.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 326);

	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		Singleton sc = Singleton.getInstance();
		
		//chatview
		if (obj == but_chat) {
			sc.bbsCtrl.chat();

			// 완료 기능을 삭제 하고 툴바를 삭제한다.
		} else if (obj == success) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					dispose(); // 현재 창을 닫음
				}
			});

		}
	}
}
