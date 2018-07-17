package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class OrderView extends JFrame implements ActionListener {

	private JPanel panel;
	private JPanel contentPane;
	private JPanel[] menuPanel; 
	
	private JButton[] btn_kind;
	
	private JScrollPane scrollPane;
	
	public OrderView() {
		menuPanel = new JPanel[5];
		btn_kind = new JButton[5];
		
		setBounds(100, 100, 500, 320); //100, 100, 500, 320
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		btn_kind[0] = new JButton("과자류");
		btn_kind[0].addActionListener(this);
		btn_kind[0].setBounds(0, 6, 97, 47);
		panel.add(btn_kind[0]);
		
		btn_kind[1] = new JButton("식사류");
		btn_kind[1].setBounds(96, 6, 97, 47);
		btn_kind[1].addActionListener(this);
		panel.add(btn_kind[1]);
		
		btn_kind[2] = new JButton("간식류");
		btn_kind[2].setBounds(195, 6, 97, 47);
		btn_kind[2].addActionListener(this);
		panel.add(btn_kind[2]);
		
		btn_kind[3] = new JButton("음료류");
		btn_kind[3].setBounds(293, 6, 97, 47);
		btn_kind[3].addActionListener(this);
		panel.add(btn_kind[3]);
		
		btn_kind[4] = new JButton("인기 메뉴");
		btn_kind[4].setBounds(392, 6, 92, 47);
		btn_kind[4].addActionListener(this);
		panel.add(btn_kind[4]);

		contentPane.add(panel, BorderLayout.CENTER);

		drawPanel1();
		drawPanel2();
		drawPanel3();
		drawPanel4();
		drawPanel5();
		
		scrollPane.setViewportView(menuPanel[0]);
		
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
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	//TODO: ActionListener 
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		String btnName = btn.getName();
		
		if(btn == btn_kind[0]) {
			scrollPane.setViewportView(menuPanel[0]);
		}else if(btn == btn_kind[1]) {
			scrollPane.setViewportView(menuPanel[1]);
		}else if(btn == btn_kind[2]) {
			scrollPane.setViewportView(menuPanel[2]);
		}else if(btn == btn_kind[3]) {
			scrollPane.setViewportView(menuPanel[3]);
		}else if(btn == btn_kind[4]) {
			scrollPane.setViewportView(menuPanel[4]);
		}
		
		if(btnName.equals("새우깡")) {
			
		}else if(btnName.equals("콘칩")) {
			
		}else if(btnName.equals("자가비")) {
			
		}else if(btnName.equals("포카칩")) {
			
		}else if(btnName.equals("홈런볼")) {
			
		}else if(btnName.equals("포스틱")) {
			
		}else if(btnName.equals("오감자")) {
			
		}else if(btnName.equals("오잉")) {
			
		}else if(btnName.equals("고래밥")) {
			
		}
		
		if(btnName.equals("김치볶음밥")) {
			
		}else if(btnName.equals("카레덮밥")) {
			
		}else if(btnName.equals("라볶이")) {
			
		}else if(btnName.equals("떡만둣국")) {
			
		}else if(btnName.equals("라면")) {
			
		}
			
		if(btnName.equals("아라리")) {
			
		}else if(btnName.equals("핫도그")) {
			
		}else if(btnName.equals("김치만두")) {
			
		}else if(btnName.equals("고기만두")) {
			
		}
		
		if(btnName.equals("환타")) {
			
		}else if(btnName.equals("스프라이트")) {
			
		}else if(btnName.equals("코카콜라")) {
			
		}else if(btnName.equals("웰치스")) {
			
		}else if(btnName.equals("닥터페퍼")) {
			
		}else if(btnName.equals("밀키스")) {
			
		}
		
		if(btnName.equals("라볶이+콜라")) {
			
		}else if(btnName.equals("김치볶음밥+콜라")) {
			
		}else if(btnName.equals("카레덮밥+콜라")) {
			
		}
	}
	
	//TODO : Draw Panel1
	public void drawPanel1() {
		JButton imageBtn = null;
		JTextField nameTf = null;
		
		List<JButton> btnList = new ArrayList<>();
		List<JTextField> tfList = new ArrayList<>();
		
		menuPanel[0] = new JPanel();
		menuPanel[0].setLayout(null);
		menuPanel[0].setPreferredSize(new Dimension(303, 300));
		
		// 새우깡
		imageBtn = new JButton("새우깡");
		imageBtn.setName("새우깡");
		imageBtn.setBounds(6, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("새우깡 800");
		nameTf.setBounds(6, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 콘칩
		imageBtn = new JButton("콘칩");
		imageBtn.setName("콘칩");
		imageBtn.setBounds(99, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("콘칩 600");
		nameTf.setBounds(99, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);

		// 자가비
		imageBtn = new JButton("자가비");
		imageBtn.setName("자가비");
		imageBtn.setBounds(197, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("자가비 500");
		nameTf.setBounds(197, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 포카칩
		imageBtn = new JButton("포카칩");
		imageBtn.setName("포카칩");
		imageBtn.setBounds(6, 85, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("포카칩 1000");
		nameTf.setBounds(6, 134, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 홈런볼
		imageBtn = new JButton("홈런볼");
		imageBtn.setName("홈런볼");
		imageBtn.setBounds(99, 85, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("홈런볼 1000");
		nameTf.setBounds(99, 134, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 포스틱
		imageBtn = new JButton("포스틱");
		imageBtn.setName("포스틱");
		imageBtn.setBounds(197, 84, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("포스틱 800");
		nameTf.setBounds(197, 133, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 오감자
		imageBtn = new JButton("오! 감자");
		imageBtn.setName("오! 감자");
		imageBtn.setBounds(6, 164, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("오! 감자 800");
		nameTf.setBounds(6, 213, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 오잉
		imageBtn = new JButton("오잉");
		imageBtn.setName("오잉");
		imageBtn.setBounds(99, 164, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("오잉 800");
		nameTf.setBounds(99, 213, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 고래밥
		imageBtn = new JButton("고래밥");
		imageBtn.setName("고래밥");
		imageBtn.setBounds(197, 163, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("고래밥 600");
		nameTf.setBounds(197, 212, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		menuPanel[0].add(btnList.get(0));
		menuPanel[0].add(btnList.get(1));
		menuPanel[0].add(btnList.get(2));
		menuPanel[0].add(btnList.get(3));
		menuPanel[0].add(btnList.get(4));
		menuPanel[0].add(btnList.get(5));
		menuPanel[0].add(btnList.get(6));
		menuPanel[0].add(btnList.get(7));
		menuPanel[0].add(btnList.get(8));
		
		menuPanel[0].add(tfList.get(0));
		menuPanel[0].add(tfList.get(1));
		menuPanel[0].add(tfList.get(2));
		menuPanel[0].add(tfList.get(3));
		menuPanel[0].add(tfList.get(4));
		menuPanel[0].add(tfList.get(5));
		menuPanel[0].add(tfList.get(6));
		menuPanel[0].add(tfList.get(7));
		menuPanel[0].add(tfList.get(8));
	}
	
	//TODO : Draw Panel2
	public void drawPanel2() {
		JButton imageBtn = null;
		JTextField nameTf = null;
		
		List<JButton> btnList = new ArrayList<>();
		List<JTextField> tfList = new ArrayList<>();
		
		menuPanel[1] = new JPanel();
		menuPanel[1].setLayout(null);
		menuPanel[1].setPreferredSize(new Dimension(303, 300));
		
		// 김치볶음밥
		imageBtn = new JButton("김치볶음밥");
		imageBtn.setName("김치볶음밥");
		imageBtn.setBounds(6, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("김치볶음밥 3500");
		nameTf.setBounds(6, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 카레덮밥
		imageBtn = new JButton("카레덮밥");
		imageBtn.setName("카레덮밥");
		imageBtn.setBounds(99, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("카레덮밥 4000");
		nameTf.setBounds(99, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);

		// 라볶이
		imageBtn = new JButton("라볶이");
		imageBtn.setName("라볶이");
		imageBtn.setBounds(197, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("라볶이 3500");
		nameTf.setBounds(197, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 떡만둣국
		imageBtn = new JButton("떡만둣국");
		imageBtn.setName("떡만둣국");
		imageBtn.setBounds(6, 85, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("떡만둣국 4500");
		nameTf.setBounds(6, 134, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 라면
		imageBtn = new JButton("라면");
		imageBtn.setName("라면");
		imageBtn.setBounds(99, 85, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("라면 2000");
		nameTf.setBounds(99, 134, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		menuPanel[1].add(btnList.get(0));
		menuPanel[1].add(btnList.get(1));
		menuPanel[1].add(btnList.get(2));
		menuPanel[1].add(btnList.get(3));
		menuPanel[1].add(btnList.get(4));
	
		menuPanel[1].add(tfList.get(0));
		menuPanel[1].add(tfList.get(1));
		menuPanel[1].add(tfList.get(2));
		menuPanel[1].add(tfList.get(3));
		menuPanel[1].add(tfList.get(4));
	}
	
	//TODO: draw panel3
	public void drawPanel3() {
		JButton imageBtn = null;
		JTextField nameTf = null;
		
		List<JButton> btnList = new ArrayList<>();
		List<JTextField> tfList = new ArrayList<>();
		
		menuPanel[2] = new JPanel();
		menuPanel[2].setLayout(null);
		menuPanel[2].setPreferredSize(new Dimension(303, 300));
		
		// 아라리
		imageBtn = new JButton("아라리");
		imageBtn.setName("아라리");
		imageBtn.setBounds(6, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("아라리 500");
		nameTf.setBounds(6, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 핫도그
		imageBtn = new JButton("핫도그");
		imageBtn.setName("핫도그");
		imageBtn.setBounds(99, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("핫도그 1500");
		nameTf.setBounds(99, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);

		// 김치만두
		imageBtn = new JButton("김치만두");
		imageBtn.setName("김치만두");
		imageBtn.setBounds(197, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("김치만두 2000");
		nameTf.setBounds(197, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 고기만두
		imageBtn = new JButton("고기만두");
		imageBtn.setName("고기만두");
		imageBtn.setBounds(6, 85, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("고기만두 2000");
		nameTf.setBounds(6, 134, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		menuPanel[2].add(btnList.get(0));
		menuPanel[2].add(btnList.get(1));
		menuPanel[2].add(btnList.get(2));
		menuPanel[2].add(btnList.get(3));
	
		menuPanel[2].add(tfList.get(0));
		menuPanel[2].add(tfList.get(1));
		menuPanel[2].add(tfList.get(2));
		menuPanel[2].add(tfList.get(3));
	}
	
	// TODO: Draw panel4
	public void drawPanel4() {
		JButton imageBtn = null;
		JTextField nameTf = null;
		
		List<JButton> btnList = new ArrayList<>();
		List<JTextField> tfList = new ArrayList<>();
		
		menuPanel[3] = new JPanel();
		menuPanel[3].setLayout(null);
		menuPanel[3].setPreferredSize(new Dimension(303, 300));
		
		// 환타
		imageBtn = new JButton("환타");
		imageBtn.setName("환타");
		imageBtn.setBounds(6, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("환타 1500");
		nameTf.setBounds(6, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 스프라이트
		imageBtn = new JButton("스프라이트");
		imageBtn.setName("스프라이트");
		imageBtn.setBounds(99, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("스프라이트 1500");
		nameTf.setBounds(99, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);

		// 코카콜라
		imageBtn = new JButton("코카콜라");
		imageBtn.setName("코카콜라");
		imageBtn.setBounds(197, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("코카콜라 1500");
		nameTf.setBounds(197, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);

		// 웰치스
		imageBtn = new JButton("웰치스");
		imageBtn.setName("웰치스");
		imageBtn.setBounds(6, 85, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("웰치스 1500");
		nameTf.setBounds(6, 134, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 닥터페퍼
		imageBtn = new JButton("닥터페퍼");
		imageBtn.setName("닥터페퍼");
		imageBtn.setBounds(99, 85, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("닥터페퍼 1500");
		nameTf.setBounds(99, 134, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 밀키스
		imageBtn = new JButton("밀키스");
		imageBtn.setName("밀키스");
		imageBtn.setBounds(197, 84, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("밀키스 1500");
		nameTf.setBounds(197, 133, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		menuPanel[3].add(btnList.get(0));
		menuPanel[3].add(btnList.get(1));
		menuPanel[3].add(btnList.get(2));
		menuPanel[3].add(btnList.get(3));
		menuPanel[3].add(btnList.get(4));
		menuPanel[3].add(btnList.get(5));
		
		menuPanel[3].add(tfList.get(0));
		menuPanel[3].add(tfList.get(1));
		menuPanel[3].add(tfList.get(2));
		menuPanel[3].add(tfList.get(3));
		menuPanel[3].add(tfList.get(4));
		menuPanel[3].add(tfList.get(5));
	}
	
	// TODO: Draw panel5
	public void drawPanel5() {
		JButton imageBtn = null;
		JTextField nameTf = null;
		
		List<JButton> btnList = new ArrayList<>();
		List<JTextField> tfList = new ArrayList<>();
		
		menuPanel[4] = new JPanel();
		menuPanel[4].setLayout(null);
		menuPanel[4].setPreferredSize(new Dimension(303, 300));

		// 라볶이+콜라
		imageBtn = new JButton("라볶이+콜라");
		imageBtn.setName("라볶이+콜라");
		imageBtn.setBounds(6, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("라볶이+콜라 4500");
		nameTf.setBounds(6, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 김치볶음밥+콜라
		imageBtn = new JButton("김치볶음밥+콜라");
		imageBtn.setName("김치볶음밥+콜라");
		imageBtn.setBounds(99, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("김치볶음밥+콜라 4500");
		nameTf.setBounds(99, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);

		// 카레덮밥+콜라
		imageBtn = new JButton("카레덮밥+콜라");
		imageBtn.setName("카레덮밥+콜라");
		imageBtn.setBounds(197, 6, 86, 48);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("카레덮밥+콜라 5000");
		nameTf.setBounds(197, 55, 84, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		menuPanel[4].add(btnList.get(0));
		menuPanel[4].add(btnList.get(1));
		menuPanel[4].add(btnList.get(2));
	
		menuPanel[4].add(tfList.get(0));
		menuPanel[4].add(tfList.get(1));
		menuPanel[4].add(tfList.get(2));
	}
}