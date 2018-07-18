package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Dto.MemberDto;
import Singleton.Singleton;

public class ManageMemView extends JFrame implements ActionListener {

	private static final String String = null;

	private JPanel contentPane;
	private JTextField ID_JTectField;
	private JTextField TMINUTE_textField;
	private JTextField Psword_textField;
	private JButton Upate_button;// 수정
	private JButton Search_Button;// 검색
	private JButton success; // 완료

	MemberDto dto = new MemberDto();

	Singleton mc = Singleton.getInstance();

	// 아이디 검색을 누르고, 아이디가 있는지 없는지 체크
	boolean check_id = false;

	public ManageMemView() {

		super("회원정보");
		setAutoRequestFocus(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel ID_JLabel = new JLabel("ID :\r\n");
		ID_JLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		ID_JLabel.setBounds(14, 82, 126, 69);
		panel.add(ID_JLabel);

		ID_JTectField = new JTextField();
		ID_JTectField.setColumns(10);
		ID_JTectField.setBounds(132, 98, 273, 40);
		panel.add(ID_JTectField);

		JLabel TMINUTE_label = new JLabel("이용시간 :");
		TMINUTE_label.setFont(new Font("굴림", Font.PLAIN, 20));
		TMINUTE_label.setBounds(14, 208, 126, 69);
		panel.add(TMINUTE_label);

		TMINUTE_textField = new JTextField();
		TMINUTE_textField.setColumns(10);
		TMINUTE_textField.setEditable(false);
		TMINUTE_textField.setBounds(132, 224, 273, 40);
		panel.add(TMINUTE_textField);

		JLabel Pssword_JLabel = new JLabel("PSSWORD :");
		Pssword_JLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		Pssword_JLabel.setBounds(14, 351, 126, 69);
		panel.add(Pssword_JLabel);

		Psword_textField = new JTextField();
		Psword_textField.setBounds(132, 367, 273, 40);
		panel.add(Psword_textField);
		Psword_textField.setColumns(10);

		Search_Button = new JButton("검색");
		Search_Button.setBounds(433, 95, 138, 46);
		panel.add(Search_Button);
		Search_Button.addActionListener(this);

		Upate_button = new JButton("수정");
		Upate_button.setBounds(433, 364, 138, 46);
		panel.add(Upate_button);
		Upate_button.addActionListener(this);

		success = new JButton("완료");
		success.setBounds(175, 493, 176, 85);
		panel.add(success);
		success.addActionListener(this);
		
		setVisible(true);
		setBounds(670, 220, 620, 700);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// 종료
		if (obj == success) {
			dispose(); // 현재 창을 닫음

			// 유저 검색
		} else if (obj == Search_Button) {
			dto = null;
			String selectedItem = (String) ID_JTectField.getText();
			System.out.println("selectedItem(1) : " + selectedItem);

			// 필드 텍스트값을 searchUser에 인자로 넣고 해당 결과를 dto에 담음.
			dto = mc.memCtrl.getSearchUser(selectedItem);
			// 증상 : 이름 검색을 안누르고 Password 바꾸면 설정이됨.
			// 임시로 작업함.
			// dto == null 회원 정보 없음
			if (dto == null) {
				check_id = false;
				// dto != null 회원 정보 있음
			} else {
				check_id = true;
			}

			System.out.println("selectedItem(5) : " + dto.getR_time());
			String timeToString = Integer.toString(dto.getR_time());
			TMINUTE_textField.setText(timeToString);

			// Password 수정
		} else if (obj == Upate_button) {
			if (check_id) {
				String id = ID_JTectField.getText();
				String pw = Psword_textField.getText();

				mc.memCtrl.changePW(id, pw);
			} else {
				JOptionPane.showMessageDialog(null, " 검색을 먼저하세요. ");

			}
		}

	}
}
