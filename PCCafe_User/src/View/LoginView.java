package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dto.MemberDto;
import Singleton.Singleton;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LoginView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton loginBtn;
	private JButton signupBtn;
	
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loginBtn = new JButton("로그인");
		loginBtn.setBounds(92, 231, 117, 29);
		contentPane.add(loginBtn);
		loginBtn.addActionListener(this);
		add(loginBtn);
		
		signupBtn = new JButton("회원가입");
		signupBtn.setBounds(231, 231, 117, 29);
		contentPane.add(signupBtn);
		signupBtn.addActionListener(this);
		add(signupBtn);
		
		
		textField = new JTextField();
		textField.setBounds(218, 56, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(218, 94, 130, 29);
		contentPane.add(passwordField);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(121, 61, 61, 16);
		contentPane.add(idLabel);
		
		JLabel psLabel = new JLabel("비밀번호");
		psLabel.setBounds(121, 100, 61, 16);
		contentPane.add(psLabel);
		
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn == loginBtn) {
			Singleton.getInstance().dto = new MemberDto(0, 0, "");
			
			new ControlView();
			this.dispose();
		}else if(btn == signupBtn) {
			new SignUpView();
			this.dispose();
		}
	}
}
