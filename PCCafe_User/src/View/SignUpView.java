package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
import java.awt.Graphics;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

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
	private ImageIcon icon;

	private boolean idCheck;
	private JPanel panel_2;

	public SignUpView() {
		
		icon = new ImageIcon("back.png");

		idCheck = false;

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel idlabel = new JLabel("아이디");
		idlabel.setBounds(73, 85, 61, 16);
		panel.add(idlabel);

		JLabel pwlabel = new JLabel("비밀번호");
		pwlabel.setBounds(73, 113, 61, 16);
		panel.add(pwlabel);

		JLabel namelabel = new JLabel("이름");
		namelabel.setBounds(73, 141, 61, 16);
		panel.add(namelabel);

		JLabel Phonelabel = new JLabel("핸드폰");
		Phonelabel.setBounds(73, 169, 61, 16);
		panel.add(Phonelabel);

		idField = new JTextField();
		idField.setBounds(158, 85, 130, 26);
		panel.add(idField);
		idField.setColumns(10);

		pwField = new JPasswordField();
		pwField.setBounds(158, 113, 130, 26);
		panel.add(pwField);

		nameField = new JTextField();
		nameField.setBounds(158, 141, 130, 26);
		panel.add(nameField);
		nameField.setColumns(10);

		phField = new JTextField();
		phField.setBounds(158, 169, 130, 26);
		panel.add(phField);
		phField.setColumns(10);

		signupBtn = new JButton("회원가입");
		signupBtn.setBounds(58, 247, 117, 29);
		signupBtn.addActionListener(this);
		panel.add(signupBtn);

		cancleBtn = new JButton("닫기");
		cancleBtn.setBounds(239, 247, 117, 29);
		cancleBtn.addActionListener(this);
		panel.add(cancleBtn);

		idCheckBtn = new JButton("중복검사");
		idCheckBtn.setBounds(300, 85, 90, 29);
		idCheckBtn.setFont(new Font("굴림", Font.PLAIN, 12));
		idCheckBtn.addActionListener(this);
		panel.add(idCheckBtn);
		
		JPanel panel_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_1.setBounds(6, 6, 428, 35);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel signLabel = new JLabel("회원가입");
		signLabel.setForeground(Color.WHITE);
		signLabel.setBounds(6, 6, 90, 21);
		panel_1.add(signLabel);
		signLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		signLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(6, 53, 428, 251);
		panel.add(panel_2);

		setUndecorated(true);
		setVisible(true);
		setBounds(710, 380, 450, 320);
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
				JOptionPane.showMessageDialog(null, "사용 가능한 ID입니다.");
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
					this.dispose();
				}
			}
		} else if (btn == cancleBtn) {
			this.dispose();
		}
	}
}