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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;

public class checkSpot_View extends JFrame implements ActionListener {

	JButton bt_back;

	public checkSpot_View() {
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

		JLabel lblNewLabel = new JLabel("원하시는 자리를 선택하여 주세요");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(512, 12, 799, 51);
		pl_text.add(lblNewLabel);

		JPanel pl_map = new JPanel();
		pl_map.setBackground(Color.WHITE);
		pl_map.setBounds(14, 179, 1886, 854);
		contentPane.add(pl_map);
		pl_map.setLayout(null);

		JPanel seat_1 = new JPanel();
		seat_1.setBounds(365, 95, 195, 221);
		pl_map.add(seat_1);
		seat_1.setLayout(null);

		JLabel no_1 = new JLabel("NO.1");
		no_1.setHorizontalAlignment(SwingConstants.CENTER);
		no_1.setBounds(0, 0, 56, 52);
		seat_1.add(no_1);

		JLabel lblNewLabel_1 = new JLabel("ON/OFF");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(49, 96, 88, 36);
		seat_1.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(605, 95, 195, 221);
		pl_map.add(panel);

		JLabel label = new JLabel("NO.1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 56, 52);
		panel.add(label);

		JLabel label_1 = new JLabel("ON/OFF");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(49, 96, 88, 36);
		panel.add(label_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(856, 95, 195, 221);
		pl_map.add(panel_1);

		JLabel label_2 = new JLabel("NO.1");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(0, 0, 56, 52);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("ON/OFF");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(49, 96, 88, 36);
		panel_1.add(label_3);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(1129, 95, 195, 221);
		pl_map.add(panel_2);

		JLabel label_4 = new JLabel("NO.1");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(0, 0, 56, 52);
		panel_2.add(label_4);

		JLabel label_5 = new JLabel("ON/OFF");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(49, 96, 88, 36);
		panel_2.add(label_5);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(1391, 95, 195, 221);
		pl_map.add(panel_3);

		JLabel label_6 = new JLabel("NO.1");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(0, 0, 56, 52);
		panel_3.add(label_6);

		JLabel label_7 = new JLabel("ON/OFF");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(49, 96, 88, 36);
		panel_3.add(label_7);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(539, 427, 195, 221);
		pl_map.add(panel_4);

		JLabel label_8 = new JLabel("NO.1");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(0, 0, 56, 52);
		panel_4.add(label_8);

		JLabel label_9 = new JLabel("ON/OFF");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(49, 96, 88, 36);
		panel_4.add(label_9);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(779, 427, 195, 221);
		pl_map.add(panel_5);

		JLabel label_10 = new JLabel("NO.1");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(0, 0, 56, 52);
		panel_5.add(label_10);

		JLabel label_11 = new JLabel("ON/OFF");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(49, 96, 88, 36);
		panel_5.add(label_11);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(1030, 427, 195, 221);
		pl_map.add(panel_6);

		JLabel label_12 = new JLabel("NO.1");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(0, 0, 56, 52);
		panel_6.add(label_12);

		JLabel label_13 = new JLabel("ON/OFF");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(49, 96, 88, 36);
		panel_6.add(label_13);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(1303, 427, 195, 221);
		pl_map.add(panel_7);

		JLabel label_14 = new JLabel("NO.1");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(0, 0, 56, 52);
		panel_7.add(label_14);

		JLabel label_15 = new JLabel("ON/OFF");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBounds(49, 96, 88, 36);
		panel_7.add(label_15);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(1565, 427, 195, 221);
		pl_map.add(panel_8);

		JLabel label_16 = new JLabel("NO.1");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setBounds(0, 0, 56, 52);
		panel_8.add(label_16);

		JLabel label_17 = new JLabel("ON/OFF");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setBounds(49, 96, 88, 36);
		panel_8.add(label_17);

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