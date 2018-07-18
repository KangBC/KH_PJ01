package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controller.BbsController;
import Controller.MemberController;

import Controller.StuffController;
import Dto.MemberDto;
import Singleton.Singleton;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;

public class ControlView extends JFrame implements ActionListener {

	private MemberDto dto;
	private Singleton sgt = Singleton.getInstance();
	private MemberController memCtrl = sgt.memCtrl;
	private StuffController stuffCtrl = sgt.stuffCtrl;

	private JPanel contentPane, panel_2;
	private JButton MesBtn, BbsBtn, oderBtn, logoutBtn, bt_AD;
	private JLabel time_Label, use_Label;

	private Timer memTm;

	private JLabel lblNewLabel;
	javax.swing.Timer tm;
	int x = 0;
	String[] list = { "AD_4.png", "AD_5.png", "AD_6.png" };

	public ControlView() {
		dto = Singleton.getInstance().dto;
		tictoc();

		setBounds(1470, 0, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		logoutBtn = new JButton("로그아웃");
		logoutBtn.addActionListener(this);
		logoutBtn.setBounds(338, 12, 88, 29);
		panel.add(logoutBtn);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(14, 6, 310, 133);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel idLabel = new JLabel("이름 : ");
		idLabel.setFont(new Font("굴림", Font.BOLD, 18));
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setBounds(17, 15, 61, 26);
		idLabel.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(idLabel);

		JLabel timeLabel = new JLabel("남은 시간 : ");
		timeLabel.setFont(new Font("굴림", Font.BOLD, 16));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBounds(12, 47, 102, 26);
		panel_1.add(timeLabel);

		JLabel useLabel = new JLabel("사용 요금 : ");
		useLabel.setFont(new Font("굴림", Font.BOLD, 16));
		useLabel.setHorizontalAlignment(SwingConstants.CENTER);
		useLabel.setBounds(9, 84, 109, 26);
		panel_1.add(useLabel);

		JLabel name_Label = new JLabel("홍길동");
		name_Label.setFont(new Font("굴림", Font.BOLD, 18));
		name_Label.setHorizontalAlignment(SwingConstants.CENTER);
		name_Label.setBounds(122, 7, 119, 36);
		panel_1.add(name_Label);

		time_Label = new JLabel((sgt.dto.getR_time() / 60) + " : " + (sgt.dto.getR_time() % 60));
		time_Label.setFont(new Font("굴림", Font.BOLD, 18));
		time_Label.setHorizontalAlignment(SwingConstants.CENTER);
		time_Label.setBounds(130, 49, 93, 20);

		panel_1.add(time_Label);

		use_Label = new JLabel("0원");
		use_Label.setFont(new Font("굴림", Font.BOLD, 18));
		use_Label.setHorizontalAlignment(SwingConstants.CENTER);
		use_Label.setBounds(140, 84, 101, 26);
		panel_1.add(use_Label);

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(14, 151, 412, 49);
		panel.add(panel_2);

		MesBtn = new JButton("메세지");
		MesBtn.setBounds(22, 10, 88, 29);
		panel_2.add(MesBtn);

		BbsBtn = new JButton("게시판");
		BbsBtn.setBounds(161, 10, 88, 29);
		panel_2.add(BbsBtn);

		oderBtn = new JButton("주문");
		oderBtn.setBounds(305, 10, 82, 29);
		panel_2.add(oderBtn);

		// 광고 슬라이더
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(14, 212, 412, 266);
		panel.add(lblNewLabel);

		bt_AD = new JButton("");
		bt_AD.setBounds(14, 212, 412, 266);
		bt_AD.setOpaque(false);
		bt_AD.setContentAreaFilled(false);
		bt_AD.setBorder(null);
		panel.add(bt_AD);
		SetImageSize(2);

		tm = new javax.swing.Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SetImageSize(x);
				x += 1;
				if (x >= list.length) {
					x = 0;
				}
			}
		});
		tm.start();

		oderBtn.addActionListener(this);
		BbsBtn.addActionListener(this);
		MesBtn.addActionListener(this);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
	}

	public void SetImageSize(int i) {
		ImageIcon icon = new ImageIcon(list[i]);
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		lblNewLabel.setIcon(newImc);
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		if (btn == logoutBtn) {
			sgt.serCtrl.logOutSign();
			memCtrl.draw_login();
			memTm.cancel();
			this.dispose();
		} else if (btn == MesBtn) {
			sgt.serCtrl.Chat_ON();
		} else if (btn == BbsBtn) {
			// memCtrl.draw_bbsList();
		} else if (btn == oderBtn) {
			stuffCtrl.draw_orderView();
		} else if (btn == bt_AD) {
			try {
				Desktop.getDesktop().browse(new URI("http://www.xn--961bz0ao46a.com/"));
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e2) {
				e2.printStackTrace();
			}
		}
	}

	public void tictoc() {
      memTm = new Timer(true);
      TimerTask tmt = new TimerTask() {
         public void run() {
            memCtrl.tictoc(sgt.dto);
            String time = (sgt.dto.getR_time() / 60) +" : " + (sgt.dto.getR_time() % 60);
            time_Label.setText(time);
            
            if(sgt.dto.getR_time() == 0) {
               memCtrl.ctrlView.dispose();
               memCtrl.draw_login();
               sgt.dto = null;
               memTm.cancel();
            }
         }
      };
      memTm.scheduleAtFixedRate(tmt, 60000, 60000);   
   }
}
