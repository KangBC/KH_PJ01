package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ControlView extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton MesBtn;
	private JButton BbsBtn;
	private JButton oderBtn;
	private JButton logoutBtn;
	
	
	public ControlView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		logoutBtn = new JButton("로그아웃");
		logoutBtn.addActionListener(this);
		logoutBtn.setBounds(274, 16, 88, 29);
		panel.add(logoutBtn);
		
		MesBtn = new JButton("메세지");
		MesBtn.addActionListener(this);
		MesBtn.setBounds(70, 91, 88, 29);
		panel.add(MesBtn);
		
		BbsBtn = new JButton("게시판");
		BbsBtn.addActionListener(this);
		BbsBtn.setBounds(170, 91, 88, 29);
		panel.add(BbsBtn);
		
		oderBtn = new JButton("주문");
		oderBtn.addActionListener(this);
		oderBtn.setBounds(274, 91, 82, 29);
		panel.add(oderBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(67, 6, 199, 74);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel idLabel = new JLabel("이름");
		idLabel.setBounds(17, 6, 61, 16);
		idLabel.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(idLabel);
		
		JLabel timeLabel = new JLabel("남은 시간");
		timeLabel.setBounds(17, 34, 61, 16);
		panel_1.add(timeLabel);
		
		JLabel useLabel = new JLabel("사용 요금");
		useLabel.setBounds(17, 52, 61, 16);
		panel_1.add(useLabel);
		
		JLabel name_Label = new JLabel("홍길동");
		name_Label.setBounds(103, 6, 61, 16);
		panel_1.add(name_Label);
		
		JLabel time_Label = new JLabel("0:00");
		time_Label.setBounds(103, 34, 61, 16);
		panel_1.add(time_Label);
		
		JLabel use_Label = new JLabel("0원");
		use_Label.setBounds(103, 52, 61, 16);
		panel_1.add(use_Label);
		
		setUndecorated(true);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn == logoutBtn) {
			new LoginView();
			this.dispose();
		}else if(btn == MesBtn) {
			new ChatView();
		}else if(btn == BbsBtn) {
			new BbsListView();
		}else if(btn == oderBtn) {
			new OrderView();
		}
		
	}
}
