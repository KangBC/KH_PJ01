package View;

import java.awt.Color;
import java.awt.EventQueue;
<<<<<<< HEAD
=======
import java.awt.Font;
>>>>>>> KH_MiniProject/hyunwoo
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Singleton.Singleton;
import javax.swing.JLabel;
import java.awt.Font;

public class ControlView extends JFrame implements ActionListener {
	private Singleton single = Singleton.getInstance();

	private JPanel contentPane;
<<<<<<< HEAD
	private JButton bt_1, bt_2, bt_3, bt_4, bt_5, bt_6, bt_7, bt_8, bt_9, bt_10, bt_stuff, bt_order, bt_member, bt_bbs;
	private JPanel pl_line;
=======
	private JButton bt_1, bt_2, bt_3, bt_4, bt_5, bt_6, bt_7, bt_8, bt_9, bt_10, bt_order, bt_member, bt_bbs;
>>>>>>> KH_MiniProject/hyunwoo
	private JLabel lb_pc_1, lb_pc_2, lb_pc_3, lb_pc_4, lb_pc_5, lb_pc_6, lb_pc_7, lb_pc_8, lb_pc_9, lb_pc_10;
	private JLabel lb_ID_1, lb_ID_2, lb_ID_3, lb_ID_4, lb_ID_5, lb_ID_6, lb_ID_7, lb_ID_8, lb_ID_9, lb_ID_10;
	private JLabel lb_TIME_1, lb_TIME_2, lb_TIME_3, lb_TIME_4, lb_TIME_5, lb_TIME_6, lb_TIME_7, lb_TIME_8, lb_TIME_9,
			lb_TIME_10;

	// Seat Function
	private ArrayList<JButton> buttonList;
	private ArrayList<JPanel> panelList;
	private ArrayList<JLabel> idList;
	private ArrayList<JLabel> timeList;

	private int selectSeat = -1;

	public ControlView() {
		buttonList = new ArrayList<>();
		panelList = new ArrayList<>();
		idList = new ArrayList<>();
		timeList = new ArrayList<>();

<<<<<<< HEAD
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 1920, 1080));
=======
		contentPane = new JPanel();// 밑 도화지
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setBounds(0, 0, 1920, 1080);
		setResizable(false); // 크기변경 불가
		setUndecorated(true); // 툴바제거
		setVisible(true); // 보여주기
>>>>>>> KH_MiniProject/hyunwoo
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1920, 1080);
		contentPane.add(panel);
		panel.setLayout(null);

<<<<<<< HEAD
		bt_stuff = new JButton("재고관리");
		bt_stuff.setBounds(1558, 46, 270, 300);
		panel.add(bt_stuff);
		bt_stuff.addActionListener(this);

		bt_order = new JButton("주문확인");
		bt_order.setBounds(1088, 47, 270, 300);
=======
		bt_order = new JButton("주문확인");
		bt_order.setFont(new Font("굴림", Font.PLAIN, 18));
		bt_order.setBounds(98, 41, 425, 77);
>>>>>>> KH_MiniProject/hyunwoo
		panel.add(bt_order);
		bt_order.addActionListener(this);

		bt_member = new JButton("회원정보");
<<<<<<< HEAD
		bt_member.setBounds(1088, 440, 270, 300);
=======
		bt_member.setFont(new Font("굴림", Font.PLAIN, 18));
		bt_member.setBounds(671, 41, 500, 77);
>>>>>>> KH_MiniProject/hyunwoo
		panel.add(bt_member);
		bt_member.addActionListener(this);

		bt_bbs = new JButton("게시판");
<<<<<<< HEAD
		bt_bbs.setBounds(1558, 440, 270, 300);
		panel.add(bt_bbs);
		bt_bbs.addActionListener(this);

		pl_line = new JPanel();
		pl_line.setBackground(Color.PINK);
		pl_line.setBounds(920, 0, 4, 1029);
		panel.add(pl_line);

=======
		bt_bbs.setFont(new Font("굴림", Font.PLAIN, 18));
		bt_bbs.setBounds(1351, 41, 425, 77);
		panel.add(bt_bbs);
		bt_bbs.addActionListener(this);

>>>>>>> KH_MiniProject/hyunwoo
		// 선언부
		JPanel pl_1 = new JPanel();
		JPanel pl_2 = new JPanel();
		JPanel pl_3 = new JPanel();
		JPanel pl_4 = new JPanel();
		JPanel pl_5 = new JPanel();
		JPanel pl_6 = new JPanel();
		JPanel pl_7 = new JPanel();
		JPanel pl_8 = new JPanel();
		JPanel pl_9 = new JPanel();
		JPanel pl_10 = new JPanel();

		bt_1 = new JButton();
		bt_2 = new JButton();
		bt_3 = new JButton();
		bt_4 = new JButton();
		bt_5 = new JButton();
		bt_6 = new JButton();
		bt_7 = new JButton();
		bt_8 = new JButton();
		bt_9 = new JButton();
		bt_10 = new JButton();

		lb_ID_1 = new JLabel();
		lb_ID_2 = new JLabel();
		lb_ID_3 = new JLabel();
		lb_ID_4 = new JLabel();
		lb_ID_5 = new JLabel();
		lb_ID_6 = new JLabel();
		lb_ID_7 = new JLabel();
		lb_ID_8 = new JLabel();
		lb_ID_9 = new JLabel();
		lb_ID_10 = new JLabel();

		lb_TIME_1 = new JLabel();
		lb_TIME_2 = new JLabel();
		lb_TIME_3 = new JLabel();
		lb_TIME_4 = new JLabel();
		lb_TIME_5 = new JLabel();
		lb_TIME_6 = new JLabel();
		lb_TIME_7 = new JLabel();
		lb_TIME_8 = new JLabel();
		lb_TIME_9 = new JLabel();
		lb_TIME_10 = new JLabel();

		// 리스트 추가
		panelList.add(pl_1);
		panelList.add(pl_2);
		panelList.add(pl_3);
		panelList.add(pl_4);
		panelList.add(pl_5);
		panelList.add(pl_6);
		panelList.add(pl_7);
		panelList.add(pl_8);
		panelList.add(pl_9);
		panelList.add(pl_10);

		buttonList.add(bt_1);
		buttonList.add(bt_2);
		buttonList.add(bt_3);
		buttonList.add(bt_4);
		buttonList.add(bt_5);
		buttonList.add(bt_6);
		buttonList.add(bt_7);
		buttonList.add(bt_8);
		buttonList.add(bt_9);
		buttonList.add(bt_10);

		idList.add(lb_ID_1);
		idList.add(lb_ID_2);
		idList.add(lb_ID_3);
		idList.add(lb_ID_4);
		idList.add(lb_ID_5);
		idList.add(lb_ID_6);
		idList.add(lb_ID_7);
		idList.add(lb_ID_8);
		idList.add(lb_ID_9);
		idList.add(lb_ID_10);

		timeList.add(lb_TIME_1);
		timeList.add(lb_TIME_2);
		timeList.add(lb_TIME_3);
		timeList.add(lb_TIME_4);
		timeList.add(lb_TIME_5);
		timeList.add(lb_TIME_6);
		timeList.add(lb_TIME_7);
		timeList.add(lb_TIME_8);
		timeList.add(lb_TIME_9);
		timeList.add(lb_TIME_10);

		// 위치잡아주기
<<<<<<< HEAD
		pl_1.setBounds(48, 46, 212, 168);
		pl_2.setBounds(344, 46, 212, 168);
		pl_3.setBounds(631, 46, 212, 168);
		pl_4.setBounds(48, 293, 212, 168);
		pl_5.setBounds(344, 293, 212, 168);
		pl_6.setBounds(631, 293, 212, 168);
		pl_7.setBounds(48, 534, 212, 168);
		pl_8.setBounds(344, 534, 212, 168);
		pl_9.setBounds(631, 534, 212, 168);
		pl_10.setBounds(631, 785, 212, 168);
=======
		pl_1.setBounds(183, 260, 425, 170);
		pl_2.setBounds(701, 260, 425, 170);
		pl_3.setBounds(1256, 260, 425, 170);
		pl_4.setBounds(14, 555, 425, 170);
		pl_5.setBounds(490, 555, 425, 170);
		pl_6.setBounds(980, 555, 425, 170);
		pl_7.setBounds(1459, 555, 425, 170);
		pl_8.setBounds(143, 856, 425, 170);
		pl_9.setBounds(663, 856, 425, 170);
		pl_10.setBounds(1182, 856, 425, 170);
>>>>>>> KH_MiniProject/hyunwoo

		bt_1.setBounds(0, 0, 212, 168);
		bt_2.setBounds(0, 0, 212, 168);
		bt_4.setBounds(0, 0, 212, 168);
		bt_5.setBounds(0, 0, 212, 168);
		bt_6.setBounds(0, 0, 212, 168);
		bt_7.setBounds(0, 0, 212, 168);
		bt_8.setBounds(0, 0, 212, 168);
		bt_9.setBounds(0, 0, 212, 168);
		bt_10.setBounds(0, 0, 212, 168);

		lb_ID_1.setBounds(30, 62, 147, 31);
		lb_ID_2.setBounds(31, 62, 147, 31);
		lb_ID_3.setBounds(30, 61, 147, 31);
		lb_ID_4.setBounds(29, 66, 147, 31);
		lb_ID_5.setBounds(31, 63, 147, 31);
		lb_ID_6.setBounds(34, 64, 147, 31);
		lb_ID_7.setBounds(29, 67, 147, 31);
		lb_ID_8.setBounds(32, 68, 147, 31);
		lb_ID_9.setBounds(32, 67, 147, 31);
		lb_ID_10.setBounds(36, 67, 147, 31);

		lb_TIME_1.setBounds(30, 102, 147, 31);
		lb_TIME_2.setBounds(31, 102, 147, 31);
		lb_TIME_3.setBounds(30, 101, 147, 31);
		lb_TIME_4.setBounds(29, 106, 147, 31);
		lb_TIME_5.setBounds(31, 103, 147, 31);
		lb_TIME_6.setBounds(34, 104, 147, 31);
		lb_TIME_7.setBounds(29, 107, 147, 31);
		lb_TIME_8.setBounds(32, 108, 147, 31);
		lb_TIME_9.setBounds(32, 107, 147, 31);
		lb_TIME_10.setBounds(36, 107, 147, 31);

		// 바탕패널에 추가
		panel.add(pl_1);
		panel.add(pl_2);
		panel.add(pl_3);
		panel.add(pl_4);
		panel.add(pl_5);
		panel.add(pl_6);
		panel.add(pl_7);
		panel.add(pl_8);
		panel.add(pl_9);
		panel.add(pl_10);

		for (int i = 0; i < single.serCtrl.getSeatList().length; i++) {
			String temp[] = single.serCtrl.getSeatList();
			String idTemp[] = single.serCtrl.getLoginId();
			if (temp[i].equals("1")) {
				// Panel
				panelList.get(i).setBackground(Color.RED);
				panelList.get(i).setLayout(null);
				panel.add(panelList.get(i));
				// Button
				buttonList.get(i).setEnabled(true);
				buttonList.get(i).setOpaque(false);
				buttonList.get(i).setContentAreaFilled(false);
				buttonList.get(i).setBorder(null);
				// ID
				idList.get(i).setText("ID : " + idTemp[i]);
				idList.get(i).setFont(new Font("굴림", Font.BOLD, 18));
				idList.get(i).setForeground(Color.WHITE);
				idList.get(i).setHorizontalAlignment(SwingConstants.CENTER);
				// TIME
				timeList.get(i).setText("TIME : ");
				timeList.get(i).setHorizontalAlignment(SwingConstants.CENTER);
				timeList.get(i).setForeground(Color.WHITE);
				timeList.get(i).setFont(new Font("굴림", Font.BOLD, 18));
			} else {
				// Panel
				panelList.get(i).setBackground(Color.BLUE);
				panelList.get(i).setLayout(null);
				panel.add(panelList.get(i));
				// Button
				buttonList.get(i).setEnabled(false);
				buttonList.get(i).setOpaque(false);
				buttonList.get(i).setContentAreaFilled(false);
				buttonList.get(i).setBorder(null);
				// ID
				idList.get(i).setText("");
				idList.get(i).setFont(new Font("굴림", Font.BOLD, 18));
				idList.get(i).setForeground(Color.WHITE);
				idList.get(i).setHorizontalAlignment(SwingConstants.CENTER);
				// TIME
				timeList.get(i).setText("");
				timeList.get(i).setHorizontalAlignment(SwingConstants.CENTER);
				timeList.get(i).setForeground(Color.WHITE);
				timeList.get(i).setFont(new Font("굴림", Font.BOLD, 18));
			}
		}
		pl_1.add(lb_ID_1);
		pl_1.add(lb_TIME_1);
		pl_1.add(bt_1);

		pl_2.add(bt_2);
		pl_2.add(lb_TIME_2);
		pl_2.add(lb_ID_2);

		pl_3.add(bt_3);
		pl_3.add(lb_TIME_3);
		pl_3.add(lb_ID_3);

		pl_4.add(bt_4);
		pl_4.add(lb_TIME_4);
		pl_4.add(lb_ID_4);

		pl_5.add(bt_5);
		pl_5.add(lb_TIME_5);
		pl_5.add(lb_ID_5);

		pl_6.add(bt_6);
		pl_6.add(lb_TIME_6);
		pl_6.add(lb_ID_6);

		pl_7.add(bt_7);
		pl_7.add(lb_TIME_7);
		pl_7.add(lb_ID_7);

		pl_8.add(bt_8);
		pl_8.add(lb_TIME_8);
		pl_8.add(lb_ID_8);

		pl_9.add(bt_9);
		pl_9.add(lb_TIME_9);
		pl_9.add(lb_ID_9);

		pl_10.add(bt_10);
		pl_10.add(lb_TIME_10);
		pl_10.add(lb_ID_10);

		// PC Seat Number
		lb_pc_1 = new JLabel("1");
		lb_pc_1.setForeground(Color.WHITE);
		lb_pc_1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_pc_1.setFont(new Font("굴림", Font.BOLD, 25));
		lb_pc_1.setBounds(5, 5, 55, 40);
		pl_1.add(lb_pc_1);

		lb_pc_2 = new JLabel("2");
		lb_pc_2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_pc_2.setForeground(Color.WHITE);
		lb_pc_2.setFont(new Font("굴림", Font.BOLD, 25));
		lb_pc_2.setBounds(4, 6, 55, 40);
		pl_2.add(lb_pc_2);

		lb_pc_3 = new JLabel("3");
		lb_pc_3.setHorizontalAlignment(SwingConstants.CENTER);
		lb_pc_3.setForeground(Color.WHITE);
		lb_pc_3.setFont(new Font("굴림", Font.BOLD, 25));
		lb_pc_3.setBounds(4, 4, 55, 40);
		pl_3.add(lb_pc_3);

		lb_pc_4 = new JLabel("4");
		lb_pc_4.setHorizontalAlignment(SwingConstants.CENTER);
		lb_pc_4.setForeground(Color.WHITE);
		lb_pc_4.setFont(new Font("굴림", Font.BOLD, 25));
		lb_pc_4.setBounds(4, 5, 55, 40);
		pl_4.add(lb_pc_4);

		lb_pc_5 = new JLabel("5");
		lb_pc_5.setHorizontalAlignment(SwingConstants.CENTER);
		lb_pc_5.setForeground(Color.WHITE);
		lb_pc_5.setFont(new Font("굴림", Font.BOLD, 25));
		lb_pc_5.setBounds(4, 5, 55, 40);
		pl_5.add(lb_pc_5);

		lb_pc_6 = new JLabel("6");
		lb_pc_6.setHorizontalAlignment(SwingConstants.CENTER);
		lb_pc_6.setForeground(Color.WHITE);
		lb_pc_6.setFont(new Font("굴림", Font.BOLD, 25));
		lb_pc_6.setBounds(5, 4, 55, 40);
		pl_6.add(lb_pc_6);

		lb_pc_7 = new JLabel("7");
		lb_pc_7.setHorizontalAlignment(SwingConstants.CENTER);
		lb_pc_7.setForeground(Color.WHITE);
		lb_pc_7.setFont(new Font("굴림", Font.BOLD, 25));
		lb_pc_7.setBounds(4, 6, 55, 40);
		pl_7.add(lb_pc_7);

		lb_pc_8 = new JLabel("8");
		lb_pc_8.setHorizontalAlignment(SwingConstants.CENTER);
		lb_pc_8.setForeground(Color.WHITE);
		lb_pc_8.setFont(new Font("굴림", Font.BOLD, 25));
		lb_pc_8.setBounds(5, 4, 55, 40);
		pl_8.add(lb_pc_8);

		lb_pc_9 = new JLabel("9");
		lb_pc_9.setHorizontalAlignment(SwingConstants.CENTER);
		lb_pc_9.setForeground(Color.WHITE);
		lb_pc_9.setFont(new Font("굴림", Font.BOLD, 25));
		lb_pc_9.setBounds(5, 5, 55, 40);
		pl_9.add(lb_pc_9);

		lb_pc_10 = new JLabel("10");
		lb_pc_10.setHorizontalAlignment(SwingConstants.CENTER);
		lb_pc_10.setForeground(Color.WHITE);
		lb_pc_10.setFont(new Font("굴림", Font.BOLD, 25));
		lb_pc_10.setBounds(7, 6, 55, 40);
		pl_10.add(lb_pc_10);

		bt_1.addActionListener(this);
		bt_2.addActionListener(this);
		bt_3.addActionListener(this);
		bt_4.addActionListener(this);
		bt_5.addActionListener(this);
		bt_6.addActionListener(this);
		bt_7.addActionListener(this);
		bt_8.addActionListener(this);
		bt_9.addActionListener(this);
		bt_10.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 종료
		setBounds(0, 0, 1920, 1080);// 전체 화면 조절
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 주문확인(ok)
		Object obj = e.getSource();
<<<<<<< HEAD
		if (obj == bt_order) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					OrderView frame = new OrderView();
					frame.setVisible(true);
				}
			});
			// 회원정보 (ok)
		} else if (obj == bt_member) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					ManageMemView frame = new ManageMemView();
					frame.setVisible(true);
				}
			});
			// 게시판(ok)
		} else if (obj == bt_bbs) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					Singleton single = Singleton.getInstance();
					single.bbsCtrl.getBbsList();
				}
			});
=======

		// 회원정보view
		if (obj == bt_member) {
			single.memCtrl.manager();

			// 게시판 List
		} else if (obj == bt_bbs) {
			single.bbsCtrl.drawBbsList();

			// 주문 OrderView
		} else if (obj == bt_order) {
			single.bbsCtrl.order();
>>>>>>> KH_MiniProject/hyunwoo

		} else if (obj == bt_1) {
			selectSeat = 0;
			single.serCtrl.chatView(selectSeat);
<<<<<<< HEAD
			System.out.println("test" + selectSeat);
		} else if (obj == bt_2) {
			selectSeat = 1;
			single.serCtrl.chatView(selectSeat);
			System.out.println("test" + selectSeat);
		} else if (obj == bt_3) {
			selectSeat = 2;
			single.serCtrl.chatView(selectSeat);
			System.out.println("test" + selectSeat);
		} else if (obj == bt_4) {
			selectSeat = 3;
			single.serCtrl.chatView(selectSeat);
			System.out.println("test" + selectSeat);
		} else if (obj == bt_5) {
			selectSeat = 4;
			single.serCtrl.chatView(selectSeat);
			System.out.println("test" + selectSeat);
		} else if (obj == bt_6) {
			selectSeat = 5;
			single.serCtrl.chatView(selectSeat);
			System.out.println("test" + selectSeat);
		} else if (obj == bt_7) {
			selectSeat = 6;
			single.serCtrl.chatView(selectSeat);
			System.out.println("test" + selectSeat);
		} else if (obj == bt_8) {
			selectSeat = 7;
			single.serCtrl.chatView(selectSeat);
			System.out.println("test" + selectSeat);
		} else if (obj == bt_9) {
			selectSeat = 8;
			single.serCtrl.chatView(selectSeat);
			System.out.println("test" + selectSeat);
		} else if (obj == bt_10) {
			selectSeat = 9;
			single.serCtrl.chatView(selectSeat);
			System.out.println("test" + selectSeat);
=======
		} else if (obj == bt_2) {
			selectSeat = 1;
			single.serCtrl.chatView(selectSeat);
		} else if (obj == bt_3) {
			selectSeat = 2;
			single.serCtrl.chatView(selectSeat);
		} else if (obj == bt_4) {
			selectSeat = 3;
			single.serCtrl.chatView(selectSeat);
		} else if (obj == bt_5) {
			selectSeat = 4;
			single.serCtrl.chatView(selectSeat);
		} else if (obj == bt_6) {
			selectSeat = 5;
			single.serCtrl.chatView(selectSeat);
		} else if (obj == bt_7) {
			selectSeat = 6;
			single.serCtrl.chatView(selectSeat);
		} else if (obj == bt_8) {
			selectSeat = 7;
			single.serCtrl.chatView(selectSeat);
		} else if (obj == bt_9) {
			selectSeat = 8;
			single.serCtrl.chatView(selectSeat);
		} else if (obj == bt_10) {
			selectSeat = 9;
			single.serCtrl.chatView(selectSeat);
>>>>>>> KH_MiniProject/hyunwoo
		}
	}
}