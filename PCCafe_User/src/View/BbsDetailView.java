package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Dto.BbsDto;
import Singleton.Singleton;

public class BbsDetailView extends JFrame {

	JTextField idTextfield;
	JTextField wdateTextfield;
	JTextField readCountTextfield;
	JTextField titleTextfield;
	JTextArea contentArea;
	
	Singleton sc = Singleton.getInstance();
	
	public BbsDetailView(BbsDto dto) {
		super("내용 보기");		
		
		setLayout(null);
		
		JLabel writerLabel = new JLabel("작성자:");
		writerLabel.setBounds(10, 10, 50, 15);
		add(writerLabel);
				
		idTextfield = new JTextField(dto.getUserID()); 
		idTextfield.setBounds(70, 8, 200, 20);
		idTextfield.setBorder(BorderFactory.createEmptyBorder());
		idTextfield.setEditable(false);		
		add(idTextfield);
		
		JLabel writedLabel = new JLabel("작성일:");
		writedLabel.setBounds(10, 40, 50, 15);
		add(writedLabel);
		
		wdateTextfield = new JTextField(dto.getCreatedDate());
		wdateTextfield.setBounds(70, 38, 200, 20);
		wdateTextfield.setEditable(false);		
		wdateTextfield.setBorder(BorderFactory.createEmptyBorder());
		add(wdateTextfield);
		
		JLabel readLabel = new JLabel("조회수:");
		readLabel.setBounds(10, 70, 50, 15);
		add(readLabel);
		
		readCountTextfield = new JTextField(dto.getReadCount() + "");
		readCountTextfield.setBounds(70, 68, 200, 20);
		readCountTextfield.setEditable(false);		
		readCountTextfield.setBorder(BorderFactory.createEmptyBorder());
		add(readCountTextfield);
		
		JLabel titleLabel = new JLabel("제목    :");
		titleLabel.setBounds(10, 100, 50, 15);
		add(titleLabel);
		
		titleTextfield = new JTextField(dto.getTitle());
		titleTextfield.setBounds(70, 98, 300, 20);
		titleTextfield.setEditable(false);	
		titleTextfield.setBorder(BorderFactory.createEmptyBorder());
		add(titleTextfield);
		
		JLabel contentLabel = new JLabel("내용    :");
		contentLabel.setBounds(10, 130, 50, 15);
		add(contentLabel);
				
		contentArea = new JTextArea(dto.getContent());
		contentArea.setEditable(false);
		contentArea.setLineWrap(true);	
			
		JScrollPane scrPane = new JScrollPane(contentArea);
		scrPane.setPreferredSize(new Dimension(200, 120));
		scrPane.setBounds(10, 160, 460, 364);
		add(scrPane);		
		
		//Button
		JButton bbsBtn = new JButton("게시판목록");
		bbsBtn.setBorderPainted(true);
		bbsBtn.setContentAreaFilled(false);
		bbsBtn.setFocusable(false);
		bbsBtn.setForeground(Color.black);
		bbsBtn.setBounds(10, 554, 100, 40);		
		bbsBtn.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {	
				sc.bbsCtrl.repaintBbsList();;
				dispose();
			}
		});
		add(bbsBtn);
		
		// updatebutton
		JButton updateBtn = null;		
		updateBtn = new JButton("수정");
		updateBtn.setBorderPainted(true);
		updateBtn.setContentAreaFilled(false);
		updateBtn.setFocusable(false);
		updateBtn.setForeground(Color.black);
		updateBtn.setBounds(250, 554, 100, 40);
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Singleton sc = Singleton.getInstance();
				sc.bbsCtrl.bbsUpdate(dto.getPostNum());
				dispose();
			}
		});
		add(updateBtn);
		
		// deletebutton
		JButton deleteBtn = null;		
		deleteBtn = new JButton("삭제");
		deleteBtn.setBorderPainted(true);
		deleteBtn.setContentAreaFilled(false);
		deleteBtn.setFocusable(false);
		deleteBtn.setForeground(Color.black);
		deleteBtn.setBounds(370, 554, 100, 40);
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					
				sc.bbsCtrl.bbsDelete(dto.getPostNum());		
				sc.bbsCtrl.repaintBbsList();
				dispose();
			}
		});
		add(deleteBtn);
		
		if(!dto.getUserID().equals(sc.dto.getId())){ 
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
		}
		
		setBounds(550, 200, 500, 700);		
		setVisible(true);
	}

}

