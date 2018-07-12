package View;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.POS_Dao;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Choice;

public class demand_View extends JFrame implements ActionListener, ItemListener {
	private POS_Dao dao = POS_Dao.getInstance();
	private JButton btnNewButton;
	private Choice choice;
	private JLabel lb_choprice, lb_InsertCoin;
	javax.swing.Timer tm;
	int x = 0;
	String[] list = { "1.JPG", "2.JPG" };

	public demand_View() {
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
		lblNewLabel.setBounds(39, 35, 402, 106);
		panel.add(lblNewLabel);

		btnNewButton = new JButton("결제하기");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 18));
		btnNewButton.setBounds(143, 548, 194, 67);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(69, 153, 341, 186);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("지불금액 : ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setBounds(14, 98, 130, 47);
		panel_1.add(label);

		JLabel label_1 = new JLabel("결제가격 : ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("굴림", Font.BOLD, 20));
		label_1.setBounds(14, 28, 130, 47);
		panel_1.add(label_1);

		lb_choprice = new JLabel(dao.getChoPrice() + "");
		lb_choprice.setHorizontalAlignment(SwingConstants.CENTER);
		lb_choprice.setFont(new Font("굴림", Font.BOLD, 20));
		lb_choprice.setBounds(158, 28, 157, 47);
		panel_1.add(lb_choprice);

		choice = new Choice();
		choice.setBounds(192, 106, 88, 29);
		choice.add("선택");
		choice.add("1,000원");
		choice.add("2,000원");
		choice.add("3,000원");
		choice.add("5,000원");
		choice.add("10,000원");
		panel_1.add(choice);

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
		choice.addItemListener(this);
	}

	public void SetImageSize(int i) {
		ImageIcon icon = new ImageIcon(list[i]);
		Image img = icon.getImage();
		Component lblNewLabel;
		Image newImg = img.getScaledInstance(lb_InsertCoin.getWidth(), lb_InsertCoin.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		lb_InsertCoin.setIcon(newImc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnNewButton) {
			JOptionPane.showMessageDialog(null, "성공적으로 시간추가 되었습니다.");
			dao.mainView();
			this.dispose();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice cho = (Choice) e.getSource();
		String selected = cho.getSelectedItem();

		if (selected.equals("선택")) {
			dao.setInsertMoney(0);
			return;
		} else if (selected.equals("1,000원")) {

		} else if (selected.equals("2,000원")) {

		} else if (selected.equals("3,000원")) {

		} else if (selected.equals("5,000원")) {

		} else if (selected.equals("10,000원")) {

		}
	}
}