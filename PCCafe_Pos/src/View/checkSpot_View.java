package View;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.POS_Dao;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class checkSpot_View extends JFrame implements ActionListener {
	private POS_Dao dao = POS_Dao.getInstance();
	private JButton bt_back;
	private JPanel seat_1, seat_2, seat_3, seat_4, seat_5, seat_6, seat_7, seat_8, seat_9, seat_10;
	private ArrayList<JPanel> seat;
	private ArrayList<JLabel> lbList;
	private JLabel lb_swit_1, lb_swit_2, lb_swit_3, lb_swit_4, lb_swit_5, lb_swit_6, lb_swit_7, lb_swit_8, lb_swit_9,
			lb_swit_10;
	private JLabel lb_num_1, lb_num_2, lb_num_3, lb_num_4, lb_num_5, lb_num_6, lb_num_7, lb_num_8, lb_num_9, lb_num_10;

	public checkSpot_View() {
		seat = new ArrayList<>();
		lbList = new ArrayList<>();

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

		JPanel pl_text = new JPanel();
		pl_text.setBackground(Color.WHITE);
		pl_text.setBounds(25, 77, 1885, 75);
		contentPane.add(pl_text);
		pl_text.setLayout(null);

		JLabel lb_text = new JLabel("원하시는 자리를 선택하여 주세요");
		lb_text.setFont(new Font("굴림", Font.PLAIN, 18));
		lb_text.setHorizontalAlignment(SwingConstants.CENTER);
		lb_text.setBounds(512, 12, 799, 51);
		pl_text.add(lb_text);

		ImageIcon icon_1 = new ImageIcon("MAP.png");
		JPanel pl_map = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon_1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);

			}
		};
		pl_map.setLayout(null);
		pl_map.setBounds(24, 164, 1886, 854);
		contentPane.add(pl_map);

		seat_1 = new JPanel();
		seat_2 = new JPanel();
		seat_3 = new JPanel();
		seat_4 = new JPanel();
		seat_5 = new JPanel();
		seat_6 = new JPanel();
		seat_7 = new JPanel();
		seat_8 = new JPanel();
		seat_9 = new JPanel();
		seat_10 = new JPanel();

		lb_num_1 = new JLabel("1");
		lb_num_2 = new JLabel("2");
		lb_num_3 = new JLabel("3");
		lb_num_4 = new JLabel("4");
		lb_num_5 = new JLabel("5");
		lb_num_6 = new JLabel("6");
		lb_num_7 = new JLabel("7");
		lb_num_8 = new JLabel("8");
		lb_num_9 = new JLabel("9");
		lb_num_10 = new JLabel("10");

		lb_swit_1 = new JLabel();
		lb_swit_2 = new JLabel();
		lb_swit_3 = new JLabel();
		lb_swit_4 = new JLabel();
		lb_swit_5 = new JLabel();
		lb_swit_6 = new JLabel();
		lb_swit_7 = new JLabel();
		lb_swit_8 = new JLabel();
		lb_swit_9 = new JLabel();
		lb_swit_10 = new JLabel();

		seat.add(seat_1);
		seat.add(seat_2);
		seat.add(seat_3);
		seat.add(seat_4);
		seat.add(seat_5);
		seat.add(seat_6);
		seat.add(seat_7);
		seat.add(seat_8);
		seat.add(seat_9);
		seat.add(seat_10);

		lbList.add(lb_swit_1);
		lbList.add(lb_swit_2);
		lbList.add(lb_swit_3);
		lbList.add(lb_swit_4);
		lbList.add(lb_swit_5);
		lbList.add(lb_swit_6);
		lbList.add(lb_swit_7);
		lbList.add(lb_swit_8);
		lbList.add(lb_swit_9);
		lbList.add(lb_swit_10);

		for (int i = 0; i < dao.serCtrl.getCheckSpot().size(); i++) {
			if (dao.serCtrl.getCheckSpot().get(i).equals("1")) {
				// Panel
				seat.get(i).setBackground(Color.RED);
				seat.get(i).setLayout(null);
				pl_map.add(seat.get(i));
				// Label
				lbList.get(i).setText("ON");
				lbList.get(i).setForeground(Color.WHITE);
				lbList.get(i).setHorizontalAlignment(SwingConstants.CENTER);
				lbList.get(i).setFont(new Font("Georgia", Font.BOLD, 18));
			} else {
				// Panel
				seat.get(i).setBackground(Color.BLUE);
				seat.get(i).setLayout(null);
				pl_map.add(seat.get(i));
				// Label
				lbList.get(i).setText("OFF");
				lbList.get(i).setForeground(Color.WHITE);
				lbList.get(i).setHorizontalAlignment(SwingConstants.CENTER);
				lbList.get(i).setFont(new Font("Georgia", Font.BOLD, 18));
			}
		}

		seat_1.setBounds(365, 95, 195, 221);
		seat_2.setBounds(605, 95, 195, 221);
		seat_3.setBounds(856, 95, 195, 221);
		seat_4.setBounds(1129, 95, 195, 221);
		seat_5.setBounds(1391, 95, 195, 221);
		seat_6.setBounds(539, 427, 195, 221);
		seat_7.setBounds(779, 427, 195, 221);
		seat_8.setBounds(1030, 427, 195, 221);
		seat_9.setBounds(1303, 427, 195, 221);
		seat_10.setBounds(1565, 427, 195, 221);

		// 머신 넘버
		lb_num_1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_num_1.setForeground(Color.WHITE);
		lb_num_1.setFont(new Font("Georgia", Font.BOLD, 25));
		lb_num_1.setBounds(0, 0, 51, 43);
		seat_1.add(lb_num_1);

		lb_num_2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_num_2.setForeground(Color.WHITE);
		lb_num_2.setFont(new Font("Georgia", Font.BOLD, 25));
		lb_num_2.setBounds(0, 0, 51, 43);
		seat_2.add(lb_num_2);

		lb_num_3.setHorizontalAlignment(SwingConstants.CENTER);
		lb_num_3.setForeground(Color.WHITE);
		lb_num_3.setFont(new Font("Georgia", Font.BOLD, 25));
		lb_num_3.setBounds(0, 0, 51, 43);
		seat_3.add(lb_num_3);

		lb_num_4.setHorizontalAlignment(SwingConstants.CENTER);
		lb_num_4.setForeground(Color.WHITE);
		lb_num_4.setFont(new Font("Georgia", Font.BOLD, 25));
		lb_num_4.setBounds(0, 0, 51, 43);
		seat_4.add(lb_num_4);

		lb_num_5.setHorizontalAlignment(SwingConstants.CENTER);
		lb_num_5.setForeground(Color.WHITE);
		lb_num_5.setFont(new Font("Georgia", Font.BOLD, 25));
		lb_num_5.setBounds(0, 0, 51, 43);
		seat_5.add(lb_num_5);

		lb_num_6.setHorizontalAlignment(SwingConstants.CENTER);
		lb_num_6.setForeground(Color.WHITE);
		lb_num_6.setFont(new Font("Georgia", Font.BOLD, 25));
		lb_num_6.setBounds(0, 0, 51, 43);
		seat_6.add(lb_num_6);

		lb_num_7.setHorizontalAlignment(SwingConstants.CENTER);
		lb_num_7.setForeground(Color.WHITE);
		lb_num_7.setFont(new Font("Georgia", Font.BOLD, 25));
		lb_num_7.setBounds(0, 0, 51, 43);
		seat_7.add(lb_num_7);

		lb_num_8.setHorizontalAlignment(SwingConstants.CENTER);
		lb_num_8.setForeground(Color.WHITE);
		lb_num_8.setFont(new Font("Georgia", Font.BOLD, 25));
		lb_num_8.setBounds(0, 0, 51, 43);
		seat_8.add(lb_num_8);

		lb_num_9.setHorizontalAlignment(SwingConstants.CENTER);
		lb_num_9.setForeground(Color.WHITE);
		lb_num_9.setFont(new Font("Georgia", Font.BOLD, 25));
		lb_num_9.setBounds(0, 0, 51, 43);
		seat_9.add(lb_num_9);

		lb_num_10.setHorizontalAlignment(SwingConstants.CENTER);
		lb_num_10.setForeground(Color.WHITE);
		lb_num_10.setFont(new Font("Georgia", Font.BOLD, 25));
		lb_num_10.setBounds(0, 0, 51, 43);
		seat_10.add(lb_num_10);

		// 자리 상태
		lb_swit_1.setBounds(68, 79, 51, 43);
		seat_1.add(lb_swit_1);

		lb_swit_2.setBounds(68, 79, 51, 43);
		seat_2.add(lb_swit_2);

		lb_swit_3.setBounds(68, 79, 51, 43);
		seat_3.add(lb_swit_3);

		lb_swit_4.setBounds(68, 79, 51, 43);
		seat_4.add(lb_swit_4);

		lb_swit_5.setBounds(68, 79, 51, 43);
		seat_5.add(lb_swit_5);

		lb_swit_6.setBounds(68, 79, 51, 43);
		seat_6.add(lb_swit_6);

		lb_swit_7.setBounds(68, 79, 51, 43);
		seat_7.add(lb_swit_7);

		lb_swit_8.setBounds(68, 79, 51, 43);
		seat_8.add(lb_swit_8);

		lb_swit_9.setBounds(68, 79, 51, 43);
		seat_9.add(lb_swit_9);

		lb_swit_10.setBounds(68, 79, 51, 43);
		seat_10.add(lb_swit_10);

		bt_back = new JButton("메인으로");
		bt_back.setBounds(1511, 748, 337, 81);
		pl_map.add(bt_back);
		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bt_back.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		POS_Dao dao = POS_Dao.getInstance();
		Object obj = e.getSource();
		if (obj == bt_back) {
			dao.mainView();
			this.dispose();
		}
	}
}