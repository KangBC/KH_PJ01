package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ControlView extends JFrame implements ActionListener, WindowListener {

	private JPanel contentPane;
	private JButton button_1, button_2, button_3, button_4, button_5,
	                button_6, button_7, button_8, button_9, button_10,
			        button_11, button_12, button_13, button_14, button_15, 
			        button_16, btnExit;

	private JTextField textField;
	private JTextField textField_1;

	public ControlView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//종료
		setBounds(100, 100, 1920, 1080);//전체 화면 조절
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 1920, 1080));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1920, 1080);
		contentPane.add(panel);
		panel.setLayout(null);

		//버튼
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

		button_13 = new JButton("재고관리");
		button_13.setBounds(1088, 59, 761, 113);
		panel.add(button_13);
		button_13.addActionListener(this);

		button_14 = new JButton("주문확인");
		button_14.setBounds(1088, 233, 761, 113);
		panel.add(button_14);
		button_14.addActionListener(this);

		button_15 = new JButton("회원정보");
		button_15.setBounds(1088, 413, 761, 113);
		panel.add(button_15);
		button_15.addActionListener(this);

		button_16 = new JButton("게시판");
		button_16.setBounds(1093, 605, 761, 113);
		panel.add(button_16);
		button_16.addActionListener(this);

		btnExit = new JButton("exit");
		btnExit.setBounds(1088, 808, 761, 113);
		panel.add(btnExit);
		
		textField = new JTextField();
		textField.setBackground(Color.PINK);
		textField.setForeground(Color.BLUE);
		textField.setBounds(919, 0, 15, 1049);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("시계 추가");
		textField_1.setBounds(32, 897, 754, 119);
		panel.add(textField_1);
		textField_1.setColumns(10);
		btnExit.addActionListener(this);

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 재고관리
		Object obj = e.getSource();
		if (obj == button_13) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
						OrderView frame = new OrderView();
						frame.setVisible(true);
				}
				
			});
			// 주문확인
		} else if (obj == button_14) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
						ManageMemListView frame = new ManageMemListView();
						frame.setVisible(true);
				}
			});
			// 회원정보
		} else if (obj == button_15) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
						jeongbo frame = new jeongbo();
						frame.setVisible(true);
				}
			});
			// 게시판
		} else if (obj == button_16) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
						BbsListView frame = new BbsListView();
						frame.setVisible(true);
				}
			});
			// exit
		} else if (obj == btnExit) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					dispose(); // 현재 창을 닫음		
				}
			});

		} else if (obj == button_1) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
						UserDetailView frame = new UserDetailView();
						frame.setVisible(true);
				}
			});
		}
	}
}
