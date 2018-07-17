package View;

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
	
	public BbsDetailView(BbsDto dto) {
		super("내용 보기");		
		
		setLayout(null);
		
		JLabel writerLabel = new JLabel("작성자:");
		writerLabel.setBounds(10, 10, 60, 15);
		add(writerLabel);
				
		idTextfield = new JTextField(dto.getUserNum());
		idTextfield.setBounds(120, 10, 200, 20);
		idTextfield.setEditable(false);		
		add(idTextfield);
		
		JLabel writedLabel = new JLabel("작성일:");
		writedLabel.setBounds(10, 40, 60, 15);
		add(writedLabel);
		
		wdateTextfield = new JTextField(dto.getCreatedDate());
		wdateTextfield.setBounds(120, 40, 200, 20);
		wdateTextfield.setEditable(false);		
		add(wdateTextfield);
		
		JLabel readLabel = new JLabel("조회수:");
		readLabel.setBounds(10, 70, 60, 15);
		add(readLabel);
		
		readCountTextfield = new JTextField(dto.getReadCount() + "");
		readCountTextfield.setBounds(120, 70, 200, 20);
		readCountTextfield.setEditable(false);		
		add(readCountTextfield);
		
		JLabel titleLabel = new JLabel("제목:");
		titleLabel.setBounds(10, 100, 60, 15);
		add(titleLabel);
		
		titleTextfield = new JTextField(dto.getTitle());
		titleTextfield.setBounds(120, 100, 300, 20);
		titleTextfield.setEditable(false);		
		add(titleTextfield);
		
		JLabel contentLabel = new JLabel("내용:");
		contentLabel.setBounds(10, 130, 60, 15);
		add(contentLabel);
				
		contentArea = new JTextArea(dto.getContent());
		contentArea.setEditable(false);
		contentArea.setLineWrap(true);	
			
		JScrollPane scrPane = new JScrollPane(contentArea);
		scrPane.setPreferredSize(new Dimension(200, 120));
		scrPane.setBounds(10, 160, 460, 300);
		add(scrPane);		
		
		JButton bbsBtn = new JButton("게시판목록");
		bbsBtn.setBounds(10, 480, 100, 20);		
		add(bbsBtn);
		
		setBounds(100, 100, 500, 600);
		setVisible(true);
		
		
		Singleton sc = Singleton.getInstance();
		
		// updatebutton
		JButton updateBtn = null;		
		updateBtn = new JButton("수정");
		updateBtn.setBounds(150, 480, 100, 20);
		add(updateBtn);
		/*
		// 수정버튼의 비활성화(같은 id일 경우만)
		if(!dto.getUserNum().equals(sc.memCtrl.getLoginId())){
			updateBtn.setEnabled(false);
		}
		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				Singleton sc = Singleton.getInstance();
				sc.bbsCtrl.bbsUpdate(dto.getSeq());
				dispose();
			}
		});
		
		// deletebutton
		JButton deleteBtn = null;		
		deleteBtn = new JButton("삭제");
		deleteBtn.setBounds(290, 480, 100, 20);
		add(deleteBtn);
		
		// 삭제버튼의 비활성화(같은 id일 경우만)		
		if(!dto.getUserNum().equals(sc.memCtrl.getLoginId())){ // MemberController가없어서 안됨.
			deleteBtn.setEnabled(false);
		}
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {					
				Singleton sc = Singleton.getInstance();
				sc.bbsCtrl.bbsDelete(dto.getSeq());				
				dispose();
			}
		});
		
		*/
		
		bbsBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {	
				Singleton sc = Singleton.getInstance();
				sc.bbsCtrl.getBbsList();
				dispose();
			}
		});
	}

}
