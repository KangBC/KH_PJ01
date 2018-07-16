package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Singleton.Singleton;

public class ControlView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_10,
			button_11, button_12;

	private JButton but_stuff, but_order, but_manager, but_gasipan;

	private JTextField textField;
	private JTextField textField_1;

	Singleton sc = Singleton.getInstance();

	public ControlView() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 1920, 1080));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1920, 1080);
		contentPane.add(panel);
		panel.setLayout(null);

		// 피씨자리번호 (UserDetailView)
		button_1 = new JButton("1");
		button_1.setBounds(33, 59, 200, 150);
		panel.add(button_1);
		button_1.addActionListener(this);

		button_2 = new JButton("2");
		button_2.setBounds(306, 59, 200, 150);
		panel.add(button_2);
		button_2.addActionListener(this);

		button_3 = new JButton("3");
		button_3.setBounds(586, 59, 200, 150);
		panel.add(button_3);
		button_3.addActionListener(this);

		button_4 = new JButton("4");
		button_4.setBounds(33, 262, 200, 150);
		panel.add(button_4);
		button_4.addActionListener(this);

		button_5 = new JButton("5");
		button_5.setBounds(306, 262, 200, 150);
		panel.add(button_5);
		button_5.addActionListener(this);

		button_6 = new JButton("6");
		button_6.setBounds(586, 262, 200, 150);
		panel.add(button_6);
		button_6.addActionListener(this);

		button_7 = new JButton("7");
		button_7.setBounds(33, 490, 200, 150);
		panel.add(button_7);
		button_7.addActionListener(this);

		button_8 = new JButton("8");
		button_8.setBounds(306, 490, 200, 150);
		panel.add(button_8);
		button_8.addActionListener(this);

		button_9 = new JButton("9");
		button_9.setBounds(586, 490, 200, 150);
		panel.add(button_9);
		button_9.addActionListener(this);

		button_10 = new JButton("10");
		button_10.setBounds(33, 712, 200, 150);
		panel.add(button_10);
		button_10.addActionListener(this);

		button_11 = new JButton("11");
		button_11.setBounds(586, 712, 200, 150);
		panel.add(button_11);
		button_11.addActionListener(this);

		button_12 = new JButton("12");
		button_12.setBounds(306, 712, 200, 150);
		panel.add(button_12);
		button_12.addActionListener(this);

		// 기능 아직 미사용
		but_stuff = new JButton("재고관리");
		but_stuff.setBounds(1558, 46, 270, 300);
		panel.add(but_stuff);
		but_stuff.addActionListener(this);

		// 테이블 새로 만들어야함
		but_order = new JButton("주문확인");
		but_order.setBounds(1088, 47, 270, 300);
		panel.add(but_order);
		but_order.addActionListener(this);

		but_manager = new JButton("회원정보");
		but_manager.setBounds(1088, 440, 270, 300);
		panel.add(but_manager);
		but_manager.addActionListener(this);

		but_gasipan = new JButton("게시판");
		but_gasipan.setBounds(1558, 440, 270, 300);
		panel.add(but_gasipan);
		but_gasipan.addActionListener(this);

		textField = new JTextField();
		textField.setBackground(Color.PINK);
		textField.setForeground(Color.BLUE);
		textField.setBounds(919, 0, 15, 1049);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("시계 추가");
		textField_1.setBounds(1074, 890, 754, 119);
		panel.add(textField_1);
		textField_1.setColumns(10);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 종료
		setBounds(100, 100, 1920, 1080);// 전체 화면 조절

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// 회원정보view
		if (obj == but_manager) {
			sc.memCtrl.manager();

			// 게시판 List
		} else if (obj == but_gasipan) {
			sc.bbsCtrl.gasipanList();

			// UserDetailView
		} else if (obj == button_1) {
			sc.bbsCtrl.UserDetai();

			// OrderView
		} else if (obj == but_order) {
			sc.bbsCtrl.order();
		}
	}
}
