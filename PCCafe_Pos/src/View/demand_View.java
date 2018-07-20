package View;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.POS_Dao;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class demand_View extends JFrame implements ActionListener {
	private POS_Dao dao = POS_Dao.getInstance();
	private JButton btnNewButton, bt_1won, bt_5won, bt_10won;
	private JLabel lb_choprice, lb_InsertCoin, lb_change, lb_insertMoney;
	javax.swing.Timer tm;
	int x = 0;
	String[] list = { "1.JPG", "2.JPG" };

	public demand_View() {
		// Initialize Variable
		dao.setInsertMoney(0);

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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(717, 202, 480, 640);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("지폐를 넣어주세요");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(39, 34, 402, 85);
		panel.add(lblNewLabel);

		btnNewButton = new JButton("결제하기");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 18));
		btnNewButton.setBounds(143, 548, 194, 67);
		btnNewButton.setEnabled(false);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(69, 122, 341, 217);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("지불금액 : ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setBounds(14, 62, 130, 47);
		panel_1.add(label);

		JLabel label_1 = new JLabel("결제가격 : ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("굴림", Font.BOLD, 20));
		label_1.setBounds(14, 23, 130, 47);
		panel_1.add(label_1);

		lb_choprice = new JLabel(dao.getChoPrice() + "");
		lb_choprice.setHorizontalAlignment(SwingConstants.CENTER);
		lb_choprice.setFont(new Font("굴림", Font.BOLD, 20));
		lb_choprice.setBounds(158, 23, 157, 47);
		panel_1.add(lb_choprice);

		JLabel label_2 = new JLabel("거스름돈 : ");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("굴림", Font.BOLD, 20));
		label_2.setBounds(14, 104, 130, 47);
		panel_1.add(label_2);

		lb_change = new JLabel("0 원");
		lb_change.setHorizontalAlignment(SwingConstants.CENTER);
		lb_change.setFont(new Font("굴림", Font.BOLD, 20));
		lb_change.setBounds(158, 104, 157, 47);
		panel_1.add(lb_change);

		lb_insertMoney = new JLabel("0 원");
		lb_insertMoney.setHorizontalAlignment(SwingConstants.CENTER);
		lb_insertMoney.setFont(new Font("굴림", Font.BOLD, 20));
		lb_insertMoney.setBounds(158, 62, 157, 47);
		panel_1.add(lb_insertMoney);

		bt_1won = new JButton("1,000원");
		bt_1won.setFont(new Font("굴림", Font.BOLD, 15));
		bt_1won.setBounds(14, 151, 98, 47);
		panel_1.add(bt_1won);

		bt_10won = new JButton("10,000원");
		bt_10won.setFont(new Font("굴림", Font.BOLD, 13));
		bt_10won.setBounds(229, 151, 98, 47);
		panel_1.add(bt_10won);

		bt_5won = new JButton("5,000원");
		bt_5won.setFont(new Font("굴림", Font.BOLD, 15));
		bt_5won.setBounds(122, 151, 98, 47);
		panel_1.add(bt_5won);

		lb_InsertCoin = new JLabel();
		lb_InsertCoin.setBounds(69, 361, 341, 178);
		SetImageSize(1);

		tm = new javax.swing.Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SetImageSize(x);
				x += 1;
				if (x >= list.length) {
					x = 0;
				}
			}
		});
		panel.add(lb_InsertCoin);
		tm.start();

		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnNewButton.addActionListener(this);
		bt_1won.addActionListener(this);
		bt_5won.addActionListener(this);
		bt_10won.addActionListener(this);
	}

	public void SetImageSize(int i) {
		ImageIcon icon = new ImageIcon(list[i]);
		Image img = icon.getImage();
		Component lblNewLabel;
		Image newImg = img.getScaledInstance(lb_InsertCoin.getWidth(), lb_InsertCoin.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		lb_InsertCoin.setIcon(newImc);
	}

	public void exChangeM(int money) {
		dao.setInsertMoney(dao.getInsertMoney() + money);
		lb_insertMoney.setText(dao.getInsertMoney() + " 원");
		if (dao.getChoPrice() - dao.getInsertMoney() > 0) {
			return;
		} else if (dao.getChoPrice() - dao.getInsertMoney() == 0) {
			btnNewButton.setEnabled(true);
			return;
		} else if (dao.getChoPrice() - dao.getInsertMoney() < 0) {
			btnNewButton.setEnabled(true);
			int temp1 = dao.getChoPrice() - dao.getInsertMoney();
			lb_change.setText(-temp1 + " 원");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnNewButton) {
			if (dao.inputTime(dao.getUserDto().getSeq(), dao.getChoTime() + dao.getUserDto().getTime())) {
				dao.setChoPrice(0);
				dao.setUserDto(null);
				JOptionPane.showMessageDialog(null, "성공적으로 시간추가 되었습니다.");
				dao.mainView();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "시간추가 오류입니다.");
			}
		} else if (obj == bt_1won) {
			exChangeM(1000);
		} else if (obj == bt_5won) {
			exChangeM(5000);
		} else if (obj == bt_10won) {
			exChangeM(10000);
		}
	}
}