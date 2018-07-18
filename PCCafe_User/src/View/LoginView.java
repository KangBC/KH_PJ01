package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

public class LoginView extends JFrame implements ActionListener, KeyListener {

	Singleton sgt = Singleton.getInstance();
	MemberController memCtrl = sgt.memCtrl;

	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField pwField;
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

		idField = new JTextField();
		idField.setBounds(218, 56, 130, 26);
		idField.setColumns(10);
		idField.addKeyListener(this);
		contentPane.add(idField);

		pwField = new JPasswordField();
		pwField.setBounds(218, 94, 130, 29);
		pwField.addKeyListener(this);
		contentPane.add(pwField);

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
<<<<<<< HEAD
		JButton btn = (JButton)e.getSource();
		
		if(btn == loginBtn) {
			if(memCtrl.login(idField.getText(), pwField.getText())) {
					this.dispose();
			}else {
=======
		JButton btn = (JButton) e.getSource();

		if (btn == loginBtn) {
			if (memCtrl.login(idField.getText(), pwField.getText())) {
				sgt.serCtrl.sendLoginSign();
				sgt.serCtrl.sendMsg(idField.getText());
				this.dispose();
			} else {
>>>>>>> 86ecf272e9df3e0a48e23b0a6bc47e042d5b7b1f
				pwField.setText("");
			}
		} else if (btn == signupBtn) {
			memCtrl.draw_Signup();
			this.dispose();
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
