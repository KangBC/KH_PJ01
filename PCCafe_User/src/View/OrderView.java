package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Singleton.Singleton;



public class OrderView extends JFrame implements ActionListener,MouseListener {

	private JPanel panel;
	private JPanel contentPane;
	private JPanel[] menuPanel; 
	private JTable orderTable;
	
	private JButton[] btn_kind;
	
	private JScrollPane scrollPane;
	private JScrollPane orderScrPane;
	
	ArrayList<String> nameS = new ArrayList<>(); 
	ArrayList<Integer> countS = new ArrayList<>();
	ArrayList<Integer> priceS = new ArrayList<>();
	
	String columnNames[] = {
			"상품","갯수","총 금액"	
		};
	Object[][] stuffObj;
	
	public OrderView() {
		menuPanel = new JPanel[5];
		btn_kind = new JButton[5];
		
		setBounds(100, 100, 930, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 900, 678);
		
		btn_kind[0] = new JButton("과자류");
		btn_kind[0].addActionListener(this);
		btn_kind[0].setBounds(35, 6, 150, 70);
		panel.add(btn_kind[0]);
		
		btn_kind[1] = new JButton("식사류");
		btn_kind[1].setBounds(204, 6, 150, 70);
		btn_kind[1].addActionListener(this);
		panel.add(btn_kind[1]);
		
		btn_kind[2] = new JButton("간식류");
		btn_kind[2].setBounds(373, 6, 150, 70);
		btn_kind[2].addActionListener(this);
		panel.add(btn_kind[2]);
		
		btn_kind[3] = new JButton("음료류");
		btn_kind[3].setBounds(542, 6, 150, 70);
		btn_kind[3].addActionListener(this);
		panel.add(btn_kind[3]);
		
		btn_kind[4] = new JButton("인기 메뉴");
		btn_kind[4].setBounds(711, 6, 150, 70);
		btn_kind[4].addActionListener(this);
		contentPane.setLayout(null);
		panel.add(btn_kind[4]);

		contentPane.add(panel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 95, 672, 577);
		panel.add(scrollPane);

		drawPanel1();
		drawPanel2();
		drawPanel3();
		drawPanel4();
		drawPanel5();
		
		scrollPane.setViewportView(menuPanel[0]);
		
		// 주문받는곳
		Object[][] stuffObj = new Object[nameS.size()][3];
		
		JLabel orderListLabel = new JLabel("주문 내역");

		orderListLabel.setBounds(697, 95, 197, 48);
		orderListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderListLabel.setBorder(new LineBorder(Color.BLACK));
		panel.add(orderListLabel);

		orderScrPane = new JScrollPane(orderTable);
		
		orderTable = new JTable(stuffObj,columnNames);
		orderTable.addMouseListener(this);

		orderScrPane.setViewportView(orderTable);
		orderScrPane.setBounds(697, 155, 197, 444);
		panel.add(orderScrPane);
		
		JButton orderBtn = new JButton("주문하기");
		orderBtn.setName("주문하기");
		orderBtn.setBounds(697, 611, 197, 61);
		orderBtn.addActionListener(this);
		panel.add(orderBtn);
		
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
			addOrder(btnName,800);
		}else if(btnName.equals("콘칩")) {
			addOrder(btnName,600);
		}else if(btnName.equals("자가비")) {
			addOrder(btnName,500);
		}else if(btnName.equals("포카칩")) {
			addOrder(btnName,1000);
		}else if(btnName.equals("홈런볼")) {
			addOrder(btnName,1000);
		}else if(btnName.equals("포스틱")) {
			addOrder(btnName,800);
		}else if(btnName.equals("오감자")) {
			addOrder(btnName,800);
		}else if(btnName.equals("오잉")) {
			addOrder(btnName,800);
		}else if(btnName.equals("고래밥")) {
			addOrder(btnName,600);
		}
		
		if(btnName.equals("김치볶음밥")) {
			addOrder(btnName,3500);
		}else if(btnName.equals("카레덮밥")) {
			addOrder(btnName,4000);
		}else if(btnName.equals("라볶이")) {
			addOrder(btnName,3500);
		}else if(btnName.equals("떡만둣국")) {
			addOrder(btnName,4500);
		}else if(btnName.equals("라면")) {
			addOrder(btnName,2000);
		}
			
		if(btnName.equals("아라리")) {
			addOrder(btnName,500);
		}else if(btnName.equals("핫도그")) {
			addOrder(btnName,1500);
		}else if(btnName.equals("김치만두")) {
			addOrder(btnName,2000);
		}else if(btnName.equals("고기만두")) {
			addOrder(btnName,2000);
		}
		
		if(btnName.equals("환타")) {
			addOrder(btnName,1500);
		}else if(btnName.equals("스프라이트")) {
			addOrder(btnName,1500);
		}else if(btnName.equals("코카콜라")) {
			addOrder(btnName,1500);
		}else if(btnName.equals("웰치스")) {
			addOrder(btnName,1500);
		}else if(btnName.equals("닥터페퍼")) {
			addOrder(btnName,1500);
		}else if(btnName.equals("밀키스")) {
			addOrder(btnName,1500);
		}
		
		if(btnName.equals("라볶이+콜라")) {
			addOrder(btnName,4500);
		}else if(btnName.equals("김치볶음밥+콜라")) {
			addOrder(btnName,4500);
		}else if(btnName.equals("카레덮밥+콜라")) {
			addOrder(btnName,5000);
		}
		
		if(btnName.equals("주문하기")) {
			String str = "";
			int pay = 0;
			for(int i = 0; i< stuffObj.length; i++) {
				str = str + nameS.get(i) + " " + countS.get(i) + " 개 -";
				pay = pay + priceS.get(i);
			}
			str = str + "총액 : " + pay;
			
			// 송출
			Singleton single = Singleton.getInstance();
			single.serCtrl.orderSign();
			single.serCtrl.order_menuSign(str);
			JOptionPane.showMessageDialog(null, "성공적으로 주문되었습니다.");
			// 주문끝 작업 --------------------------------
	
		}
	}
	
	// TODO : addOrder
	public void addOrder(String name,int price) {
		if(nameS.contains(name)) {
			int i = nameS.indexOf(name);
			countS.set(i, countS.get(i)+1);
			priceS.set(i, priceS.get(i)+price);
		}else {
			nameS.add(name);
			countS.add(1);
			priceS.add(price);
		}
		
		stuffObj = new Object[nameS.size()][3];
		for(int i = 0; i < nameS.size(); i++) {
			stuffObj[i][0] = nameS.get(i);
			stuffObj[i][1] = countS.get(i);
			stuffObj[i][2] = priceS.get(i);
		}
		
		orderTable = new JTable(stuffObj,columnNames);
		orderScrPane.setViewportView(orderTable);
		
	}
		

	//TODO : Draw Panel1
	public void drawPanel1() {
		JButton imageBtn = null;
		JTextField nameTf = null;
		
		List<JButton> btnList = new ArrayList<>();
		List<JTextField> tfList = new ArrayList<>();
		
		menuPanel[0] = new JPanel();
		menuPanel[0].setLayout(null);
		menuPanel[0].setPreferredSize(new Dimension(660, 900));
		
		// 새우깡
		imageBtn = new JButton(new ImageIcon("과자/새우깡.jpg"));
		imageBtn.setName("새우깡");
		imageBtn.setBounds(6, 6, 180, 150); // 86,48
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("새우깡 800");
		nameTf.setBounds(6, 160, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 콘칩
		imageBtn = new JButton(new ImageIcon("과자/콘칩.jpg"));
		imageBtn.setName("콘칩");
		imageBtn.setBounds(228, 6, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("콘칩 600");
		nameTf.setBounds(228, 160, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);

		// 자가비
		imageBtn = new JButton(new ImageIcon("과자/자가비.jpeg"));
		imageBtn.setName("자가비");
		imageBtn.setBounds(454, 6, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("자가비 500");
		nameTf.setBounds(452, 160, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 포카칩
		imageBtn = new JButton(new ImageIcon("과자/포카칩.jpg"));
		imageBtn.setName("포카칩");
		imageBtn.setBounds(6, 200, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("포카칩 1000");
		nameTf.setBounds(6, 354, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 홈런볼
		imageBtn = new JButton(new ImageIcon("과자/홈런볼.jpg"));
		imageBtn.setName("홈런볼");
		imageBtn.setBounds(228, 200, 180, 150); // 여기할 차례
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("홈런볼 1000");
		nameTf.setBounds(228, 354, 180, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 포스틱
		imageBtn = new JButton(new ImageIcon("과자/포스틱.jpg"));
		imageBtn.setName("포스틱");
		imageBtn.setBounds(454, 200, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("포스틱 800");
		nameTf.setBounds(454, 354, 180, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 오감자
		imageBtn = new JButton(new ImageIcon("과자/오감자.jpg"));
		imageBtn.setName("오감자");
		imageBtn.setBounds(6, 394, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("오! 감자 800");
		nameTf.setBounds(6, 548, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 오잉
		imageBtn = new JButton(new ImageIcon("과자/오잉.jpg"));
		imageBtn.setName("오잉");
		imageBtn.setBounds(228, 394, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("오잉 800");
		nameTf.setBounds(228, 548, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 고래밥
		imageBtn = new JButton(new ImageIcon("과자/고래밥.jpg"));
		imageBtn.setName("고래밥");
		imageBtn.setBounds(452, 394, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("고래밥 600");
		nameTf.setBounds(452, 548, 185, 26);
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
		imageBtn = new JButton(new ImageIcon("식사/김치볶음밥.jpg"));
		imageBtn.setName("김치볶음밥");
		imageBtn.setBounds(6, 6, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("김치볶음밥 3500");
		nameTf.setBounds(6, 160, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 카레덮밥
		imageBtn = new JButton(new ImageIcon("식사/카레덮밥.jpg"));
		imageBtn.setName("카레덮밥");
		imageBtn.setBounds(228, 6, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("카레덮밥 4000");
		nameTf.setBounds(228, 160, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);

		// 라볶이
		imageBtn = new JButton(new ImageIcon("식사/라볶이.jpg"));
		imageBtn.setName("라볶이");
		imageBtn.setBounds(454, 6, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("라볶이 3500");
		nameTf.setBounds(454, 160, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 떡만둣국
		imageBtn = new JButton(new ImageIcon("식사/떡만둣국.jpg"));
		imageBtn.setName("떡만둣국");
		imageBtn.setBounds(6, 200, 185, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("떡만둣국 4500");
		nameTf.setBounds(6, 354, 180, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 라면
		imageBtn = new JButton(new ImageIcon("식사/라면.jpg"));
		imageBtn.setName("라면");
		imageBtn.setBounds(228, 200, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("라면 2000");
		nameTf.setBounds(228, 354, 185, 26);
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
		imageBtn = new JButton(new ImageIcon("간식/아라리.jpeg"));
		imageBtn.setName("아라리");
		imageBtn.setBounds(6, 6, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("아라리 500");
		nameTf.setBounds(6, 160, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 핫도그
		imageBtn = new JButton(new ImageIcon("간식/핫도그.jpeg"));
		imageBtn.setName("핫도그");
		imageBtn.setBounds(228, 6, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("핫도그 1500");
		nameTf.setBounds(228, 160, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);

		// 김치만두
		imageBtn = new JButton(new ImageIcon("간식/김치만두.jpg"));
		imageBtn.setName("김치만두");
		imageBtn.setBounds(454, 6, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("김치만두 2000");
		nameTf.setBounds(454, 160, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 고기만두
		imageBtn = new JButton(new ImageIcon("간식/고기만두.jpg"));
		imageBtn.setName("고기만두");
		imageBtn.setBounds(6, 200, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("고기만두 2000");
		nameTf.setBounds(6, 354, 185, 26);
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
		imageBtn = new JButton(new ImageIcon("음료수/환타.jpg"));
		imageBtn.setName("환타");
		imageBtn.setBounds(6, 6, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("환타 1500");
		nameTf.setBounds(6, 160, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 스프라이트
		imageBtn = new JButton(new ImageIcon("음료수/스프라이트.jpg"));
		imageBtn.setName("스프라이트");
		imageBtn.setBounds(228, 6, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("스프라이트 1500");
		nameTf.setBounds(228, 160, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);

		// 코카콜라
		imageBtn = new JButton(new ImageIcon("음료수/코카콜라.jpeg"));
		imageBtn.setName("코카콜라");
		imageBtn.setBounds(454, 6, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("코카콜라 1500");
		nameTf.setBounds(454, 160, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);

		// 웰치스
		imageBtn = new JButton(new ImageIcon("음료수/웰치스.jpg"));
		imageBtn.setName("웰치스");
		imageBtn.setBounds(6, 200, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("웰치스 1500");
		nameTf.setBounds(6, 354, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 닥터페퍼
		imageBtn = new JButton(new ImageIcon("음료수/닥터페퍼.jpg"));
		imageBtn.setName("닥터페퍼");
		imageBtn.setBounds(228, 200, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("닥터페퍼 1500");
		nameTf.setBounds(228, 354, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 밀키스
		imageBtn = new JButton(new ImageIcon("음료수/밀키스.jpg"));
		imageBtn.setName("밀키스");
		imageBtn.setBounds(454, 200, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("밀키스 1500");
		nameTf.setBounds(454, 354, 185, 26);
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
		imageBtn = new JButton(new ImageIcon("인기메뉴/라볶이.jpg"));
		imageBtn.setName("라볶이+콜라");
		imageBtn.setBounds(6, 6, 185, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("라볶이+콜라 4500");
		nameTf.setBounds(6, 160, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);
		
		// 김치볶음밥+콜라
		imageBtn = new JButton(new ImageIcon("인기메뉴/김치볶음밥.jpg"));
		imageBtn.setName("김치볶음밥+콜라");
		imageBtn.setBounds(228, 6, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("김치볶음밥+콜라 4500");
		nameTf.setBounds(228, 160, 185, 26);
		nameTf.setColumns(10);
		nameTf.setEditable(false);
		tfList.add(nameTf);

		// 카레덮밥+콜라
		imageBtn = new JButton(new ImageIcon("인기메뉴/카레덮밥.jpg"));
		imageBtn.setName("카레덮밥+콜라");
		imageBtn.setBounds(454, 6, 180, 150);
		imageBtn.addActionListener(this);
		btnList.add(imageBtn);
		
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		nameTf.setText("카레덮밥+콜라 5000");
		nameTf.setBounds(454, 160, 185, 26);
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
	
	public void mouseClicked(MouseEvent e) {
				
	}

	public void mousePressed(MouseEvent e) {
				
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}
}