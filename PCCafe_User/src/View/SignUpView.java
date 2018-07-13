package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dto.MemberDto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class SignUpView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField pwdField;
	private JTextField nameField;
	private JTextField PhField;
	
	private JButton signupBtn;
	private JButton escBtn;
	private JButton idCheckBtn;
	

	
	public SignUpView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel textField1 = new JPanel();
		contentPane.add(textField1, BorderLayout.CENTER);
		textField1.setLayout(null);
		
		
		
		JLabel idlabel = new JLabel("아이디");
		idlabel.setBounds(91, 40, 61, 16);
		textField1.add(idlabel);
		
		
		JLabel pwlabel = new JLabel("비밀번호");
		pwlabel.setBounds(91, 68, 61, 16);
		textField1.add(pwlabel);
		
		JLabel namelabel = new JLabel("이름");
		namelabel.setBounds(91, 96, 61, 16);
		textField1.add(namelabel);
		
		JLabel Phonelabel = new JLabel("핸드폰");
		Phonelabel.setBounds(91, 124, 61, 16);
		textField1.add(Phonelabel);
		
		idField = new JTextField();
		idField.setBounds(208, 35, 130, 26);
		textField1.add(idField);
		idField.setColumns(10);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(208, 63, 130, 26);
		textField1.add(pwdField);
		
		nameField = new JTextField();
		nameField.setBounds(208, 91, 130, 26);
		textField1.add(nameField);
		nameField.setColumns(10);
		
		PhField = new JTextField();
		PhField.setBounds(208, 119, 130, 26);
		textField1.add(PhField);
		PhField.setColumns(10);
		
		signupBtn = new JButton("회원가입");
		signupBtn.setBounds(91, 202, 117, 29);
		signupBtn.addActionListener(this);
		textField1.add(signupBtn);
		
		
		escBtn = new JButton("취소");
		escBtn.setBounds(208, 202, 117, 29);
		textField1.add(escBtn);
		
		idCheckBtn = new JButton("확인");
		idCheckBtn.setBounds(381, 35, 54, 29);
		idCheckBtn.addActionListener(this);
		textField1.add(idCheckBtn);
		escBtn.addActionListener(this);
		
		
		setUndecorated(true);
		setVisible(true);
	}

	public boolean checkInputOnlyNumberAndAlphabet(String textInput) {

		char chrInput;

		for (int i = 0; i < textInput.length(); i++) {

			chrInput = textInput.charAt(i); // 입력받은 텍스트에서 문자 하나하나 가져와서 체크

			if (chrInput >= 0x61 && chrInput <= 0x7A) {
				// 영문(소문자) OK!
			} else if (chrInput >= 0x41 && chrInput <= 0x5A) {
				// 영문(대문자) OK!
			} else if (chrInput >= 0x30 && chrInput <= 0x39) {

				// 숫자 OK!
			} else {
				return false; // 영문자도 아니고 숫자도 아님!

			}
		}
		return true;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		MemberDto dto = new MemberDto(idField.getText(),pwdField.getText(),
									nameField.getText(),PhField.getText());	//DB로 갈수있게 가공
		
		/*
		if(btn == signupBtn) {
			if() {
				this.dispose();
				new LoginView();
			}else {
				boolean b = checkInputOnlyNumberAndAlphabet(idField.getText());
		         if(b) {
		            JOptionPane.showMessageDialog(null, "아이디에 특수문자 또는 공백이 있습니다.");
		         }
			}
			
		}else if(btn == escBtn) {
			new LoginView();
			this.dispose();
		}else if(btn == idCheckBtn) {
			
		}
		*/
	/*	 <회원가입할때 아이디에서 특수문자,공백 못주게하는 부분>
	boolean b = checkInputOnlyNumberAndAlphabet(idField.getText());
         if(b) {
            JOptionPane.showMessageDialog(null, "아이디에 특수문자 또는 공백이 있습니다.");
         }
	*/
	}
}
