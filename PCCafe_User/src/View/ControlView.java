package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controller.BbsController;
import Controller.MemberController;
import Controller.StuffController;
import Dao.MemberDao;
import Dto.MemberDto;
import Singleton.Singleton;

import java.awt.Color;

public class ControlView extends JFrame implements ActionListener{

	private MemberDto dto;
	private Singleton sgt = Singleton.getInstance();
	private MemberController memCtrl = sgt.memCtrl;
	private BbsController bbsCtrl = sgt.bbsCtrl;
	private StuffController stuffCtrl = sgt.stuffCtrl;
	
	private JPanel contentPane;
	
	private JButton MesBtn;
	private JButton BbsBtn;
	private JButton oderBtn;
	private JButton logoutBtn;
	
	private JLabel time_Label;
	private JLabel use_Label;
	
	public ControlView() {
		dto = Singleton.getInstance().dto;
		tictoc();
		
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
		
		time_Label = new JLabel((dto.getR_time()/60) +" : " + (dto.getR_time()%60));
		time_Label.setBounds(103, 34, 61, 16);
		panel_1.add(time_Label);
		
		use_Label = new JLabel("0원");
		use_Label.setBounds(103, 52, 61, 16);
		panel_1.add(use_Label);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);;
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn == logoutBtn) {
			memCtrl.draw_login();
			this.dispose();
		}else if(btn == MesBtn) {
			memCtrl.draw_Chat();
		}else if(btn == BbsBtn) {
			//bbsCtrl.draw_bbsList();
		}else if(btn == oderBtn) {
			stuffCtrl.draw_orderView();
		}
	}
	
	public void tictoc() {
		Timer tm = new Timer(true);
		TimerTask tmt = new TimerTask() {
			public void run() {
				memCtrl.tictoc(sgt.dto);
				String time = (sgt.dto.getR_time() / 60) +" : " + (sgt.dto.getR_time() % 60);
				time_Label.setText(time);
				
				if(sgt.dto.getR_time() == 0) {
					memCtrl.ctrlView.dispose();
					memCtrl.draw_login();
					sgt.dto = null;
				}
			}
		};
		tm.scheduleAtFixedRate(tmt, 60000, 60000);	
	}
}
