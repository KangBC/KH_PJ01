package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class OrderView extends JFrame implements ActionListener {

	private JPanel panel;
	private JPanel contentPane;
	private JPanel menuPanel1; 
	private JPanel menuPanel2; 
	private JPanel menuPanel3;
	private JPanel menuPanel4;
	private JPanel menuPanel5;
	
	private JTable table;
	
	private JButton btnNewButton_1; // 과자
	private JButton btnNewButton_2; // 식사
	private JButton btnNewButton_3; // 간식
	private JButton btnNewButton_4; // 음료
	private JButton btnNewButton_5; // 인기메뉴
	
	private JScrollPane scrollPane;
	
	private JTextField s_1Tf; // 과자
	private JTextField s_2Tf;
	private JTextField s_3Tf;
	private JTextField s_4Tf;
	private JTextField s_5Tf;
	private JTextField s_6Tf;
	private JTextField s_7Tf;
	private JTextField s_8Tf;
	private JTextField s_9Tf;
	
	private JTextField b_1Tf; // 식사
	private JTextField b_2Tf;
	private JTextField b_3Tf;
	private JTextField b_4Tf;
	private JTextField b_5Tf;
	
	private JTextField g_1TF; // 간식
	private JTextField g_2TF;
	private JTextField g_3TF;
	private JTextField g_4TF;

	private JTextField u_1TF; // 음료
	private JTextField u_2TF;
	private JTextField u_3TF;
	private JTextField u_4TF;
	private JTextField u_5TF;
	private JTextField u_6TF;

	private JTextField e_1TF; // 인기메뉴
	private JTextField e_2TF;
	private JTextField e_3TF;



	public OrderView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 320); //100, 100, 500, 320
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		btnNewButton_1 = new JButton("과자류");
		btnNewButton_1.setBounds(0, 6, 97, 47);
		btnNewButton_1.addActionListener(this);
		panel.setLayout(null);
		panel.add(btnNewButton_1);
		
		
		btnNewButton_2 = new JButton("식사류");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(96, 6, 97, 47);
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("간식류");
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setBounds(195, 6, 97, 47);
		panel.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("음료류");
		btnNewButton_4.addActionListener(this);
		btnNewButton_4.setBounds(293, 6, 97, 47);
		panel.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("인기 메뉴");
		btnNewButton_5.addActionListener(this);
		btnNewButton_5.setBounds(392, 6, 92, 47);
		panel.add(btnNewButton_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(332, 80, 152, 26);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_1);
		
		JLabel orderListLabel = new JLabel("주문 내역");
		panel_1.add(orderListLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(332, 107, 152, 26);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel nameLabel = new JLabel("상품");
		panel_2.add(nameLabel);
		
		JLabel priceLabel = new JLabel("가격");
		panel_2.add(priceLabel);
		
		JLabel totalPriceLabel = new JLabel("총 금액");
		panel_2.add(totalPriceLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(332, 133, 152, 104);
		panel.add(textArea);
		
		JButton orderBtn = new JButton("주문하기");
		orderBtn.setBounds(335, 239, 149, 29);
		panel.add(orderBtn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 80, 304, 177);
		panel.add(scrollPane);
		
	/////////////////////////////////////////////////////	
		menuPanel1 = new JPanel();
		menuPanel1.setPreferredSize(new Dimension(303, 300));
		scrollPane.setViewportView(menuPanel1);
		menuPanel1.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(6, 6, 86, 48);
		menuPanel1.add(btnNewButton_5);
		
		s_1Tf = new JTextField();
		s_1Tf.setHorizontalAlignment(SwingConstants.CENTER);
		s_1Tf.setText("새우깡 800");
		s_1Tf.setBounds(6, 55, 84, 26);
		menuPanel1.add(s_1Tf);
		s_1Tf.setColumns(10);
		
		JButton button = new JButton("New button");
		button.setBounds(99, 6, 86, 48);
		menuPanel1.add(button);
		
		s_2Tf = new JTextField();
		s_2Tf.setText("콘칩 600");
		s_2Tf.setHorizontalAlignment(SwingConstants.CENTER);
		s_2Tf.setColumns(10);
		s_2Tf.setBounds(99, 55, 84, 26);
		menuPanel1.add(s_2Tf);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(197, 6, 86, 48);
		menuPanel1.add(button_1);
		
		s_3Tf = new JTextField();
		s_3Tf.setText("자가비 500");
		s_3Tf.setHorizontalAlignment(SwingConstants.CENTER);
		s_3Tf.setColumns(10);
		s_3Tf.setBounds(197, 55, 84, 26);
		menuPanel1.add(s_3Tf);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(6, 85, 86, 48);
		menuPanel1.add(button_2);
		
		s_4Tf = new JTextField();
		s_4Tf.setText("포카칩 1000");
		s_4Tf.setHorizontalAlignment(SwingConstants.CENTER);
		s_4Tf.setColumns(10);
		s_4Tf.setBounds(6, 134, 84, 26);
		menuPanel1.add(s_4Tf);
		
		s_5Tf = new JTextField();
		s_5Tf.setText("홈런볼 1000");
		s_5Tf.setHorizontalAlignment(SwingConstants.CENTER);
		s_5Tf.setColumns(10);
		s_5Tf.setBounds(99, 134, 84, 26);
		menuPanel1.add(s_5Tf);
		
		JButton button_3 = new JButton("New button");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(99, 85, 86, 48);
		menuPanel1.add(button_3);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(197, 84, 86, 48);
		menuPanel1.add(button_5);
		
		s_6Tf = new JTextField();
		s_6Tf.setText("포스틱 800");
		s_6Tf.setHorizontalAlignment(SwingConstants.CENTER);
		s_6Tf.setColumns(10);
		s_6Tf.setBounds(197, 133, 84, 26);
		menuPanel1.add(s_6Tf);
		
		s_7Tf = new JTextField();
		s_7Tf.setText("오! 감자 800");
		s_7Tf.setHorizontalAlignment(SwingConstants.CENTER);
		s_7Tf.setColumns(10);
		s_7Tf.setBounds(6, 213, 84, 26);
		menuPanel1.add(s_7Tf);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(6, 164, 86, 48);
		menuPanel1.add(button_4);
		
		s_7Tf = new JTextField();
		s_7Tf.setText("고래밥 600");
		s_7Tf.setHorizontalAlignment(SwingConstants.CENTER);
		s_7Tf.setColumns(10);
		s_7Tf.setBounds(197, 212, 84, 26);
		menuPanel1.add(s_7Tf);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(197, 163, 86, 48);
		menuPanel1.add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(99, 164, 86, 48);
		menuPanel1.add(button_7);
		
		s_8Tf = new JTextField();
		s_8Tf.setText("오잉 800");
		s_8Tf.setHorizontalAlignment(SwingConstants.CENTER);
		s_8Tf.setColumns(10);
		s_8Tf.setBounds(99, 213, 84, 26);
		menuPanel1.add(s_8Tf);
		
		
	////////////////////////////////////////////////////////////
		
		
		menuPanel2 = new JPanel();
		menuPanel2.setPreferredSize(new Dimension(303, 300));
		//scrollPane.setViewportView(menuPanel2);
		menuPanel2.setLayout(null);
		
		JButton b_Btn1 = new JButton("New button");
		b_Btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b_Btn1.setBounds(6, 6, 86, 48);
		menuPanel2.add(b_Btn1);
		
		b_1Tf = new JTextField();
		b_1Tf.setHorizontalAlignment(SwingConstants.CENTER);
		b_1Tf.setText("김치볶음밥 3500");
		b_1Tf.setBounds(6, 55, 84, 26);
		menuPanel2.add(b_1Tf);
		b_1Tf.setColumns(10);
		
		JButton b_Btn2 = new JButton("New button");
		b_Btn2.setBounds(99, 6, 86, 48);
		menuPanel2.add(b_Btn2);
		
		b_2Tf = new JTextField();
		b_2Tf.setText("카레덮밥 4000");
		b_2Tf.setHorizontalAlignment(SwingConstants.CENTER);
		b_2Tf.setColumns(10);
		b_2Tf.setBounds(99, 55, 84, 26);
		menuPanel2.add(b_2Tf);
		
		JButton b_Btn3 = new JButton("New button");
		b_Btn3.setBounds(197, 6, 86, 48);
		menuPanel2.add(b_Btn3);
		
		b_3Tf = new JTextField();
		b_3Tf.setText("라볶이 3500");
		b_3Tf.setHorizontalAlignment(SwingConstants.CENTER);
		b_3Tf.setColumns(10);
		b_3Tf.setBounds(197, 55, 84, 26);
		menuPanel2.add(b_3Tf);
		
		JButton b_Btn4 = new JButton("New button");
		b_Btn4.setBounds(6, 85, 86, 48);
		menuPanel2.add(b_Btn4);
		
		b_4Tf = new JTextField();
		b_4Tf.setText("떡만둣국 4500");
		b_4Tf.setHorizontalAlignment(SwingConstants.CENTER);
		b_4Tf.setColumns(10);
		b_4Tf.setBounds(6, 134, 84, 26);
		menuPanel2.add(b_4Tf);
		
		b_5Tf = new JTextField();
		b_5Tf.setText("라면 2000");
		b_5Tf.setHorizontalAlignment(SwingConstants.CENTER);
		b_5Tf.setColumns(10);
		b_5Tf.setBounds(99, 134, 84, 26);
		menuPanel2.add(b_5Tf);
		
		JButton b_Btn5 = new JButton("New button");
		b_Btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b_Btn5.setBounds(99, 85, 86, 48);
		menuPanel2.add(b_Btn5);
		
		
		/////////////?/////?/////////////////////////?////
		menuPanel3 = new JPanel();
		menuPanel3.setPreferredSize(new Dimension(303, 300));
		//scrollPane.setViewportView(menuPanel3);
		menuPanel3.setLayout(null);
		
		
		JButton g_Btn1 = new JButton("New button");
		g_Btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		g_Btn1.setBounds(6, 6, 86, 48);
		menuPanel3.add(g_Btn1);
		
		g_1TF = new JTextField();
		g_1TF.setHorizontalAlignment(SwingConstants.CENTER);
		g_1TF.setText("아라리 500");
		g_1TF.setBounds(6, 55, 84, 26);
		menuPanel3.add(g_1TF);
		g_1TF.setColumns(10);
		
		JButton g_Btn2 = new JButton("New button");
		g_Btn2.setBounds(99, 6, 86, 48);
		menuPanel3.add(g_Btn2);
		
		g_2TF = new JTextField();
		g_2TF.setText("핫도그 1500");
		g_2TF.setHorizontalAlignment(SwingConstants.CENTER);
		g_2TF.setColumns(10);
		g_2TF.setBounds(99, 55, 84, 26);
		menuPanel3.add(g_2TF);
		
		JButton g_Btn3 = new JButton("New button");
		g_Btn3.setBounds(197, 6, 86, 48);
		menuPanel3.add(g_Btn3);
		
		g_3TF = new JTextField();
		g_3TF.setText("김치만두 2000");
		g_3TF.setHorizontalAlignment(SwingConstants.CENTER);
		g_3TF.setColumns(10);
		g_3TF.setBounds(197, 55, 84, 26);
		menuPanel3.add(g_3TF);
		
		JButton g_Btn4 = new JButton("New button");
		g_Btn4.setBounds(6, 85, 86, 48);
		menuPanel3.add(g_Btn4);
		
		g_4TF = new JTextField();
		g_4TF.setText("고기만두 2000");
		g_4TF.setHorizontalAlignment(SwingConstants.CENTER);
		g_4TF.setColumns(10);
		g_4TF.setBounds(6, 134, 84, 26);
		menuPanel3.add(g_4TF);
		

		
	/////////////////////////////////////////////////
		menuPanel4 = new JPanel();
		menuPanel4.setPreferredSize(new Dimension(303, 300));
		//scrollPane.setViewportView(menuPanel4);
		menuPanel4.setLayout(null);
		
		JButton u_Btn1 = new JButton("New button");
		u_Btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		u_Btn1.setBounds(6, 6, 86, 48);
		menuPanel4.add(u_Btn1);
		
		u_1TF = new JTextField();
		u_1TF.setHorizontalAlignment(SwingConstants.CENTER);
		u_1TF.setText("환타 1500");
		u_1TF.setBounds(6, 55, 84, 26);
		menuPanel4.add(u_1TF);
		u_1TF.setColumns(10);
		
		JButton u_Btn2 = new JButton("New button");
		u_Btn2.setBounds(99, 6, 86, 48);
		menuPanel4.add(u_Btn2);
		
		u_2TF = new JTextField();
		u_2TF.setText("스프라이트 1500");
		u_2TF.setHorizontalAlignment(SwingConstants.CENTER);
		u_2TF.setColumns(10);
		u_2TF.setBounds(99, 55, 84, 26);
		menuPanel4.add(u_2TF);
		
		JButton u_Btn3 = new JButton("New button");
		u_Btn3.setBounds(197, 6, 86, 48);
		menuPanel4.add(u_Btn3);
		
		u_3TF = new JTextField();
		u_3TF.setText("코카콜라 1500");
		u_3TF.setHorizontalAlignment(SwingConstants.CENTER);
		u_3TF.setColumns(10);
		u_3TF.setBounds(197, 55, 84, 26);
		menuPanel4.add(u_3TF);
		
		JButton u_Btn4 = new JButton("New button");
		u_Btn4.setBounds(6, 85, 86, 48);
		menuPanel4.add(u_Btn4);
		
		u_4TF = new JTextField();
		u_4TF.setText("웰치스 1500");
		u_4TF.setHorizontalAlignment(SwingConstants.CENTER);
		u_4TF.setColumns(10);
		u_4TF.setBounds(6, 134, 84, 26);
		menuPanel4.add(u_4TF);
		
		u_5TF = new JTextField();
		u_5TF.setText("닥터페퍼 1500");
		u_5TF.setHorizontalAlignment(SwingConstants.CENTER);
		u_5TF.setColumns(10);
		u_5TF.setBounds(99, 134, 84, 26);
		menuPanel4.add(u_5TF);
		
		JButton u_Btn5 = new JButton("New button");
		u_Btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		u_Btn5.setBounds(99, 85, 86, 48);
		menuPanel4.add(u_Btn5);
		
		JButton u_Btn6 = new JButton("New button");
		u_Btn6.setBounds(197, 84, 86, 48);
		menuPanel4.add(u_Btn6);
		
		u_6TF = new JTextField();
		u_6TF.setText("밀키스 1500");
		u_6TF.setHorizontalAlignment(SwingConstants.CENTER);
		u_6TF.setColumns(10);
		u_6TF.setBounds(197, 133, 84, 26);
		menuPanel4.add(u_6TF);
		

		
	//////////////////////////////////////////////////////
		
		menuPanel5 = new JPanel();
		menuPanel5.setPreferredSize(new Dimension(303, 300));
		//scrollPane.setViewportView(MenuPanel3);
		menuPanel5.setLayout(null);
		
		
		JButton e_Btn1 = new JButton("New button");
		e_Btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		e_Btn1.setBounds(6, 6, 86, 48);
		menuPanel5.add(e_Btn1);
		
		e_1TF = new JTextField();
		e_1TF.setHorizontalAlignment(SwingConstants.CENTER);
		e_1TF.setText("라볶이+콜라 4500");
		e_1TF.setBounds(6, 55, 84, 26);
		menuPanel5.add(e_1TF);
		e_1TF.setColumns(10);
		
		JButton e_Btn2 = new JButton("New button");
		e_Btn2.setBounds(99, 6, 86, 48);
		menuPanel5.add(e_Btn2);
		
		e_2TF = new JTextField();
		e_2TF.setText("김치볶음밥+콜라 4500");
		e_2TF.setHorizontalAlignment(SwingConstants.CENTER);
		e_2TF.setColumns(10);
		e_2TF.setBounds(99, 55, 84, 26);
		menuPanel5.add(e_2TF);
		
		JButton e_Btn3 = new JButton("New button");
		e_Btn3.setBounds(197, 6, 86, 48);
		menuPanel5.add(e_Btn3);
		
		e_3TF = new JTextField();
		e_3TF.setText("카레덮밥 5000");
		e_3TF.setHorizontalAlignment(SwingConstants.CENTER);
		e_3TF.setColumns(10);
		e_3TF.setBounds(197, 55, 84, 26);
		menuPanel5.add(e_3TF);
		
	
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn == btnNewButton_1) {
			scrollPane.setViewportView(menuPanel1);
		}else if(btn == btnNewButton_2) {
			scrollPane.setViewportView(menuPanel2);
		}else if(btn == btnNewButton_3) {
			scrollPane.setViewportView(menuPanel3);
		}else if(btn == btnNewButton_4) {
			scrollPane.setViewportView(menuPanel4);
		}else if(btn == btnNewButton_5) {
			scrollPane.setViewportView(menuPanel5);
		}
	}
}
