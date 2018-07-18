package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Dto.BbsDto;
import Singleton.Singleton;

public class BbsUpateview extends JFrame{
		
	JTextField idTextfield;
	JTextField wdateTextfield;
	JTextField readCountTextfield;
	JTextField titleTextfield;
	JTextArea contentArea;
	
	Singleton sc = Singleton.getInstance();
	
	public BbsUpateview(BbsDto dto) {
		super("수정");	
				
		getContentPane().setLayout(null);
		
		JLabel writerLabel = new JLabel("작성자:");
		writerLabel.setBounds(10, 10, 60, 15);
		getContentPane().add(writerLabel);
				
		idTextfield = new JTextField(dto.getUserID());
		idTextfield.setBounds(120, 10, 200, 20);
		idTextfield.setEditable(false);		
		getContentPane().add(idTextfield);
		
		JLabel writedLabel = new JLabel("작성일:");
		writedLabel.setBounds(10, 40, 60, 15);
		getContentPane().add(writedLabel);
		
		wdateTextfield = new JTextField(dto.getCreatedDate());
		wdateTextfield.setBounds(120, 40, 200, 20);
		wdateTextfield.setEditable(false);		
		getContentPane().add(wdateTextfield);
		
		JLabel readLabel = new JLabel("조회수:");
		readLabel.setBounds(10, 70, 60, 15);
		getContentPane().add(readLabel);
		
		readCountTextfield = new JTextField(dto.getReadCount() + "");
		readCountTextfield.setBounds(120, 70, 200, 20);
		readCountTextfield.setEditable(false);		
		getContentPane().add(readCountTextfield);
		
		JLabel titleLabel = new JLabel("제목:");
		titleLabel.setBounds(10, 100, 60, 15);
		getContentPane().add(titleLabel);
		
		titleTextfield = new JTextField(dto.getTitle());
		titleTextfield.setBounds(120, 100, 300, 20);			
		getContentPane().add(titleTextfield);
		
		JLabel contentLabel = new JLabel("내용:");
		contentLabel.setBounds(10, 130, 60, 15);
		getContentPane().add(contentLabel);
				
		contentArea = new JTextArea(dto.getContent());		
		contentArea.setLineWrap(true);	
			
		JScrollPane scrPane = new JScrollPane(contentArea);
		scrPane.setPreferredSize(new Dimension(200, 120));
		scrPane.setBounds(10, 160, 460, 386);
		getContentPane().add(scrPane);		
		
		JButton bbsBtn = new JButton("게시판목록");
		bbsBtn.setBorderPainted(true);
		bbsBtn.setContentAreaFilled(false);
		bbsBtn.setFocusable(false);
		bbsBtn.setForeground(Color.black);
		bbsBtn.setBounds(10, 570, 100, 40);		
		getContentPane().add(bbsBtn);
		
		setVisible(true);
		setBounds(550, 200, 500, 700);
		
		// updatebutton
		JButton updateBtn = null;		
		updateBtn = new JButton("수정완료");
		updateBtn.setBorderPainted(true);// 버튼테두리
		updateBtn.setContentAreaFilled(false);
		updateBtn.setFocusable(false);
		updateBtn.setForeground(Color.black);
		updateBtn.setBounds(370, 570, 100, 40);
		getContentPane().add(updateBtn);
		updateBtn.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {					
				String title = titleTextfield.getText();
				String content = contentArea.getText();
				
				if(title.equals("") || content.equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸을 모두 작성해 주십시오");
					return;
				}
				
				// 수정부분 db
				sc.bbsCtrl.bbsUpdateAf(dto.getPostNum(), 
							titleTextfield.getText(), 
							contentArea.getText());
				dispose();			
			}
		});
		
		bbsBtn.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {					
				sc.bbsCtrl.repaintBbsList();;
				dispose();
			}
		});	
	}
}
