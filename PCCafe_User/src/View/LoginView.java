package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn == loginBtn) {
			new ControlView();
			this.dispose();
		}else if(btn == signupBtn) {
			new SignUpView();
			this.dispose();
		}
		
		/* <특수문자 한글 금지 시키는 함수.>
		public boolean checkInputOnlyNumberAndAlphabet(String textInput) {
			char chrInput;
			for (int i = 0; i < textInput.length(); i++) {
			chr = textInput.charAt(i); // 입력받은 텍스트에서 문자 하나하나 가져와서 체
			if (chrInput >= 0x61 && chrInput <= 0x7A) {
			    // 영문(소문자) OK!
			} 
			else if (chrInput >=0x41 && chrInput <= 0x5A) {
			    // 영문(대문자) OK!
			}
			else if (chrInput >= 0x30 && chrInput <= 0x39) {

			    // 숫자 OK!
			} 
			else {
			    return false;   // 영문자도 아니고 숫자도 아님!
			}
			}
			return true;
			}
			*/

		
		
		
	}
}
