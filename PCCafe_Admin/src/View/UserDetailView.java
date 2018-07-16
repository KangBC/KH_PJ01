package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import Singleton.Singleton;

public class UserDetailView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton but_chat;
	private JButton success;

	public UserDetailView() {

import Dto.MemberDto;
import Singleton.Singleton;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class UserDetailView extends JFrame implements ActionListener {
	private Singleton single = Singleton.getInstance();
	private JTextField tf_id, tf_time;
	private JButton bt_chatView, bt_exit;

	private int seatNum;
	private MemberDto dto;

	public UserDetailView(int seatNum, MemberDto dto) {
		this.seatNum = seatNum;
		this.dto = dto;
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


		JLabel lb_title = new JLabel();
		lb_title.setText("PC " + (seatNum + 1));
		lb_title.setForeground(Color.WHITE);
		lb_title.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(114, 0, 246, 52);
		contentPane.add(lb_title);

		setResizable(false);
		setContentPane(contentPane);


		bt_chatView = new JButton("메세지");
		bt_chatView.setBounds(47, 536, 141, 44);
		contentPane.add(bt_chatView);

		bt_exit = new JButton("닫기");
		bt_exit.setBounds(278, 536, 141, 44);
		contentPane.add(bt_exit);

		tf_id = new JTextField(dto.getId());
		tf_id.setEnabled(false);
		tf_id.setFont(new Font("Georgia", Font.BOLD, 18));
		tf_id.setColumns(10);
		tf_id.setBounds(137, 69, 278, 31);
		contentPane.add(tf_id);

		JLabel lb_id = new JLabel();
		lb_id.setText("ID");
		lb_id.setHorizontalAlignment(SwingConstants.CENTER);
		lb_id.setForeground(Color.WHITE);
		lb_id.setFont(new Font("Georgia", Font.BOLD, 18));
		lb_id.setBounds(54, 69, 69, 28);
		contentPane.add(lb_id);

		JLabel lb_time = new JLabel();
		lb_time.setText("TIME");
		lb_time.setHorizontalAlignment(SwingConstants.CENTER);
		lb_time.setForeground(Color.WHITE);
		lb_time.setFont(new Font("Georgia", Font.BOLD, 18));
		lb_time.setBounds(40, 155, 83, 28);
		contentPane.add(lb_time);

		// Test
		System.out.println("r_time : " + dto.getR_time());
		tf_time = new JTextField(dto.getR_time()+" minute");
		tf_time.setFont(new Font("Georgia", Font.BOLD, 18));
		tf_time.setEnabled(false);
		tf_time.setColumns(10);
		tf_time.setBounds(137, 155, 278, 31);
		contentPane.add(tf_time);

		JLabel lb_order = new JLabel();
		lb_order.setText("ORDER");
		lb_order.setHorizontalAlignment(SwingConstants.CENTER);
		lb_order.setForeground(Color.WHITE);
		lb_order.setFont(new Font("Georgia", Font.BOLD, 18));
		lb_order.setBounds(54, 247, 98, 28);
		contentPane.add(lb_order);

		JTextArea ta_order = new JTextArea((String) null);
		ta_order.setEditable(false);
		ta_order.setBounds(56, 287, 359, 218);
		contentPane.add(ta_order);
		setBounds(720, 220, 480, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bt_chatView.addActionListener(this);
		bt_exit.addActionListener(this);
	}

	@Override
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


		if (obj == bt_chatView) {
			Socket temp[] = single.serCtrl.getSockList();
			single.serCtrl.chatView(temp[seatNum]);
		} else if (obj == bt_exit) {
			this.dispose();
		}
	}
}
