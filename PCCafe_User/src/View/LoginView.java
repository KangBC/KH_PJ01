package View;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.MemberController;
import Singleton.Singleton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class LoginView extends JFrame implements ActionListener, KeyListener {

	Singleton sgt = Singleton.getInstance();
	MemberController memCtrl = sgt.memCtrl;

	private JTextField idField;
	private JPasswordField pwField;
	private JButton loginBtn, signupBtn;

	// AD
	private JLabel lb_AD;
	javax.swing.Timer tm;
	int x = 0;
	String[] list = { "AD_1.png", "AD_2.png", "AD_3.png" };

	public LoginView() {
		ImageIcon icon = new ImageIcon("userMain.png");
		JPanel contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel pl_box = new JPanel();
		pl_box.setBackground(Color.GRAY);
		pl_box.setBounds(1306, 697, 614, 371);
		contentPane.add(pl_box);
		pl_box.setLayout(null);

		loginBtn = new JButton("로그인");
		loginBtn.setBounds(409, 75, 143, 67);
		pl_box.add(loginBtn);

		signupBtn = new JButton("회원가입");
		signupBtn.setBounds(492, 11, 108, 33);
		pl_box.add(signupBtn);

		idField = new JTextField();
		idField.setBounds(174, 75, 221, 26);
		pl_box.add(idField);
		idField.setColumns(10);

		pwField = new JPasswordField();
		pwField.setBounds(174, 113, 221, 29);
		pl_box.add(pwField);

		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(new Font("굴림", Font.BOLD, 18));
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setBounds(64, 74, 96, 29);
		pl_box.add(idLabel);

		JLabel psLabel = new JLabel("비밀번호");
		psLabel.setFont(new Font("굴림", Font.BOLD, 18));
		psLabel.setHorizontalAlignment(SwingConstants.CENTER);
		psLabel.setBounds(64, 114, 96, 26);
		pl_box.add(psLabel);

		// 광고 슬라이더
		lb_AD = new JLabel();
		lb_AD.setBounds(78, 154, 474, 188);
		pl_box.add(lb_AD);
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

		pwField.addKeyListener(this);
		idField.addKeyListener(this);
		signupBtn.addActionListener(this);
		loginBtn.addActionListener(this);
		setContentPane(contentPane);
		setBounds(0, 0, 1920, 1080);
	}

	public void SetImageSize(int i) {
		ImageIcon icon = new ImageIcon(list[i]);
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(lb_AD.getWidth(), lb_AD.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		lb_AD.setIcon(newImc);
	}

	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		if (obj == loginBtn) {
			if (memCtrl.login(idField.getText(), pwField.getText())) {
				sgt.serCtrl.connectServer(); // 서버연결
				sgt.serCtrl.sendLoginSign(); // 로그인 아이디 준비 커멘드
				sgt.serCtrl.sendMsg(idField.getText()); // 아이디 전송
				this.dispose();
			} else {
				pwField.setText("");
			}
		} else if (obj == signupBtn) {
			memCtrl.draw_Signup();
		}
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		JTextField tf = (JTextField) e.getSource();
		String tfName = tf.getName();
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			loginBtn.doClick();
		}
	}

	public void keyTyped(KeyEvent e) {
	}
}