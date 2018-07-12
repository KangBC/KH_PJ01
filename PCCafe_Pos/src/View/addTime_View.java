package View;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.POS_Dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;

public class addTime_View extends JFrame implements ActionListener {
	private POS_Dao dao = POS_Dao.getInstance();
	private JTextField tf_ID;
	private JLabel lb_dto_ID;
	private JTextField txtTest;
	private JTextField textField_1;
	private JButton bt_ID, bt_Insert, bt_Back, bt_time_1, bt_time_2, bt_time_3, bt_time_4, bt_time_5;
	private JLabel lb_cho_time, lb_cho_price;

	public addTime_View() {
		ImageIcon icon = new ImageIcon("backGround.jpg");
		JPanel contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pl_mid = new JPanel();
		pl_mid.setBounds(49, 45, 1816, 979);
		contentPane.add(pl_mid);
		pl_mid.setLayout(null);

		JPanel pl_mid_3 = new JPanel();
		pl_mid_3.setBounds(1074, 0, 742, 490);
		pl_mid_3.setBackground(Color.BLACK);
		pl_mid.add(pl_mid_3);
		pl_mid_3.setLayout(null);

		JPanel pl_title_3 = new JPanel();
		pl_title_3.setForeground(Color.BLACK);
		pl_title_3.setBackground(Color.LIGHT_GRAY);
		pl_title_3.setBounds(0, 0, 742, 90);
		pl_mid_3.add(pl_title_3);
		pl_title_3.setLayout(null);

		JLabel lb_IDCheck = new JLabel("ID 확인");
		lb_IDCheck.setFont(new Font("굴림", Font.BOLD, 20));
		lb_IDCheck.setHorizontalAlignment(SwingConstants.CENTER);
		lb_IDCheck.setBounds(0, 0, 126, 89);
		pl_title_3.add(lb_IDCheck);

		lb_dto_ID = new JLabel("ID : ");
		lb_dto_ID.setForeground(Color.WHITE);
		lb_dto_ID.setFont(new Font("굴림", Font.BOLD, 18));
		lb_dto_ID.setHorizontalAlignment(SwingConstants.CENTER);
		lb_dto_ID.setBounds(147, 119, 112, 52);
		pl_mid_3.add(lb_dto_ID);

		txtTest = new JTextField();
		txtTest.setHorizontalAlignment(SwingConstants.CENTER);
		txtTest.setText("TEST");
		txtTest.setBounds(265, 119, 246, 52);
		pl_mid_3.add(txtTest);
		txtTest.setColumns(10);

		JLabel label = new JLabel("남은시간 : ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 18));
		label.setBounds(147, 196, 112, 52);
		pl_mid_3.add(label);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("굴림", Font.BOLD, 50));
		textField_1.setText("3 : 23");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(157, 260, 444, 186);
		pl_mid_3.add(textField_1);
		textField_1.setColumns(10);

		JPanel pl_mid_4 = new JPanel();
		pl_mid_4.setBounds(1074, 489, 742, 490);
		pl_mid_4.setBackground(Color.BLACK);
		pl_mid.add(pl_mid_4);
		pl_mid_4.setLayout(null);

		JPanel pl_titile_4 = new JPanel();
		pl_titile_4.setBackground(Color.LIGHT_GRAY);
		pl_titile_4.setBounds(0, 0, 742, 90);
		pl_mid_4.add(pl_titile_4);
		pl_titile_4.setLayout(null);

		JLabel lb_IDSearch = new JLabel("ID 검색");
		lb_IDSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lb_IDSearch.setFont(new Font("굴림", Font.BOLD, 20));
		lb_IDSearch.setBounds(0, 0, 126, 89);
		pl_titile_4.add(lb_IDSearch);

		tf_ID = new JTextField();
		tf_ID.setText("TEST");
		tf_ID.setFont(new Font("굴림", Font.BOLD, 23));
		tf_ID.setHorizontalAlignment(SwingConstants.CENTER);
		tf_ID.setBounds(49, 184, 511, 90);
		pl_mid_4.add(tf_ID);
		tf_ID.setColumns(10);

		bt_ID = new JButton("검색");
		bt_ID.setBounds(574, 184, 132, 90);
		pl_mid_4.add(bt_ID);

		bt_Back = new JButton("메인화면");
		bt_Back.setFont(new Font("굴림", Font.BOLD, 18));
		bt_Back.setBounds(393, 375, 312, 90);
		pl_mid_4.add(bt_Back);

		JPanel pl_mid_2 = new JPanel();
		pl_mid_2.setBackground(Color.BLACK);
		pl_mid_2.setBounds(0, 489, 1073, 490);
		pl_mid.add(pl_mid_2);
		pl_mid_2.setLayout(null);

		JPanel pl_title_2 = new JPanel();
		pl_title_2.setBackground(new Color(192, 192, 192));
		pl_title_2.setBounds(0, 0, 1073, 90);
		pl_mid_2.add(pl_title_2);
		pl_title_2.setLayout(null);

		JLabel label_2 = new JLabel("선택확인");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("굴림", Font.BOLD, 20));
		label_2.setBounds(0, 0, 160, 89);
		pl_title_2.add(label_2);

		bt_Insert = new JButton("결제하기");
		bt_Insert.setBounds(726, 372, 312, 90);
		pl_mid_2.add(bt_Insert);
		bt_Insert.setFont(new Font("굴림", Font.BOLD, 18));

		JPanel panel = new JPanel();
		panel.setBounds(51, 136, 627, 326);
		pl_mid_2.add(panel);
		panel.setLayout(null);

		JLabel mid_2_lb_time = new JLabel("시간 :");
		mid_2_lb_time.setFont(new Font("굴림", Font.BOLD, 40));
		mid_2_lb_time.setHorizontalAlignment(SwingConstants.CENTER);
		mid_2_lb_time.setBounds(107, 75, 148, 63);
		panel.add(mid_2_lb_time);

		JLabel mid_2_lb_price = new JLabel("상품가격 : ");
		mid_2_lb_price.setFont(new Font("굴림", Font.BOLD, 40));
		mid_2_lb_price.setHorizontalAlignment(SwingConstants.CENTER);
		mid_2_lb_price.setBounds(27, 178, 228, 63);
		panel.add(mid_2_lb_price);

		lb_cho_time = new JLabel(dao.getChoTime() + "");
		lb_cho_time.setFont(new Font("굴림", Font.BOLD, 40));
		lb_cho_time.setHorizontalAlignment(SwingConstants.CENTER);
		lb_cho_time.setBounds(250, 75, 321, 63);
		panel.add(lb_cho_time);

		lb_cho_price = new JLabel(dao.getChoPrice() + "");
		lb_cho_price.setFont(new Font("굴림", Font.BOLD, 40));
		lb_cho_price.setHorizontalAlignment(SwingConstants.CENTER);
		lb_cho_price.setBounds(269, 178, 281, 63);
		panel.add(lb_cho_price);

		JPanel pl_mid_1 = new JPanel();
		pl_mid_1.setBackground(Color.BLACK);
		pl_mid_1.setLayout(null);
		pl_mid_1.setBounds(0, 0, 1073, 490);
		pl_mid.add(pl_mid_1);

		JPanel pl_title_1 = new JPanel();
		pl_title_1.setBackground(new Color(192, 192, 192));
		pl_title_1.setLayout(null);
		pl_title_1.setBounds(0, 0, 1073, 90);
		pl_mid_1.add(pl_title_1);

		JLabel lb_struct = new JLabel("시간 & 가격");
		lb_struct.setForeground(Color.BLACK);
		lb_struct.setHorizontalAlignment(SwingConstants.CENTER);
		lb_struct.setFont(new Font("굴림", Font.BOLD, 20));
		lb_struct.setBounds(0, 0, 158, 89);
		pl_title_1.add(lb_struct);

		bt_time_1 = new JButton("1000원 1시간");
		bt_time_1.setBounds(54, 174, 171, 227);
		pl_mid_1.add(bt_time_1);

		bt_time_2 = new JButton("2000원 2시간+15분");
		bt_time_2.setBounds(250, 174, 171, 227);
		pl_mid_1.add(bt_time_2);

		bt_time_3 = new JButton("3000원 3시간+30분");
		bt_time_3.setBounds(447, 174, 171, 227);
		pl_mid_1.add(bt_time_3);

		bt_time_4 = new JButton("5000원 7시간+30분");
		bt_time_4.setBounds(643, 174, 171, 227);
		pl_mid_1.add(bt_time_4);

		bt_time_5 = new JButton("10000원 12시간");
		bt_time_5.setBounds(838, 174, 171, 227);
		pl_mid_1.add(bt_time_5);
		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bt_ID.addActionListener(this);
		bt_Insert.addActionListener(this);
		bt_Back.addActionListener(this);
		bt_time_1.addActionListener(this);
		bt_time_2.addActionListener(this);
		bt_time_3.addActionListener(this);
		bt_time_4.addActionListener(this);
		bt_time_5.addActionListener(this);
	}

	public void selectItem(int time, int price) {
		dao.setChoTime(time);
		dao.setChoPrice(price);
		lb_cho_time.setText(dao.getChoTime() / 60 + "시간" + dao.getChoTime() % 60 + "분");
		lb_cho_price.setText(dao.getChoPrice() + "원");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		POS_Dao dao = POS_Dao.getInstance();
		Object obj = e.getSource();
		if (obj == bt_Back) {
			dao.mainView();
			this.dispose();
		} else if (obj == bt_Insert) {
			dao.demandView();
			this.dispose();
		} else if (obj == bt_time_1) {
			selectItem(60, 1000);
		} else if (obj == bt_time_2) {
			selectItem(135, 2000);
		} else if (obj == bt_time_3) {
			selectItem(210, 3000);
		} else if (obj == bt_time_4) {
			selectItem(450, 5000);
		} else if (obj == bt_time_5) {
			selectItem(720, 10000);
		}
	}
}