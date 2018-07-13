package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class ManageMemView extends JFrame implements ActionListener, WindowListener {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton button_1, button_2, button_3, button_4;

	public ManageMemView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 517);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(125, 35, 170, 41);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(125, 100, 170, 41);
		panel.add(passwordField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(125, 175, 170, 41);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(125, 228, 169, 41);
		panel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(125, 288, 169, 41);
		panel.add(textField_3);

		button_1 = new JButton("검색");
		button_1.setBounds(324, 35, 105, 41);
		panel.add(button_1);
		button_1.addActionListener(this);

		button_2 = new JButton("수정");
		button_2.setBounds(324, 100, 105, 41);
		panel.add(button_2);
		button_2.addActionListener(this);

		button_3 = new JButton("수정");
		button_3.setBounds(38, 385, 105, 41);
		panel.add(button_3);

		button_3.addActionListener(this);

		button_4 = new JButton("완료");
		button_4.setBounds(324, 385, 105, 41);
		panel.add(button_4);

		button_4.addActionListener(this);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(49, 46, 62, 18);
		panel.add(lblNewLabel);

		JLabel label_3 = new JLabel("총 누적시간");
		label_3.setBounds(26, 299, 85, 18);
		panel.add(label_3);

		JLabel lblP = new JLabel("password");
		lblP.setBounds(38, 111, 73, 18);
		panel.add(lblP);

		JLabel label_1 = new JLabel("사용시간");
		label_1.setBounds(49, 186, 62, 18);
		panel.add(label_1);

		JLabel label_2 = new JLabel("남은시간");
		label_2.setBounds(49, 239, 62, 18);
		panel.add(label_2);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == button_4) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
				dispose(); // 현재 창을 닫음
				
				}
			});
		}
	}
}