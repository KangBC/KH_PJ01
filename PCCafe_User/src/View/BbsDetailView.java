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


public class BbsDetailView extends JFrame {

	JTextField idTextfield;
	JTextField titleTextfield;
	
	JTextArea contentArea;
	private JPanel contentPane;

	public BbsDetailView() {
		super();		
		
		
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
		contentLabel.setBounds(10, 130, 60, 15);
		getContentPane().add(contentLabel);
				
		contentArea = new JTextArea();
		contentArea.setEditable(false);
		contentArea.setLineWrap(true);	
			
		JScrollPane scrPane = new JScrollPane(contentArea);
		scrPane.setPreferredSize(new Dimension(200, 120));
		scrPane.setBounds(10, 160, 460, 300);
		getContentPane().add(scrPane);		
		
		JButton bbsBtn = new JButton("게시판목록");
		bbsBtn.setBounds(10, 480, 100, 20);		
		getContentPane().add(bbsBtn);
		
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setBounds(260, 480, 100, 20);		
		getContentPane().add(deleteBtn);
		
		setBounds(100, 100, 500, 600);
		setVisible(true);
		
	
		JButton updateBtn = null;		
		updateBtn = new JButton("수정");
		updateBtn.setBounds(150, 480, 100, 20);
		getContentPane().add(updateBtn);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BbsDetailView frame = new BbsDetailView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
