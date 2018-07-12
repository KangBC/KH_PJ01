package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class ChatView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;

	public ChatView() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 700);// 전체틀

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(118, 527, 286, 24);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(0, 0, 568, 479);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("사용자에게:");
		lblNewLabel.setBounds(36, 530, 90, 18);
		panel.add(lblNewLabel);

		btnNewButton = new JButton("전송");
		btnNewButton.setBounds(418, 526, 105, 27);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(this);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}