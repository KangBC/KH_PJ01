package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChatView extends JFrame implements ActionListener {
	
	List<Socket> list = new ArrayList<Socket>();	// server 생성 List 선언
	
	// 소켓생성 
	ServerSocket serSock;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;


	public ChatView() {

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

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 700);// 전체틀
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}