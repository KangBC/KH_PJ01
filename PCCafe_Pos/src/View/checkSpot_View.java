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

	public checkSpot_View() {
		seat = new ArrayList<>();

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
		pl_text.setBounds(14, 77, 1886, 75);
		contentPane.add(pl_text);
		pl_text.setLayout(null);

		JLabel lb_text = new JLabel("원하시는 자리를 선택하여 주세요");
		lb_text.setFont(new Font("굴림", Font.PLAIN, 18));
		lb_text.setHorizontalAlignment(SwingConstants.CENTER);
		lb_text.setBounds(512, 12, 799, 51);
		pl_text.add(lb_text);

		JPanel pl_map = new JPanel();
		pl_map.setBackground(Color.WHITE);
		pl_map.setBounds(24, 164, 1886, 854);
		contentPane.add(pl_map);
		pl_map.setLayout(null);

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

		for (int i = 0; i < dao.serCtrl.getCheckSpot().size(); i++) {
			if (dao.serCtrl.getCheckSpot().get(i).equals("1")) {
				seat.get(i).setBackground(Color.RED);
				seat.get(i).setLayout(null);
				pl_map.add(seat.get(i));
			} else {
				seat.get(i).setBackground(Color.BLUE);
				seat.get(i).setLayout(null);
				pl_map.add(seat.get(i));
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