package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ChatView extends JFrame {

	private JPanel contentPane;
	private JTextField mesField;


	public ChatView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextArea chatArea = new JTextArea();
		chatArea.setBounds(27, 6, 381, 200);
		chatArea.setEditable(false);
		panel.add(chatArea);
		
		mesField = new JTextField();
		mesField.setBounds(27, 217, 279, 31);
		panel.add(mesField);
		mesField.setColumns(10);
		
		JButton Button = new JButton("보내기");
		Button.setBounds(304, 218, 117, 29);
		panel.add(Button);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
}
