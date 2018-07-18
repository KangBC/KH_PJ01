package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		titleTextfield.setEditable(false);		
		getContentPane().add(titleTextfield);
		
		JLabel contentLabel = new JLabel("내용:");
		contentLabel.setBounds(10, 130, 60, 15);
		getContentPane().add(contentLabel);
				
		contentArea = new JTextArea(dto.getContent());
		contentArea.setEditable(false);
		contentArea.setLineWrap(true);	
			
		JScrollPane scrPane = new JScrollPane(contentArea);
		scrPane.setPreferredSize(new Dimension(200, 120));
		scrPane.setBounds(10, 160, 460, 364);
		getContentPane().add(scrPane);		
		
		//Button
		JButton bbsBtn = new JButton("게시판목록");
		bbsBtn.setBorderPainted(true);
		bbsBtn.setContentAreaFilled(false);
		bbsBtn.setFocusable(false);
		bbsBtn.setForeground(Color.black);
		bbsBtn.setBounds(10, 554, 100, 40);		
		getContentPane().add(bbsBtn);
		
		setBounds(550, 200, 500, 700);		
		setVisible(true);
		
		// updatebutton
		JButton updateBtn = null;		
		updateBtn = new JButton("수정");
		updateBtn.setBorderPainted(true);
		updateBtn.setContentAreaFilled(false);
		updateBtn.setFocusable(false);
		updateBtn.setForeground(Color.black);
		updateBtn.setBounds(183, 554, 100, 40);
		getContentPane().add(updateBtn);
		
	/*	MemberController가없어서 안됨. 일단 주석처리
		수정버튼의 비활성화(같은 id일 경우만)
		if(!dto.getUserNum().equals(sc.memCtrl.getLoginId())){ // MemberController가없어서 안됨.
			updateBtn.setEnabled(false);
		}*/
		
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Singleton sc = Singleton.getInstance();
				sc.bbsCtrl.bbsUpdate(dto.getPostNum());
				dispose();
			}
		});
		
		// deletebutton
		JButton deleteBtn = null;		
		deleteBtn = new JButton("삭제");
		deleteBtn.setBorderPainted(true);
		deleteBtn.setContentAreaFilled(false);
		deleteBtn.setFocusable(false);
		deleteBtn.setForeground(Color.black);
		deleteBtn.setBounds(370, 554, 100, 40);
		getContentPane().add(deleteBtn);
		
		// MemberController가없어서 안됨.
	/*	// 삭제버튼의 비활성화(같은 id일 경우만)		
		if(!dto.getUserNum().equals(sc.memCtrl.getLoginId())){ 
			deleteBtn.setEnabled(false);
		}*/
		
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {					
				sc.bbsCtrl.bbsDelete(dto.getPostNum());				
				dispose();
			}
		});
		
		bbsBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {	
				sc.bbsCtrl.drawBbsList();
				dispose();
			}
		});
	}

}
