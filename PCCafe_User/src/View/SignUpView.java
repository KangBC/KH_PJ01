package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.MemberController;
import Dao.MemberDao;
import Dto.MemberDto;
import Singleton.Singleton;
import java.awt.Font;

public class SignUpView extends JFrame implements ActionListener {

	private Singleton sgt = Singleton.getInstance();
	private MemberController memctrl = sgt.memCtrl;

	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField pwField;
	private JTextField nameField;
	private JTextField phField;

	private JButton signupBtn;
	private JButton cancleBtn;
	private JButton idCheckBtn;

	private boolean idCheck;

	public SignUpView() {

		idCheck = false;

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel idlabel = new JLabel("아이디");
		idlabel.setBounds(76, 60, 61, 16);
		panel.add(idlabel);

		JLabel pwlabel = new JLabel("비밀번호");
		pwlabel.setBounds(76, 88, 61, 16);
		panel.add(pwlabel);

		JLabel namelabel = new JLabel("이름");
		namelabel.setBounds(76, 116, 61, 16);
		panel.add(namelabel);

		JLabel Phonelabel = new JLabel("핸드폰");
		Phonelabel.setBounds(76, 144, 61, 16);
		panel.add(Phonelabel);

		idField = new JTextField();
		idField.setBounds(193, 55, 130, 26);
		panel.add(idField);
		idField.setColumns(10);

		pwField = new JPasswordField();
		pwField.setBounds(193, 83, 130, 26);
		panel.add(pwField);

		nameField = new JTextField();
		nameField.setBounds(193, 111, 130, 26);
		panel.add(nameField);
		nameField.setColumns(10);

		phField = new JTextField();
		phField.setBounds(193, 139, 130, 26);
		panel.add(phField);
		phField.setColumns(10);

		signupBtn = new JButton("회원가입");
		signupBtn.setBounds(76, 222, 117, 29);
		signupBtn.addActionListener(this);
		panel.add(signupBtn);

		cancleBtn = new JButton("닫기");
		cancleBtn.setBounds(265, 222, 117, 29);
		cancleBtn.addActionListener(this);
		panel.add(cancleBtn);

		idCheckBtn = new JButton("확인");
		idCheckBtn.setFont(new Font("굴림", Font.PLAIN, 12));
		idCheckBtn.setBounds(359, 55, 61, 29);
		idCheckBtn.addActionListener(this);
		panel.add(idCheckBtn);

		setUndecorated(true);
		setVisible(true);
		setBounds(710, 380, 500, 320);
	}

	public boolean checkInputOnlyNumberAndAlphabet(String textInput) {

		char chrInput;

		if (textInput.equals("")) {
			return false;
		}
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

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		MemberDao dao = new Dao.MemberDao();

		MemberDto dto;

		if (btn == idCheckBtn) {
			boolean b = true;

			if (!checkInputOnlyNumberAndAlphabet(idField.getText())) {
				JOptionPane.showMessageDialog(null, "아이디에 특수문자 또는 공백이 있습니다.");
				b = false;
			}

			if (!memctrl.checkId(idField.getText())) {
				JOptionPane.showMessageDialog(null, "이미 있는 ID입니다.");
				b = false;
			}

			if (b) {
				idCheck = true;
			}
		} else if (btn == signupBtn) {
			boolean b = true;

			if (!idCheck) {
				JOptionPane.showMessageDialog(null, "ID 중복확인을 해주세요.");
				b = false;
			} else if (!checkInputOnlyNumberAndAlphabet(pwField.getText())) {
				JOptionPane.showMessageDialog(null, "비밀번호에 특수문자 또는 공백이 있습니다.");
				b = false;
			}

			if (b) {
				dto = new MemberDto(idField.getText(), pwField.getText(), nameField.getText(), phField.getText());

				if (memctrl.signUp(dto)) {
					memctrl.draw_login();
					this.dispose();
				}
			}
		} else if (btn == cancleBtn) {
			this.dispose();
		}
	}
}