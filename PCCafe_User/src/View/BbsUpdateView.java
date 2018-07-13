package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BbsUpdateView extends JFrame {

	private JPanel contentPane;

	JTextField idTextfield;
	JTextField wdateTextfield;
	JTextField readCountTextfield;
	JTextField titleTextfield;
	
	JTextArea contentArea;
	
	public BbsUpdateView() {
		super();
		
		System.out.println();
		getContentPane().setLayout(null);
		
		JLabel writerLabel = new JLabel("작성자:");
		writerLabel.setBounds(10, 39, 60, 15);
		getContentPane().add(writerLabel);
				
		idTextfield = new JTextField();
		idTextfield.setBounds(120, 36, 200, 20);
		idTextfield.setEditable(false);		
		getContentPane().add(idTextfield);

		JLabel titleLabel = new JLabel("제목:");
		titleLabel.setBounds(10, 71, 60, 15);
		getContentPane().add(titleLabel);
		
		titleTextfield = new JTextField();
		titleTextfield.setBounds(120, 68, 200, 20);
		getContentPane().add(titleTextfield);
		
		JLabel contentLabel = new JLabel("내용:");
		contentLabel.setBounds(10, 128, 60, 15);
		getContentPane().add(contentLabel);
				
		contentArea = new JTextArea();		
		contentArea.setLineWrap(true);	
			
		JScrollPane scrPane = new JScrollPane(contentArea);
		scrPane.setBounds(10, 160, 460, 300);
		scrPane.setPreferredSize(new Dimension(200, 120));
		getContentPane().add(scrPane);		
		
		JButton bbsBtn = new JButton("게시판목록");
		bbsBtn.setBounds(20, 476, 100, 20);
		getContentPane().add(bbsBtn);
		
		JButton updateBtn = new JButton("수정 하기");
		updateBtn.setBounds(353, 472, 117, 29);
		getContentPane().add(updateBtn);
		
		setBounds(100, 100, 500, 600);
		setVisible(true);
		
		
	}

	

}
