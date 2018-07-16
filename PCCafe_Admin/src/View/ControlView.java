package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Singleton.Singleton;
import java.awt.GridLayout;

public class ControlView extends JFrame implements ActionListener {
	private Singleton single = Singleton.getInstance();
	private JPanel contentPane;
	private JButton bt_1, bt_2, bt_3, bt_4, bt_5, bt_6, bt_7, bt_8, bt_9, bt_10, button_13, button_14, button_15,
			button_16;
	private JTextField textField_1;

	// Seat Function
	private ArrayList<JButton> buttonList = new ArrayList<>();
	private ArrayList<JPanel> panelList = new ArrayList<>();
	private JButton btnNewButton;
	private int selectSeat = -1;

	public ControlView() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 1920, 1080));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1920, 1080);
		contentPane.add(panel);
		panel.setLayout(null);

		button_13 = new JButton("재고관리");
		button_13.setBounds(1558, 46, 270, 300);
		panel.add(button_13);
		button_13.addActionListener(this);

		button_14 = new JButton("주문확인");
		button_14.setBounds(1088, 47, 270, 300);
		panel.add(button_14);
		button_14.addActionListener(this);

		button_15 = new JButton("회원정보");
		button_15.setBounds(1088, 440, 270, 300);
		panel.add(button_15);
		button_15.addActionListener(this);

		button_16 = new JButton("게시판");
		button_16.setBounds(1558, 440, 270, 300);
		panel.add(button_16);
		button_16.addActionListener(this);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("시계 추가");
		textField_1.setBounds(1074, 890, 754, 119);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(920, 0, 4, 1029);
		panel.add(panel_1);

		btnNewButton = new JButton("초기화");
		btnNewButton.setBounds(36, 936, 105, 27);
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();
		JPanel panel_5 = new JPanel();
		JPanel panel_6 = new JPanel();
		JPanel panel_7 = new JPanel();
		JPanel panel_8 = new JPanel();
		JPanel panel_9 = new JPanel();
		JPanel panel_10 = new JPanel();
		JPanel panel_11 = new JPanel();

		panelList.add(panel_2);
		panelList.add(panel_3);
		panelList.add(panel_4);
		panelList.add(panel_5);
		panelList.add(panel_6);
		panelList.add(panel_7);
		panelList.add(panel_8);
		panelList.add(panel_9);
		panelList.add(panel_10);
		panelList.add(panel_11);

		panel_2.setBounds(48, 46, 212, 168);
		panel_3.setBounds(344, 46, 212, 168);
		panel_4.setBounds(631, 46, 212, 168);
		panel_5.setBounds(48, 293, 212, 168);
		panel_6.setBounds(344, 293, 212, 168);
		panel_7.setBounds(631, 293, 212, 168);
		panel_8.setBounds(48, 534, 212, 168);
		panel_9.setBounds(344, 534, 212, 168);
		panel_10.setBounds(631, 534, 212, 168);
		panel_11.setBounds(631, 785, 212, 168);

		bt_1 = new JButton("");
		bt_2 = new JButton("");
		bt_3 = new JButton("");
		bt_4 = new JButton("");
		bt_5 = new JButton("");
		bt_6 = new JButton("");
		bt_7 = new JButton("");
		bt_8 = new JButton("");
		bt_9 = new JButton("");
		bt_10 = new JButton("");

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

		for (int i = 0; i < single.serCtrl.getSeatList().length; i++) {
			String temp[] = single.serCtrl.getSeatList();
			if (temp[i].equals("1")) {
				// Panel
				panelList.get(i).setBackground(Color.RED);
				panelList.get(i).setLayout(new GridLayout(1, 0, 0, 0));
				panel.add(panelList.get(i));
				// Button
				buttonList.get(i).setEnabled(true);
				buttonList.get(i).setOpaque(false);
				buttonList.get(i).setContentAreaFilled(false);
				buttonList.get(i).setBorder(null);
			} else {
				// Panel
				panelList.get(i).setBackground(Color.BLUE);
				panelList.get(i).setLayout(new GridLayout(1, 0, 0, 0));
				panel.add(panelList.get(i));
				// Button
				buttonList.get(i).setEnabled(false);
				buttonList.get(i).setOpaque(false);
				buttonList.get(i).setContentAreaFilled(false);
				buttonList.get(i).setBorder(null);
			}
		}

		panel_2.add(bt_1);
		panel_3.add(bt_2);
		panel_4.add(bt_3);
		panel_5.add(bt_4);
		panel_6.add(bt_5);
		panel_7.add(bt_6);
		panel_8.add(bt_7);
		panel_9.add(bt_8);
		panel_10.add(bt_9);
		panel_11.add(bt_10);

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
		if (obj == button_14) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					OrderView frame = new OrderView();
					frame.setVisible(true);
				}
			});
			// 회원정보 (ok)
		} else if (obj == button_15) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					ManageMemView frame = new ManageMemView();
					frame.setVisible(true);
				}
			});
			// 게시판(ok)
		} else if (obj == button_16) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					Singleton single = Singleton.getInstance();
					single.bbsCtrl.getBbsList();
				}
			});

		} else if (obj == bt_1) {
			selectSeat = 0;
			single.serCtrl.detailView(selectSeat);
			selectSeat = -1;
		} else if (obj == bt_2) {
			selectSeat = 1;
			single.serCtrl.detailView(selectSeat);
			selectSeat = -1;
		} else if (obj == bt_3) {
			selectSeat = 2;
			single.serCtrl.detailView(selectSeat);
			selectSeat = -1;
		} else if (obj == bt_4) {
			selectSeat = 3;
			single.serCtrl.detailView(selectSeat);
			selectSeat = -1;
		} else if (obj == bt_5) {
			selectSeat = 4;
			single.serCtrl.detailView(selectSeat);
			selectSeat = -1;
		} else if (obj == bt_6) {
			selectSeat = 5;
			single.serCtrl.detailView(selectSeat);
			selectSeat = -1;
		} else if (obj == bt_7) {
			selectSeat = 6;
			single.serCtrl.detailView(selectSeat);
			selectSeat = -1;
		} else if (obj == bt_8) {
			selectSeat = 7;
			single.serCtrl.detailView(selectSeat);
			selectSeat = -1;
		} else if (obj == bt_9) {
			selectSeat = 8;
			single.serCtrl.detailView(selectSeat);
			selectSeat = -1;
		} else if (obj == bt_10) {
			selectSeat = 9;
			single.serCtrl.detailView(selectSeat);
			selectSeat = -1;
		} else if (obj == btnNewButton) {
			ControlView frame = new ControlView();
			frame.setVisible(true);
			this.dispose();
		}
	}
}
